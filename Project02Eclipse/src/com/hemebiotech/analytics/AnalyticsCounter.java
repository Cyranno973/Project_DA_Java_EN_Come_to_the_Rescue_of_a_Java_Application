package com.hemebiotech.analytics;

import com.hemebiotech.analytics.count.CountSymptom;
import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.sort.SortSymptomByName;
import com.hemebiotech.analytics.write.WriteSymptomDataToFile;

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
        SortSymptomByName sorter = new SortSymptomByName();
        List<String>  symptoms = sorter.sort(symptomsCounter.keySet());

        //Etape4 On ecrit le fichier result.out

        WriteSymptomDataToFile writer = new WriteSymptomDataToFile("result.out");

        writer.write(symptoms, symptomsCounter);

    }
}