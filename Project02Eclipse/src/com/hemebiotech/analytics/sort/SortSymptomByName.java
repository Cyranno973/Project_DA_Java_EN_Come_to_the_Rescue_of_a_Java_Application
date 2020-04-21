package com.hemebiotech.analytics.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Cette Class permet de trier les  symptoms
 *
 */
public class SortSymptomByName implements ISortSymptomByName {
    @Override
    /**
     * Cette methode trie les différents symptoms
     *
     * @param symptoms
     * @return
     */
    public List<String> sort(Collection<String> symptoms) {
        List<String> copysSymptoms = new ArrayList<>(symptoms);
        Collections.sort(copysSymptoms);
        return copysSymptoms;
    }
}