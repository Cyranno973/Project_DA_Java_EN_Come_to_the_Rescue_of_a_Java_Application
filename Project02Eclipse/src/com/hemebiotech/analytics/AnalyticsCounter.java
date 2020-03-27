package com.hemebiotech.analytics;

import com.hemebiotech.analytics.count.CountSymptom;
import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {

    public static void main(String args[]) throws Exception {
        //Etape1 On lit le fichier symptoms.txt et stock dans une list de String allSymptoms

        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
        List<String> allSymptoms = reader.GetSymptoms();

        //Etape2 On parcours le fichier en comptant les symptomes avec la map

        CountSymptom counter = new CountSymptom();
        Map<String, Integer> symptomsCounter = counter.count(allSymptoms);

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