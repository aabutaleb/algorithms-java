package org.aabutaleb.algorithms.sort;

public interface Sort {
    default void exch(int[] data, int orig, int dest){
        var tmp = data[dest];
        data[dest] = data[orig];
        data[orig] = tmp;
    }

    int[] getData();

    void setData(int[] data);

    void run();

    void print();
}
