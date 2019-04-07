package org.aabutaleb.algorithms.search;

import java.util.Arrays;

public interface Search {
    int[] getData();

    void setData(int[] data);

    void run();

    default void print(){
        Arrays.stream(getData()).forEach(System.out::println);
    }
}
