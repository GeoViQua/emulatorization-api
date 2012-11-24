package org.uncertweb.et.test;

import org.uncertweb.et.value.Ensemble;
import org.uncertweb.et.value.Numeric;
import org.uncertweb.et.value.Values;

public class TestData {
	
	public static Values<Ensemble> getSimulatedEnsembleValues() {
		double[][] simulated = new double[][] {
				new double[] { 41.824585,46.751228,46.08247,46.895988,52.361328,53.081135,43.372971,46.309597,47.42461,48.714874,41.660912,48.013214,46.762741,44.052921,46.238686,45.971317,45.713028,52.562504,47.47617,49.388725,47.445858,45.365627,45.960991,53.300365,46.419395,48.396305,45.689899,45.246681,46.492489,47.045456,49.925892,41.856396,50.394211,45.409584,43.175697,45.574947,48.780602,48.446747,47.35313,44.518784,47.902409,51.450497,43.066032,44.765835,50.154156,39.505466,44.210049,43.558544,45.539043,49.202694 },
				new double[] { 43.088467,44.695988,47.365059,46.245346,50.37812,50.559521,43.572163,48.616871,44.274117,45.785099,41.796806,46.006683,42.01091,44.385239,40.337425,42.384113,48.613811,53.407269,43.264099,48.720764,41.546337,46.160892,44.432442,52.541988,45.38446,45.429787,41.854111,43.168411,43.804073,44.493034,47.612667,43.610504,45.611897,42.440479,44.410789,47.376129,53.077824,46.358841,49.681576,46.973606,48.324902,44.98064,44.33065,42.348103,48.341805,48.160202,42.091587,36.360863,43.546135,51.9646 },
				new double[] { 45.544319,40.093449,47.007729,41.268768,49.301552,44.808186,47.87849,42.414207,42.874313,44.415245,41.54866,38.556793,40.563496,40.910126,37.974575,46.686699,45.770054,47.207832,40.47242,47.346409,34.87685,37.89241,38.073593,50.364315,42.283123,42.646736,36.220345,42.763023,39.063721,40.709881,45.288456,39.563904,44.279991,41.916718,43.237736,49.620995,48.075531,41.453606,44.07943,49.731537,49.080925,40.816048,39.98214,41.471661,46.399277,37.110912,38.199654,40.103371,41.217003,47.90588 },
				new double[] { 39.230965,39.34491,40.709278,39.036648,48.007236,44.835243,45.765675,40.099773,38.627262,46.842976,43.340275,35.322971,40.493607,33.581211,34.364403,45.437843,41.082191,40.575695,32.790329,27.252159,33.666237,33.194427,38.826931,45.612755,36.250603,41.032516,33.243786,45.643059,33.7318,36.994999,38.169106,33.772327,34.69635,38.374565,36.408897,44.401161,46.245106,37.862465,42.744961,48.340851,46.761803,39.003632,35.253101,43.840073,40.625664,32.205547,34.086559,39.61338,34.806717,43.593224 },
				new double[] { 32.702099,37.25275,33.496826,32.320057,42.647186,39.316341,41.344391,32.154068,30.059855,37.905766,41.369019,32.909657,36.301422,33.842312,28.836098,41.296276,39.747833,36.592995,28.855419,27.273485,29.533461,28.572201,32.500771,38.324944,29.081102,34.415932,29.341415,42.338062,29.997404,36.656933,28.959339,35.986794,36.242508,35.943787,31.468176,37.00164,39.771923,35.236111,37.889397,43.133858,38.403629,36.657997,33.95739,35.793083,36.20306,33.501812,33.522667,30.148407,31.077892,38.605648 },
				new double[] { 33.341412,32.137218,33.504734,30.346241,33.238731,33.167755,35.317329,27.941669,27.501995,29.134178,32.127293,31.518311,32.659367,30.87027,28.674177,33.125042,33.826664,29.895905,30.301136,27.225386,31.624264,24.898676,28.187956,32.374878,26.486731,34.331684,27.515203,36.461849,27.588009,27.930218,27.076748,32.773758,33.681427,38.402229,32.235386,30.240221,35.380211,29.363352,30.467327,33.518265,31.471443,31.064486,32.751431,32.897102,32.254555,34.842155,32.820057,29.743452,28.14963,32.83123 },
				new double[] { 32.034615,26.590942,30.934414,28.821569,30.045776,33.021378,29.9198,23.955236,25.488062,29.149294,29.816372,30.686733,29.091476,26.646429,31.111052,32.597126,31.699722,26.727196,29.337431,26.808014,28.082232,22.332085,25.299421,26.471968,26.265841,25.940996,26.420866,30.427237,23.674158,30.546913,25.211678,26.387859,29.647703,31.749998,30.896118,30.121244,31.292459,27.849438,24.931887,28.838787,27.221479,27.959356,28.759724,34.575417,32.415749,30.41844,29.993322,25.478125,26.95849,32.418613 },
				new double[] { 23.604824,29.132574,31.4412,25.558628,32.733898,38.222015,21.714476,22.680845,20.038652,35.472355,23.904135,37.467701,22.128799,28.816212,34.98093,27.701548,26.982243,26.958136,24.175764,26.716381,27.775097,22.335405,26.709364,24.374226,30.906046,22.916592,19.795673,27.145903,25.647045,29.792936,21.161625,25.083878,27.198511,25.076092,29.143803,26.935097,33.738438,23.273609,19.743654,26.397003,23.192398,25.137331,34.011353,32.689484,26.790255,28.323879,23.507505,29.260799,33.883671,22.638195 },
				new double[] { 22.920856,27.522532,34.832615,22.68148,28.270424,29.258593,23.959414,22.057924,19.578667,31.071951,25.506498,29.114697,20.24964,23.66662,26.615599,27.3766,28.239567,25.546028,25.104847,21.874056,22.344955,19.20912,19.81937,23.548073,27.542402,19.636692,19.445179,25.351877,22.832432,27.307608,23.542717,22.972816,26.475822,22.821552,28.222231,26.659472,28.122908,24.271814,18.686724,28.304176,26.195587,22.342773,28.776646,25.477579,26.799816,23.615156,26.472775,31.696424,31.619928,23.168989 },
				new double[] { 22.311123,22.258636,23.407825,19.264503,22.661793,22.010048,20.348036,18.752956,15.398583,27.314474,17.385107,16.755716,16.358786,19.133257,20.615604,20.665827,19.227583,20.778326,18.980423,18.831173,19.712034,18.244474,15.813552,19.163176,21.594841,17.377192,18.068321,20.671919,15.285959,21.922911,15.105894,18.057579,20.499985,21.678909,20.379765,19.632957,21.316683,19.81657,15.77751,23.204731,24.825331,16.119465,20.245861,18.93416,20.92532,20.8193,20.141729,22.640963,18.113482,19.574846 }
		};
		return Values.fromEnsembleMatrix(simulated);
	}
	
	public static Values<Numeric> getObservedValues() {
		double[] observed = new double[] { 21.489, 25.592, 31.988, 33.653, 25.465, 23.407,
				19.12, 16.28, 15.299, 15.576 };
		return Values.fromArray(observed);
	}

}