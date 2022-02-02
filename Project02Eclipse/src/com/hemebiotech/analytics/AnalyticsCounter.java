package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <b>AnalyticsCounter est la classe permettant : </b>
 * <ol>
 * <li>la lecture du fichier des symptomes fourni en entr�e</li>
 * <li>le comptage des occurences de chaque symtome</li>
 * <li>l'�criture dans le fichier de sortie de la liste tri�e des symptomes,
 * avec le nombre d'occurences associ�es pour chacun</li>
 * </ol>
 * 
 * @author Nicolas Moreau
 * @version 1.0
 */
public class AnalyticsCounter {

	/**
	 * symptomList est l'objet qui permet de stocker en m�moire l'int�gralit� des
	 * lignes (type symptome) lues dans le fichier
	 * 
	 * 
	 */
	List<String> symptomList = new ArrayList<String>();
	/**
	 * sortedSymptomList est l'objet qui permet de stocker en m�moire, la liste
	 * directement tri�e des symptomes avec le nombre d'occurences associ�es de
	 * chacun
	 * 
	 * 
	 */
	Map<String, Integer> sortedSymptomList = new TreeMap<String, Integer>();

	/**
	 * Lit le contenu du fichier fourni en entr�e.
	 * 
	 * @param filePathInput Emplacement et Nom du fichier en Entr�e.
	 * 
	 */
	public void readFile(String filePathInput) {

		if (filePathInput != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filePathInput));
				String line = reader.readLine();

				while (line != null) {
					symptomList.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Compte le nombre d'occurences de chaque symptome.
	 * 
	 * 
	 */
	public void countOcc() {

		for (int i = 0; i < symptomList.size(); i++) {
			String symptom = symptomList.get(i);

			boolean exists = sortedSymptomList.containsKey(symptom);

			if (exists == true) {
				int nbOcc = sortedSymptomList.get(symptom) + 1;
				sortedSymptomList.put(symptom, nbOcc);
			} else {
				sortedSymptomList.put(symptom, 1);
			}
		}

	}

	/**
	 * Ecrit dans le fichier en sortie.
	 * 
	 * @param filePathOutput Emplacement et Nom du fichier en sortie.
	 * 
	 */
	public void writeFile(String filePathOutput) {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePathOutput));

			for (Map.Entry<String, Integer> entry : sortedSymptomList.entrySet()) {
				String key = entry.getKey();
				Integer value = entry.getValue();
				String keyValue = key + " : " + value;
				writer.write(keyValue);
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
