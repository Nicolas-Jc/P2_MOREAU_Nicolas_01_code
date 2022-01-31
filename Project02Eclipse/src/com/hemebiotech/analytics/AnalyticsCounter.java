package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	List<String> symptomList = new ArrayList<String>();
	Map<String, Integer> noSortedSymptomList = new HashMap<String, Integer>();

	// ETAPE 1 - Lecture Fichier et stockage valeurs symptomes avec un objet
	// ArrayList
	public void readFile(String filePathInput) {

		if (filePathInput != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filePathInput));
				String line = reader.readLine();
				// Boucle sur chaque ligne du fichier
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

	// ETAPE 2 - Lecture contenu ArrayList (boucle) et sauvegarde dans un
	// dictionnaire HashMap
	// => Un Symptome = 1 clé unique. Pour chaque clé sera renseigné le nombre
	// d'occurence lu dans l'Arraylist
	public void countOcc() {

		for (int i = 0; i < symptomList.size(); i++) {
			String symptom = symptomList.get(i);
			// vérification pre-existance du symptome dans la HashMap
			boolean exists = noSortedSymptomList.containsKey(symptom);
			// Cas du symptome deja existant dans le dictionnaire
			// => Ajouter 1 à la valeur
			if (exists == true) {
				int nbOcc = noSortedSymptomList.get(symptom) + 1;
				noSortedSymptomList.put(symptom, nbOcc);
			}
			// sinon le créer et mettre une valeur de "1"
			else {
				noSortedSymptomList.put(symptom, 1);
			}
		}
		System.out.println("noSortedSymptomList =>" + noSortedSymptomList);
	}

	// ETAPE 3 - TRI DICTIONNAIRE SYMPTOMES ET ECRITURE FICHIER SORTIE.
	// Utilisation de la classe TreeMap
	public void writeFile(String filePathOutput) {

		Map<String, Integer> SortedSymptomList = new TreeMap<String, Integer>(noSortedSymptomList);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePathOutput));
			// Boucle sur TreeMap pour Récupérer les valeurs et les clés
			for (Map.Entry<String, Integer> entry : SortedSymptomList.entrySet()) {
				String key = entry.getKey();
				Integer value = entry.getValue();
				String keyValue = key + " : " + value;
				System.out.println(keyValue);
				writer.write(keyValue);
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
