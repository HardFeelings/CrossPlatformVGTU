package ru.shatsckij.other;


import java.util.Arrays;
import java.util.Scanner;

public class task1 {
    static int[][] split2(int[] inp) {
        int len = inp.length;
        int[][] res = new int[2][];
        if (len % 2 == 0) {
            res[0]=Arrays.stream(inp).limit(len / 2).toArray();
            res[1]=Arrays.stream(inp).skip(len / 2).toArray();
        }
        else {
            res[0] = Arrays.stream(inp).limit(len / 2 + 1).toArray();
            res[1] = Arrays.stream(inp).skip(len / 2 + 1).toArray();
        }
        return res;
    }

    static int count1(int[] left, int[] rigth) {
        int left_min = Arrays.stream(left).min().getAsInt();
        int result = (int) Arrays.stream(rigth).filter(x -> (x >= left_min)).count();
        return result;
    }

    static int count2(int[] left, int[] rigth) {
        int left_max = Arrays.stream(left).max().getAsInt();
        int result = (int) Arrays.stream(rigth).filter(x -> (x >= left_max)).count();
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = scanner.nextInt();
        int[] inp = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Array[%d] = ",i);
            inp[i] = scanner.nextInt();
        }

        int[][] halfs = split2(inp);
        int count1_r = count1(halfs[0], halfs[1]);
        int count2_r = count2(halfs[0], halfs[1]);
        System.out.println(count1_r);
        System.out.println(count2_r);

    }
}
