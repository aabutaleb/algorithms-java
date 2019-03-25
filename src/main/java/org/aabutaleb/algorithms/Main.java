package org.aabutaleb.algorithms;

import org.aabutaleb.algorithms.sort.merge.Merge;
import org.aabutaleb.algorithms.util.ResultChecker;

public class Main {
    public static void main(String[] args) {
        Merge algorithm = Merge.build();

        algorithm.run();
        algorithm.print();
        ResultChecker.isOrdered(algorithm.getData());
    }
}
