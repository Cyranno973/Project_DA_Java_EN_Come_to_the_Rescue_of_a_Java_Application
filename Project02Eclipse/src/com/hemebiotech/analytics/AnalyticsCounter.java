package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {
    //On declare une HashMap Clé/Valeur = symptoms/occurrence
    static Map<String, Integer> symptomsCounter = new HashMap<>();
    public static void main(String args[]) throws Exception {
        //Etape1 On lit le fichier symptoms.txt
        BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
        String line = reader.readLine();

        //Etape2 On parcours le fichier en comptant les symptomes avec la map
        while (line != null) {
            if (symptomsCounter.containsKey(line)) {
                symptomsCounter.put(line, symptomsCounter.get(line) + 1);
            } else {
                symptomsCounter.put(line, 1);
            }
            line = reader.readLine();
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
        reader.close();
    }
}