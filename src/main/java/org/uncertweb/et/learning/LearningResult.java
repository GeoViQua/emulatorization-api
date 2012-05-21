package org.uncertweb.et.learning;

import org.uncertweb.et.design.Design;
import org.uncertweb.et.process.ProcessEvaluationResult;

public class LearningResult {
	
	// will want to know parameters used here too!

	// predicted mean
	private double[] predictedMean;
	
	// predicted covariance
	private double[] predictedCovariance;
	
	// input training set
	private Design trainingDesign;
	
	// output training set
	private ProcessEvaluationResult trainingEvaluationResult;
	
	// optimised
	private double lengthScale;
	private double processVariance;
	
	// normalisation
	private double[] designMean;
	private double[] designStdDev;
	private Double evaluationResultMean;
	private Double evaluationResultStdDev;
	
	public LearningResult(double[] predictedMean, double[] predictedCovariance, Design trainingDesign, ProcessEvaluationResult trainingEvaluationResult, double lengthScale, double processVariance) {
		this(predictedMean, predictedCovariance, trainingDesign, trainingEvaluationResult, lengthScale, processVariance, null, null, null, null);
	}
	
	public LearningResult(double[] predictedMean, double[] predictedCovariance, Design trainingDesign, ProcessEvaluationResult trainingEvaluationResult, double lengthScale, double processVariance, double[] designMean, double[] designStdDev, Double evaluationResultMean, Double evaluationResultStdDev) {
		this.predictedMean = predictedMean;
		this.predictedCovariance = predictedCovariance;
		this.trainingDesign = trainingDesign;
		this.trainingEvaluationResult = trainingEvaluationResult;
		this.lengthScale = lengthScale;
		this.processVariance = processVariance;
		this.designMean = designMean;
		this.designStdDev = designStdDev;
		this.evaluationResultMean = evaluationResultMean;
		this.evaluationResultStdDev = evaluationResultStdDev;
	}

	public double[] getPredictedMean() {
		return predictedMean;
	}

	public double[] getPredictedCovariance() {
		return predictedCovariance;
	}

	public Design getTrainingDesign() {
		return trainingDesign;
	}

	public ProcessEvaluationResult getTrainingEvaluationResult() {
		return trainingEvaluationResult;
	}

	public double getLengthScale() {
		return lengthScale;
	}

	public double getProcessVariance() {
		return processVariance;
	}

	public double[] getDesignMean() {
		return designMean;
	}

	public double[] getDesignStdDev() {
		return designStdDev;
	}

	public Double getEvaluationResultMean() {
		return evaluationResultMean;
	}

	public Double getEvaluationResultStdDev() {
		return evaluationResultStdDev;
	}
	
}
