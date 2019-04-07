package org.aabutaleb.algorithms.search.binary;

import org.aabutaleb.algorithms.search.Search;
import org.aabutaleb.algorithms.util.DataLoader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearch implements Search {
    private List<Integer> data;
    private int goal;
    private boolean debugMode = false;
    private int step=0;

    private BinarySearch(){}

    @Override
    public void run() {
        binarySearch(data);
    }

    private void binarySearch(List<Integer> data) {
        if (data.size() == 1){
            if (data.get(0).equals(goal)){
                System.out.printf("Found: %d",data.get(0));
            }
            else{
                System.out.printf("%d not found", goal);
            }
        }
        else {
            var n = data.size() / 2;

            if (goal < data.get(n)){
                if (debugMode) System.out.printf("%d) Goal %d < %d. Going to the left\n", step++, goal, data.get(n));
                binarySearch(data.subList(0,n));
            }
            else {
                if (debugMode) System.out.printf("%d) Goal %d > %d. Going to the right\n", step++, goal, data.get(n));
                binarySearch(data.subList(n,data.size()));
            }
        }
    }

    public static BinarySearch build(){
        var newobject = new BinarySearch();

        try {
            newobject.setData(DataLoader.read("integers-sorted.data"));
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

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public void setDebugModeOn() {
        this.debugMode = true;
    }

    public void setDebugModeOff() {
        this.debugMode = false;
    }
}
