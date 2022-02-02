package com.hemebiotech.analytics;

/**
 * <b>Main est la classe permettant l'appel aux différentes méthodes de la
 * classe AnalyticsCounter.</b>
 * 
 * 
 * @author Nicolas Moreau
 * @version 1.0
 */
public class Main {

	/**
	 * Le nom du fichier à lire en Entrée avec son emplacement
	 */
	private static final String FILEPATH_INPUT = ".\\Project02Eclipse\\symptoms.txt";
	/**
	 * Le nom du fichier en Sortie créé avec son emplacement
	 */
	private static final String FILEPATH_OUTPUT = ".\\Project02Eclipse\\result.txt";

	public static void main(String[] args) {

		AnalyticsCounter analyticsCounter = new AnalyticsCounter();

		analyticsCounter.readFile(FILEPATH_INPUT);

		analyticsCounter.countOcc();

		analyticsCounter.writeFile(FILEPATH_OUTPUT);

	}

}