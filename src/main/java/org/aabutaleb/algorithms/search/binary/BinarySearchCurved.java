package org.aabutaleb.algorithms.search.binary;

import org.aabutaleb.algorithms.search.Search;
import org.aabutaleb.algorithms.util.DataLoader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearchCurved implements Search {
    private List<Integer> data;

    private BinarySearchCurved(){}

    @Override
    public void run() {
        binarySearch(data);
    }

    private void binarySearch(List<Integer> data) {
        if (data.size() == 1){
            System.out.println(data.get(0));
        }
        else {
            var n = data.size() / 2;
            var prev = Math.max(0, n-1);
            var next = Math.min(data.size()-1, n+1);

            if (data.get(prev) < data.get(n) && data.get(next) > data.get(n) ){
                binarySearch(data.subList(n, data.size()));
            }
            else if (data.get(next) < data.get(n) && data.get(prev) > data.get(n)) {
                binarySearch(data.subList(0,n));
            }
            else {
                System.out.println(data.get(n));
            }
        }
    }


    public static BinarySearchCurved build(){
        var newobject = new BinarySearchCurved();

        try {
            newobject.setData(DataLoader.read("integers-curve-sort.data"));
        } catch (IOException e) {
            System.err.println("Couldn't load the data");
            e.printStackTrace();
        }
        return newobject;
    }

    public int[] getData() {
        return data.stream().mapToInt(x -> x).toArray();
    }

    public void setData(int[] data) {
        this.data = Arrays.stream(data).boxed().collect(Collectors.toList());
    }
}
