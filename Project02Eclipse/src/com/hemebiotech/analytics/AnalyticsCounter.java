package com.hemebiotech.analytics;

import com.hemebiotech.analytics.count.ICountSymptom;
import com.hemebiotech.analytics.read.ISymptomReader;
import com.hemebiotech.analytics.sort.ISortSymptomByName;
import com.hemebiotech.analytics.write.IWriteSymptomDataToFile;

import java.io.IOException;
import java.util.*;

/**
 * Cette class gere les interfaces
 *
 *
 */
public class AnalyticsCounter {
    private final ISymptomReader reader;
    private final ICountSymptom counter;
    private final ISortSymptomByName sorter;
    private final IWriteSymptomDataToFile writer;

    /**
     * Cette class demande dans son constructor toutes les intefaces
     *
     * @param  reader,counter,sorter,writer
     */
    public AnalyticsCounter(ISymptomReader reader, ICountSymptom counter, ISortSymptomByName sorter, IWriteSymptomDataToFile writer){

        this.reader = reader;
        this.counter = counter;
        this.sorter = sorter;
        this.writer = writer;
    }
    /**
     * Cette methode lance ou execute toutes les fonctions
     *
     */
    public void execute() throws IOException {

        //Etape1 On lit le fichier symptoms.txt et stock dans une list de String allSymptoms

        List<String> allSymptoms = reader.getSymptoms();

        //Etape2 On parcours le fichier en comptant les symptomes avec la map

        Map<String, Integer> symptomsCounter = counter.count(allSymptoms);

        //Etape3 On range dans l'ordre alphabetique les symptomes

        List<String> symptoms = sorter.sort(symptomsCounter.keySet());

        //Etape4 On ecrit le fichier result.out

        writer.write(symptoms, symptomsCounter);
    }


}