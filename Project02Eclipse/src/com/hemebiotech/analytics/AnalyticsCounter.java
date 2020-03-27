package com.hemebiotech.analytics;

import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {
    //On declare une HashMap Clé/Valeur = symptoms/occurrence
    static Map<String, Integer> symptomsCounter = new HashMap<>();
    public static void main(String args[]) throws Exception {
        //Etape1 On lit le fichier symptoms.txt et stock dans une list de String allSymptoms

        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
        List<String> allSymptoms = reader.GetSymptoms();

        //Etape2 On parcours le fichier en comptant les symptomes avec la map

        for (String symptom : allSymptoms) {
            if (symptomsCounter.containsKey(symptom)) {
                symptomsCounter.put(symptom, symptomsCounter.get(symptom) + 1);
            } else {
                symptomsCounter.put(symptom, 1);
            }
        }
        //Etape3 On range dans l'ordre alphabetique les symptomes
        List<String> symptoms = new ArrayList<>(symptomsCounter.keySet());
        Collections.sort(symptoms);

        //Etape4 On ecrit le fichier result.out
        FileWriter writer = new FileWriter("result.out");
        for (String symptom : symptoms) {
            writer.write(symptom + "=" + symptomsCounter.get(symptom)+"\n");
        }
        writer.close();
    }
}