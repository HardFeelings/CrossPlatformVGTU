package ru.shatsckij.crossplatform;

import java.util.*;
import java.util.stream.IntStream;

public class Task_7_25 {

    static public Scanner sc = new Scanner(System.in);

    private int getSequenceLen(int[] arr, int start) {
        if (arr.length - start <= 2) return arr.length - start;
        int a = arr[start], b = arr[start + 1];
        int i = 0;
        while (start < arr.length) {
            if (i % 2 == 0) {
                if (arr[start] != a) return i;
            }
            else {
                if (arr[start] != b) return i;
            }
            i++;
            start++;
        }
        return i;
    }
    public int[] findMaxSeq(int[] arr) {
        int[] len = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            len[i] = getSequenceLen(arr, i);
        }
        IntStream intStream = Arrays.stream(len);
        OptionalInt optionalInt = intStream.max();
        int maxLen = optionalInt.getAsInt();
        int[][] maxLenArr = new int[len.length][2];
        for (int i = 0; i < len.length; i++) {
            maxLenArr[i][0] = len[i];
            maxLenArr[i][1] = i;
        }
        int count = 0;
        for (int i = 0; i < maxLenArr.length; i++) {
            if (maxLenArr[i][0] == maxLen) {
                count++;
            }
        }
        if (count > 1) {
            count = 1;
            for (int i = maxLenArr.length - 1; i >= 0; i--) {
                if (maxLenArr[i][0] == maxLen) {
                    if (count == 0) return maxLenArr[i];
                    else count--;
                }
            }
        }
        for (int i = 0; i < maxLenArr.length; i++) {
            if (maxLenArr[i][0] == maxLen) {
                return maxLenArr[i];
            }
        }
        return null;
    }



}