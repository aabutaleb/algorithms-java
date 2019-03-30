package org.aabutaleb.algorithms.sort.quick;

import org.aabutaleb.algorithms.sort.Sort;
import org.aabutaleb.algorithms.util.DataLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Quick implements Sort {
    private List<Integer> data;

    private Quick(){}

    public static Quick build(){
        var newobject = new Quick();

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
       //TODO: Implement
    }


    @Override
    public int[] getData() {
        return data.stream().mapToInt(x -> x).toArray();
    }

    @Override
    public void setData(int[] data) {
        this.data = Arrays.stream(data).boxed().collect(Collectors.toList());
    }
}
