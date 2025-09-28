package com.assignment1.util;

import java.util.Arrays;
import java.util.Random;

public class ArraysUtil {
    private static final Random rand = new Random();

    public static int[] randomIntArray(int n, int bound) {
        return rand.ints(n, 0, bound).toArray();
    }

    public static int[] reversedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = n - i;
        return arr;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }

    public static int[] copy(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
