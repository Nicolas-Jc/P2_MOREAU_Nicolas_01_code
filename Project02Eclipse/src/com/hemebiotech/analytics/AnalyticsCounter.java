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

public class AnalyticsCounter {

	List<String> symptomList = new ArrayList<String>();
	Map<String, Integer> sortedSymptomList = new TreeMap<String, Integer>();

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

	public void writeFile(String filePathOutput) {

		// Map<String, Integer> SortedSymptomList = new TreeMap<String,
		// Integer>(noSortedSymptomList);

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
