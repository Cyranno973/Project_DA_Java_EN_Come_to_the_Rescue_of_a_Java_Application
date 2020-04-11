package com.hemebiotech.analytics.write;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteSymptomDataToFile {
    private String filepath;

    public WriteSymptomDataToFile(String filePath) {
        this.filepath = filePath;
    }

    public void write(List<String> symptoms, Map<String, Integer> symptomsCounter) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filepath);

            for (String symptom : symptoms) {
                writer.write(symptom + "=" + symptomsCounter.get(symptom) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

