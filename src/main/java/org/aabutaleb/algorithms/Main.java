package org.aabutaleb.algorithms;

import org.aabutaleb.algorithms.sort.insertion.Insertion;
import org.aabutaleb.algorithms.util.ResultChecker;

public class Main {
    public static void main(String[] args) {
        Insertion algorithm = Insertion.build();

        algorithm.run();
        algorithm.print();
        ResultChecker.isOrdered(algorithm.getData());
    }
}
