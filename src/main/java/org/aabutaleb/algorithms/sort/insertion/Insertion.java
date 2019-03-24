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
        for (int i = 0; i < data.length; i++){
            for (int j = i; j > 0 && data[j] < data[j-1]; j--){
                exch(data, j, j-1);
            }
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
