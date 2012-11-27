package org.uncertweb.et.json;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;
import org.uncertweb.et.design.Design;
import org.uncertweb.et.emulator.Emulator;
import org.uncertweb.et.process.ProcessEvaluationResult;
import org.uncertweb.et.request.ValidationRequest;
import org.uncertweb.et.response.ValidationResponse;
import org.uncertweb.et.test.TestData;
import org.uncertweb.et.test.TestHelper;
import org.uncertweb.et.value.EnsembleValues;
import org.uncertweb.et.value.MeanVarianceValues;
import org.uncertweb.et.value.NumericValues;

public class JSONTest {

	@Test
	public void encodeNumericValues() {
		NumericValues values = TestData.getPfObserved();
		new JSON().encode(values, System.out);
		System.out.println();
		// doesn't test anything
	}

	@Test
	public void encodeEnsembleValues() {
		EnsembleValues values = TestData.getNuPredicted();
		new JSON().encode(values, System.out);
		System.out.println();
		// doesn't test anything
	}

	@Test
	public void encodeMeanVarianceValues() {
		MeanVarianceValues values = TestData.getPfPredicted();
		new JSON().encode(values, System.out);
		System.out.println();
		// doesn't test anything
	}

	@Test
	public void encodeValidationResponseEmulatorValues() {
		ValidationResponse response = TestData.getValidationResponseEmulatorValues();
		new JSON().encode(response, System.out);
		System.out.println();
		// doesn't test anything
	}

	@Test
	public void parseNumericValues() {
		NumericValues values = TestHelper.parseJSON("pf-observed-numeric-values.json", NumericValues.class);
		assertThat(values.size(), equalTo(41));
		assertThat(values.get(0).getNumber(), equalTo(1287.2114205439084));
		assertThat(values.get(1).getNumber(), equalTo(1490.815039647082));
		assertThat(values.get(2).getNumber(), equalTo(1671.1050055639248));
	}

	@Test
	public void parseEnsembleValues() {
		EnsembleValues values = TestHelper.parseJSON("nu-predicted-ensemble-values.json", EnsembleValues.class);
		assertThat(values.size(), equalTo(168));
		assertThat(values.get(0).getMembers(), equalTo(new double[] { 41.824585,46.751228,46.08247,46.895988,52.361328,53.081135,43.372971,46.309597,47.42461,48.714874,41.660912,48.013214,46.762741,44.052921,46.238686,45.971317,45.713028,52.562504,47.47617,49.388725,47.445858,45.365627,45.960991,53.300365,46.419395,48.396305,45.689899,45.246681,46.492489,47.045456,49.925892,41.856396,50.394211,45.409584,43.175697,45.574947,48.780602,48.446747,47.35313,44.518784,47.902409,51.450497,43.066032,44.765835,50.154156,39.505466,44.210049,43.558544,45.539043,49.202694 }));
		assertThat(values.get(1).getMembers(), equalTo(new double[] { 43.088467,44.695988,47.365059,46.245346,50.37812,50.559521,43.572163,48.616871,44.274117,45.785099,41.796806,46.006683,42.01091,44.385239,40.337425,42.384113,48.613811,53.407269,43.264099,48.720764,41.546337,46.160892,44.432442,52.541988,45.38446,45.429787,41.854111,43.168411,43.804073,44.493034,47.612667,43.610504,45.611897,42.440479,44.410789,47.376129,53.077824,46.358841,49.681576,46.973606,48.324902,44.98064,44.33065,42.348103,48.341805,48.160202,42.091587,36.360863,43.546135,51.9646 }));
	}

	@Test
	public void parseMeanVarianceValues() {
		MeanVarianceValues values = TestHelper.parseJSON("pf-predicted-mean-variance-values.json", MeanVarianceValues.class);
		assertThat(values.size(), equalTo(41));
		assertThat(values.get(0).getMean(), equalTo(1287.196529005707));
		assertThat(values.get(0).getVariance(), equalTo(0.023569758970645584));
		assertThat(values.get(1).getMean(), equalTo(1490.8066197659962));
		assertThat(values.get(1).getVariance(), equalTo(0.02922081304584009));
	}

	@Test
	public void parseValidationRequestEnsembles() {
		ValidationRequest request = TestHelper.parseJSON("validation-request-ensembles.json", ValidationRequest.class);

		// check
		NumericValues observed = request.getObserved();
		EnsembleValues simulated = request.getPredicted();
		assertThat(observed, notNullValue());
		assertThat(simulated, notNullValue());
		assertThat(observed.size(), equalTo(simulated.size()));
	}

	@Test
	public void parseValidationRequestEmulatorSimulator() {
		ValidationRequest request = TestHelper.parseJSON("validation-request-emulator-simulator.json", ValidationRequest.class);

		// check
		Emulator emulator = request.getEmulator();
		String serviceURL = request.getServiceURL();
		String processIdentifier = request.getProcessIdentifier();
		int designSize = request.getDesignSize();
		assertThat(emulator, notNullValue());
		assertThat(serviceURL, equalTo("http://uncertws.aston.ac.uk:8080/ps/service"));
		assertThat(processIdentifier, equalTo("Polyfun"));
		assertThat(designSize, equalTo(100));
	}

	@Test
	public void parseValidationRequestEmulatorValues() {
		ValidationRequest request = TestHelper.parseJSON("validation-request-emulator-values.json", ValidationRequest.class);

		// check
		Emulator emulator = request.getEmulator();
		Design design = request.getDesign();
		ProcessEvaluationResult result = request.getEvaluationResult();
		assertThat(emulator, notNullValue());
		assertThat(design, notNullValue());
		assertThat(result, notNullValue());
	}


}
