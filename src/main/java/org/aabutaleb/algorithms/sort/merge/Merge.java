package org.aabutaleb.algorithms.sort.merge;

import org.aabutaleb.algorithms.sort.Sort;
import org.aabutaleb.algorithms.util.DataLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Merge implements Sort {
    private List<Integer> data;

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
        data = sort(data);

    }

    private List<Integer> sort(List<Integer> list) {
        if (list.size() > 1) {
            List<Integer> l1 = sort(list.subList(0, list.size() / 2));
            List<Integer> l2 = sort(list.subList((list.size() / 2), list.size()));
            return merge(l1, l2);
        }
        else{
            return list;
        }
    }

    private List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> result = new ArrayList();
        for (int i=0, j=0; (i<l1.size() || j<l2.size()); ){
            if (j==l2.size() || i<l1.size() && l1.get(i) < l2.get(j)) {
                result.add(l1.get(i++));
            }
            else if (i==l1.size() || j<l2.size() && l2.get(j) < l1.get(i)){
                result.add(l2.get(j++));
            }
        }

        return result;
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
