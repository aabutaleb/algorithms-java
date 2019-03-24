package org.aabutaleb.algorithms.sort.selection;

import org.aabutaleb.algorithms.sort.Sort;
import org.aabutaleb.algorithms.util.DataLoader;

import java.io.*;
import java.util.Arrays;

public class Selection implements Sort {
    private int[] data;

    private Selection(){}

    public static Selection build(){
        Selection selection = new Selection();

        try {
            selection.setData(DataLoader.read("selection.data"));
        } catch (IOException e) {
            System.err.println("Couldn't load the data");
            e.printStackTrace();
        }
        return selection;
    }

    /**
     * Written in imperative java to keep similarity with the mathematical algorithm
     */
    public void run(){
        for (int i = 0; i < data.length; i++){
            var min = i;
            for (int j = i+1; j < data.length; j++) {
                if (data[j] < data[min]) min = j;
            }
            exch(data, i, min);
        }
    }

    public void print(){
        Arrays.stream(getData()).forEach(System.out::println);
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }
}
