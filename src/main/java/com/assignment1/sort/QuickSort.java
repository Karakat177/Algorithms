package com.assignment1.sort;

import java.util.Random;

public class QuickSort {
    private final Random rand = new Random();
    public int comparisons = 0;
    public int maxDepth = 0;
    public int swaps = 0;

    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1, 1);
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println("Max Recursion Depth: " + maxDepth);
    }

    private void quickSort(int[] arr, int l, int r, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        while (l < r) {
            int pivotIndex = l + rand.nextInt(r - l + 1);
            int pivot = arr[pivotIndex];
            int i = l, j = r;

            while (i <= j) {
                while (arr[i] < pivot) {
                    i++;
                    comparisons++;
                }

                while (arr[j] > pivot) {
                    j--;
                    comparisons++;
                }

                if (i <= j) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    swaps++;
                    i++; j--;
                }
            }

            // Recurse on smaller side first
            if (j - l < r - i) {
                quickSort(arr, l, j, depth + 1);
                l = i; // tail recursion on larger side
            } else {
                quickSort(arr, i, r, depth + 1);
                r = j;
            }
        }
    }
}
