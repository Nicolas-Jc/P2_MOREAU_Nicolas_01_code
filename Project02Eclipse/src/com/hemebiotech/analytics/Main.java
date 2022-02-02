package com.hemebiotech.analytics;

/**
 * <b>Main est la classe permettant l'appel aux diff�rentes m�thodes de la
 * classe AnalyticsCounter.</b>
 * 
 * 
 * @author Nicolas Moreau
 * @version 1.0
 */
public class Main {

	/**
	 * Le nom du fichier � lire en Entr�e avec son emplacement
	 */
	private static final String FILEPATH_INPUT = ".\\Project02Eclipse\\symptoms.txt";
	/**
	 * Le nom du fichier en Sortie cr�� avec son emplacement
	 */
	private static final String FILEPATH_OUTPUT = ".\\Project02Eclipse\\result.txt";

	public static void main(String[] args) {

		AnalyticsCounter analyticsCounter = new AnalyticsCounter();

		analyticsCounter.readFile(FILEPATH_INPUT);

		analyticsCounter.countOcc();

		analyticsCounter.writeFile(FILEPATH_OUTPUT);

	}

}