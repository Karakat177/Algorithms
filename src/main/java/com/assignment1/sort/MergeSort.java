package com.assignment1.sort;

public class MergeSort {
    private static final int INSERTION_SORT_THRESHOLD = 16;
    public int swaps = 0;
    public int comparisons = 0;
    public int allocations = 0;
    public int maxDepth = 0;

    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int[] buffer = new int[arr.length];
        mergeSort(arr, buffer, 0, arr.length - 1, 0);
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Allocations: " + allocations);
        System.out.println("Max Recursion Depth: " + maxDepth);
    }

    private void mergeSort(int[] arr, int[] buffer, int l, int r, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        if (r - l + 1 <= INSERTION_SORT_THRESHOLD) {
            insertionSort(arr, l, r);
            return;
        }

        int m = (l + r) / 2;
        mergeSort(arr, buffer, l, m, depth + 1);
        mergeSort(arr, buffer, m + 1, r, depth + 1);
        merge(arr, buffer, l, m, r);
    }

    private void insertionSort(int[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= l && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                j--;
            }
            comparisons++;
            arr[j + 1] = key;
            swaps++;
        }
    }


    private void merge(int[] arr, int[] buffer, int l, int m, int r) {
        allocations++;
        System.arraycopy(arr, l, buffer, l, r - l + 1);
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            comparisons++;
            if (buffer[i] <= buffer[j]) {
                arr[k++] = buffer[i++];
                swaps++;
            } else {
                arr[k++] = buffer[j++];
                swaps++;
            }
        }
        while (i <= m) {
            arr[k++] = buffer[i++];
            swaps++;
        }
        while (j <= r) {
            arr[k++] = buffer[j++];
            swaps++;
        }
    }
}