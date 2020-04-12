package com.hemebiotech.analytics.write;

import java.util.List;
import java.util.Map;

public interface IWriteSymptomDataToFile {

    void write(List<String> symptoms, Map<String, Integer> symptomsCounter);
}
