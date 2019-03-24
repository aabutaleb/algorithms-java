package org.aabutaleb.algorithms.sort.insertion;

import org.aabutaleb.algorithms.sort.Sort;
import org.aabutaleb.algorithms.util.DataLoader;

import java.io.IOException;

public class Insertion implements Sort {
    private int[] data;
    private Insertion(){}

    public static Insertion build(){
        var insertion = new Insertion();

        try {
            insertion.setData(DataLoader.read("insertion.data"));
        } catch (IOException e) {
            System.err.println("Couldn't load the data");
            e.printStackTrace();
        }
        return insertion;
    }

    @Override
    public void run() {

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
