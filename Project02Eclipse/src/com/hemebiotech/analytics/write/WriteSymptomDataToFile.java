package com.hemebiotech.analytics.write;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteSymptomDataToFile implements IWriteSymptomDataToFile {
    private String filepath;

    public WriteSymptomDataToFile(String filePath) {
        this.filepath = filePath;
    }

    @Override
    /**
     * Cette methode ecrit les differents symptoms et leur occurence
     *
     * @param symptoms
     * @return
     */
    public void write(List<String> symptoms, Map<String, Integer> symptomsCounter) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filepath);

            for (String symptom : symptoms) {
                writer.write(symptom + "=" + symptomsCounter.get(symptom) + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            writer.close();
        }
    }
}

