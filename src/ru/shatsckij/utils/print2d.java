package ru.shatsckij.utils;

public class print2d {
    public static void printArray(int[][] inp) {
        for (int i = 0; i < inp.length; i++) {
            for (int j = 0; j < inp[0].length; j++) {
                System.out.print(inp[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
