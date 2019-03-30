package org.aabutaleb.algorithms.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeStreams {
    public static void main(String[] args) {
        var singleStream = mergeStreams(new int[][]{
                new int[]{1,5,10,15}, new int[]{2,4,8,14}, new int[]{3,6,9,12,18}
        });

        singleStream.forEach(System.out::println);
    }

    public static List<Integer> mergeStreams(int[][] streams){
        var result = new ArrayList<Integer>();

        var pointers = new int[streams.length];
        Arrays.stream(pointers).forEach(x -> x=0);

        int value = 0;
        while ((value = getAndIncrease(streams, pointers)) > 0) {
            result.add(value);
        }

        return result;
    }

    private static int getAndIncrease(int[][] streams, int[] pointers) {
        int min = Integer.MAX_VALUE;
        int pos = -1;

        for (int i = 0; i < pointers.length; i++){
            if (pointers[i] < streams[i].length && streams[i][pointers[i]] < min) {
                pos = i;
                min = streams[i][pointers[i]];
            }
        }

        if (pos < 0) return -1;

        pointers[pos] += 1;
        return min;
    }
}
