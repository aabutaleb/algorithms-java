package org.aabutaleb.algorithms.challenges;

public class FindArraySum {

    public static void main(String[] args) {
        findKElementsSum(new int[]{1,2,3,4,5,6,7,8,9}, 0, 3,10, "");

    }

    private static void findKElementsSum(int[] ints, int i, int k, int n, String sum) {
        for (; i < ints.length; i++) {
            if (k > 1){
                findKElementsSum(ints, i+1, k-1, n-ints[i], sum+ints[i]+",");
            }
            else {
                if (ints[i] == n) System.out.println(sum+ints[i]);
            }
        }
    }
}
