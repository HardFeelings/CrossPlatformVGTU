package ru.shatsckij.crossplatform;

public class Task_7_30 {
    public  int findMaxSeq(int[] arr, int n) {
        if (n > arr.length)
            return -1;
        int checked = 0;
        int sum = 0;
        int max_sum = 0;
        int max_sum_pos = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (checked < n) {
                checked++;
                if (checked == n) {
                    max_sum = sum;
                    max_sum_pos = i - n + 1;
                }
            } else {
                sum -= arr[i - n];
                if (sum >= max_sum) {
                    max_sum = sum;
                    max_sum_pos = i - n + 1;
                }
            }
        }
        return max_sum_pos;
    }
}
