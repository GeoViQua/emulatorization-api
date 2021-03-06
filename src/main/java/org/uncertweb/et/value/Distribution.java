package org.uncertweb.et.value;

public class Distribution implements Value {

	private double mean;
	private double variance;
	
	public Distribution(double mean, double variance) {
		this.mean = mean;
		this.variance = variance;
	}
	
	public double getMean() {
		return mean;
	}
	
	public double getVariance() {
		return variance;
	}
	
	public double getStandardDeviation() {
		return Math.sqrt(getVariance());
	}
	
}
