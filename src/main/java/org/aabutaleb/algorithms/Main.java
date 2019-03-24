package org.aabutaleb.algorithms;

import org.aabutaleb.algorithms.sort.selection.Selection;

public class Main {
    public static void main(String[] args) {
        Selection selection = Selection.build();

        selection.run();
        selection.print();
    }
}
