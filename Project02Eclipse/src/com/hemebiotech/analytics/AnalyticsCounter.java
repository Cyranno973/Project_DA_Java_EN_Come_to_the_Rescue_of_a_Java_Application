package com.hemebiotech.analytics;

import com.hemebiotech.analytics.count.CountSymptom;
import com.hemebiotech.analytics.count.ICountSymptom;
import com.hemebiotech.analytics.read.ISymptomReader;
import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.sort.ISortSymptomByName;
import com.hemebiotech.analytics.sort.SortSymptomByName;
import com.hemebiotech.analytics.write.IWriteSymptomDataToFile;
import com.hemebiotech.analytics.write.WriteSymptomDataToFile;

import java.util.*;

public class AnalyticsCounter {
    private final ISymptomReader reader;
    private final ICountSymptom counter;
    private final ISortSymptomByName sorter;
    private final IWriteSymptomDataToFile writer;

    public AnalyticsCounter(ISymptomReader reader, ICountSymptom counter, ISortSymptomByName sorter, IWriteSymptomDataToFile writer){

        this.reader = reader;
        this.counter = counter;
        this.sorter = sorter;
        this.writer = writer;
    }
    public void execute() {

        //Etape1 On lit le fichier symptoms.txt et stock dans une list de String allSymptoms

        List<String> allSymptoms = reader.GetSymptoms();

        //Etape2 On parcours le fichier en comptant les symptomes avec la map

        Map<String, Integer> symptomsCounter = counter.count(allSymptoms);

        //Etape3 On range dans l'ordre alphabetique les symptomes

        List<String> symptoms = sorter.sort(symptomsCounter.keySet());

        //Etape4 On ecrit le fichier result.out

        writer.write(symptoms, symptomsCounter);
    }


}