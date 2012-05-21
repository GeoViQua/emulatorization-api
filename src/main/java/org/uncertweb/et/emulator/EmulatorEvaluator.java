package org.uncertweb.et.emulator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.uncertweb.et.Config;
import org.uncertweb.et.ConfigException;
import org.uncertweb.et.MATLAB;
import org.uncertweb.et.design.Design;
import org.uncertweb.et.parameter.Input;
import org.uncertweb.et.parameter.VariableInput;
import org.uncertweb.matlab.MLException;
import org.uncertweb.matlab.MLRequest;
import org.uncertweb.matlab.MLResult;
import org.uncertweb.matlab.value.MLArray;
import org.uncertweb.matlab.value.MLCell;
import org.uncertweb.matlab.value.MLMatrix;
import org.uncertweb.matlab.value.MLScalar;
import org.uncertweb.matlab.value.MLString;
import org.uncertweb.matlab.value.MLValue;

public class EmulatorEvaluator {

	private static final Logger logger = LoggerFactory.getLogger(EmulatorEvaluator.class);

	public static EmulatorEvaluationResult run(Emulator emulator, Design design) throws EmulatorEvaluatorException {
		// check if emulator has more than 1 output, unsupported
		if (emulator.getOutputDescriptions().length > 1) {
			throw new EmulatorEvaluatorException("Emulators with more than one output are currently unsupported.");
		}

		// filter out fixed
		List<String> variableInputIdentifiers = new ArrayList<String>();
		for (Input input : emulator.getInputs()) {
			if (input instanceof VariableInput) {
				variableInputIdentifiers.add(input.getIdentifier());
			}
		}

		// get input x values, filtering fixed	
		List<String> designInputIdentifiers = design.getInputIdentifiers();
		double[][] xx = new double[design.getSize()][];
		for (int i = 0; i < design.getSize(); i++) {
			xx[i] = new double[variableInputIdentifiers.size()];
			int jj = 0;
			for (int j = 0; j < designInputIdentifiers.size(); j++) {
				String designInputIdentifier = designInputIdentifiers.get(j);
				if (variableInputIdentifiers.contains(designInputIdentifier)) {
					xx[i][jj] = design.getPoints(designInputIdentifier)[i];
					jj++;
				}
			}
		}

		// do we need to normalise?
		try {
			if (emulator.getDesignMean() != null) {
				// normalise
				MLRequest nrequest = new MLRequest("normalise", 3);
				nrequest.addParameter(new MLMatrix(xx));
				nrequest.addParameter(new MLArray(emulator.getDesignMean()));
				nrequest.addParameter(new MLArray(emulator.getDesignStdDev()));

				// get result
				MLResult nresult = MATLAB.sendRequest(nrequest);
				xx = nresult.getResult(0).getAsMatrix().getMatrix();
			}

			// create matlab request
			MLRequest request = new MLRequest("run_emulator", 2);
			request.addParameter(new MLString((String)Config.getInstance().get("matlab", "gpml_path")));

			// add points to evaluate against		
			request.addParameter(new MLMatrix(xx));

			// training data
			Double[][] xtrn = emulator.getTrainingDesign().getPoints();
			Double[][] ytrn = emulator.getTrainingEvaluationResult().getResults();
			request.addParameter(new MLMatrix(xtrn));
			request.addParameter(new MLMatrix(ytrn));

			// setup covariance function
			MLValue covfname;
			double[] covfpar;
			if (emulator.getCovarianceFunction().equals("squared_exponential")) {
				covfname = new MLString("covSEiso");
			}
			else {
				covfname = new MLString("covMatern3iso");
			}
			if (emulator.getNuggetVariance() != null) {
				covfname = new MLCell(new MLValue[] {
					new MLString("covSum"),
					new MLCell(new MLValue[] { covfname, new MLString("covNoise") }) });
				covfpar = new double[] { emulator.getLengthScale(), Math.sqrt(emulator.getProcessVariance()), emulator.getNuggetVariance() };
			}
			else {
				covfpar = new double[] { emulator.getLengthScale(), Math.sqrt(emulator.getProcessVariance()) };
			}
			request.addParameter(covfname);		
			request.addParameter(new MLArray(covfpar));

			// setup mean function
			String meanfname;
			double[] meanfpar;
			if (emulator.getMeanFunction().equals("zero")) {
				meanfname = "";
				meanfpar = new double[] {};
			}
			else {
				meanfname = "mean_poly";
				meanfpar = new double[1];
				if (emulator.getMeanFunction().equals("constant")) {
					meanfpar[0] = 0;
				}
				else if (emulator.getMeanFunction().equals("linear")) {
					meanfpar[0] = 1;
				}
				else {
					meanfpar[0] = 2;
				}
			}
			request.addParameter(new MLString(meanfname));
			request.addParameter(new MLArray(meanfpar));

			// run emulator
			// run with matlab
			logger.info("Evaluating emulator over " + design.getSize() + " input points...");
			logger.debug("meanfname=" + meanfname + ", meanfpar=" + Arrays.toString(meanfpar) + ", covfname=" + covfname + ", covfpar=" + Arrays.toString(covfpar));
			MLResult result = MATLAB.sendRequest(request);

			// read output
			double[] predictedMean;
			double[] predictedCovariance;
			if (design.getSize() > 1) {
				predictedMean = result.getResult(0).getAsArray().getArray();
				predictedCovariance = result.getResult(1).getAsArray().getArray();
			}
			else {
				predictedMean = new double[] { result.getResult(0).getAsScalar().getScalar() };
				predictedCovariance = new double[] { result.getResult(1).getAsScalar().getScalar() };
			}

			// un-normalise mean and std dev
			if (emulator.getDesignMean() != null) {
				// build request
				MLRequest nrequest = new MLRequest("unnormalise", 2);
				nrequest.addParameter(new MLArray(predictedMean));
				
				// not might be incorrect
				double[] predictedStdDev = new double[predictedCovariance.length];
				for (int i = 0; i < predictedCovariance.length; i++) {
					predictedStdDev[i] = Math.sqrt(predictedCovariance[i]);
				}
				
				nrequest.addParameter(new MLArray(predictedStdDev));
				nrequest.addParameter(new MLScalar(emulator.getEvaluationResultMean()));
				nrequest.addParameter(new MLScalar(emulator.getEvaluationResultStdDev()));
				
				// send
				MLResult nresult = MATLAB.sendRequest(nrequest);
				if (design.getSize() > 1) {
					predictedMean = nresult.getResult(0).getAsArray().getArray();
					predictedStdDev = nresult.getResult(1).getAsArray().getArray();
				}
				else {
					predictedMean = new double[] { nresult.getResult(0).getAsScalar().getScalar() };
					predictedStdDev = new double[] { nresult.getResult(1).getAsScalar().getScalar() };
				}
				
				// back to variance
				for (int i = 0; i < predictedCovariance.length; i++) {
					predictedCovariance[i] = predictedStdDev[i] * predictedStdDev[i]; 
				}
			}

			// create result object
			EmulatorEvaluationResult er = new EmulatorEvaluationResult();
			er.addResults(emulator.getOutputDescriptions()[0].getIdentifier(), predictedMean, predictedCovariance);
			return er;
		}
		catch (MLException e) {
			throw new EmulatorEvaluatorException("Couldn't run emulator. " + e.getMessage());
		}
		catch (IOException e) {
			throw new EmulatorEvaluatorException("Couldn't connect to MATLAB.");
		}
		catch (ConfigException e) {
			throw new EmulatorEvaluatorException("Couldn't load MATLAB config details.");
		}
	}

}
