package com.hemebiotech.analytics;

public class Main {

	private static final String FILEPATH_INPUT = ".\\Project02Eclipse\\symptoms.txt";
	private static final String FILEPATH_OUTPUT = ".\\Project02Eclipse\\result.txt";

	public static void main(String[] args) {

		AnalyticsCounter analyticsCounter = new AnalyticsCounter();

		analyticsCounter.readFile(FILEPATH_INPUT);

		analyticsCounter.countOcc();

		analyticsCounter.writeFile(FILEPATH_OUTPUT);

	}

}