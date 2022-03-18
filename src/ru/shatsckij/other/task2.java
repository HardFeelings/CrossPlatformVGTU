package ru.shatsckij.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class task2 {
    static int getLen(int[] elems, int start) {
        int[] tail = Arrays.stream(elems).skip(start).toArray();
        int count = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int elem : tail) {
            if (set.contains(elem))
                break;
            count++;
            set.add(elem);
        }
        return count;
    }

    static int[] task(int[] arr) {
        int[] lens = new int[arr.length];
        for (int i = 0; i < lens.length; i++) {
            lens[i] = getLen(arr, i);
        }
        int max_len = Arrays.stream(lens).max().getAsInt();
        int max_index = 0;
        for (int i = 0; i < lens.length; i++) {
            if (lens[i] >= lens[max_index]) {
                max_index = i;
            }
        }
        return new int[] { max_index, max_len };
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
        int[] res = task(inp);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}