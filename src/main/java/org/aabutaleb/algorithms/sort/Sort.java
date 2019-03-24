package org.aabutaleb.algorithms.sort;

import java.util.Arrays;

public interface Sort {
    default void exch(int[] data, int orig, int dest){
        var tmp = data[dest];
        data[dest] = data[orig];
        data[orig] = tmp;
    }

    int[] getData();

    void setData(int[] data);

    void run();

    default void print(){
        Arrays.stream(getData()).forEach(System.out::println);
    }
}
