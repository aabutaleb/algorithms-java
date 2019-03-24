package org.aabutaleb.algorithms;

import org.aabutaleb.algorithms.sort.insertion.Insertion;

public class Main {
    public static void main(String[] args) {
        Insertion insertion = Insertion.build();

        insertion.run();
        insertion.print();
    }
}
