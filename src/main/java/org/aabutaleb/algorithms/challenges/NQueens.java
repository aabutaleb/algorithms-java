package org.aabutaleb.algorithms.challenges;

import java.util.Arrays;
import java.util.stream.Stream;

/* Classic Recursive Backtracking example */
public class NQueens {
    public static void main(String[] args) {
        var n = Integer.valueOf(args[0]);

        boolean queens[][] = new boolean[n][n];
        nqueens(queens, 0);
    }

    private static void nqueens(boolean[][] queens, int row) {
        if (row < queens.length) {
            for (int i = 0; i < queens[row].length; i++) {
                if (check(queens, i, row)) {
                    putQueen(queens, i, row);
                    nqueens(queens, row + 1);
                }
            }
        }
        else{
            paint(queens);
        }
    }

    private static void putQueen(boolean[][] queens, int col, int row){
        resetRow(queens, row);
        queens[row][col] = true;
    }

    private static void resetRow(boolean[][] queens, int row){
        for (int i = 0; i < queens[row].length; i++) {
            queens[row][i] = false;
        }
    }

    private static boolean check(boolean[][] queens, int col, int row){
        var n = queens.length;
        for (int r = row - 1; r >= 0 ; r--) {
            int diff = row - r;
            if (queens[r][col] || (col >= diff && queens[r][col-diff]) || (col < n-diff && queens[r][col+diff])) return false;
        }
        return true;
    }

    private static void paint(boolean[][] queens){
        System.out.println("\n------- N-QUEENS BOARD -------\n");
        for (int i = 0; i < queens.length; i++) {
            for (int j = 0; j < queens[i].length; j++) {
                if (queens[i][j]) System.out.print("Q ");
                else System.out.print("X ");
            }
            System.out.println("");
        }
        System.out.println("\n        --------------\n");
    }
}
