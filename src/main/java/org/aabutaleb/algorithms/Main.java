package org.aabutaleb.algorithms;

import org.aabutaleb.algorithms.search.binary.BinarySearch;

public class Main {
    public static void main(String[] args) {
        BinarySearch b = BinarySearch.build();
        b.setGoal(16122);
        b.setDebugModeOn();
        b.run();
    }
}
