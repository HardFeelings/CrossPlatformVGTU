package ru.shatsckij.crossplatform;

public class Task30 {
    public static int task(int[] arr, int n) {
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

    public static void main(String[] args) {
        int[] arr = { 1, 2 };
        int n = 3;
        System.out.println(task(arr, n));
    }

}
