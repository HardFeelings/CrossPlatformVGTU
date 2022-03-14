package ru.shatsckij.utils;

public class utils {
    public static void print2dArray(int[][] inp) {
        for (int i = 0; i < inp.length; i++) {
            for (int j = 0; j < inp[0].length; j++) {
                System.out.print(inp[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
