package org.aabutaleb.algorithms.util;

public class ResultChecker {
    public static boolean isOrdered(int[] array){
        var result = true;
        for (int i = 0; i < array.length-1; i++){
            if (array[i] > array[i+1]) result = false;
        }
        System.out.println("isOrdered: "+result);
        return result;
    }
}
