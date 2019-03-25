package org.aabutaleb.algorithms.sort.merge;

import org.aabutaleb.algorithms.sort.Sort;
import org.aabutaleb.algorithms.util.DataLoader;

import java.io.IOException;


public class Merge implements Sort {
    private int[] data;

    private Merge(){}

    public static Merge build(){
        var newobject = new Merge();

        try {
            newobject.setData(DataLoader.read("integers.data"));
        } catch (IOException e) {
            System.err.println("Couldn't load the data");
            e.printStackTrace();
        }
        return newobject;
    }

    /**
     * Written in imperative java to keep similarity with the mathematical algorithm
     */
    @Override
    public void run(){
        for (int i = 0; i < data.length; i++){
            var min = i;
            for (int j = i+1; j < data.length; j++) {
                if (data[j] < data[min]) min = j;
            }
            exch(data, i, min);
        }
    }

    @Override
    public int[] getData() {
        return data;
    }

    @Override
    public void setData(int[] data) {
        this.data = data;
    }
}
