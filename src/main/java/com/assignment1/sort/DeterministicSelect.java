package com.assignment1.sort;

import java.util.Arrays;

public class DeterministicSelect {
    public int comparisons = 0;
    public int maxDepth = 0;
    public int swaps = 0;

    public int select(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 0 || k >= arr.length) throw new IllegalArgumentException();
        return select(arr, 0, arr.length - 1, k, 1);
    }

    private int select(int[] arr, int l, int r, int k, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        if (r - l < 5) {
            Arrays.sort(arr, l, r + 1);
            comparisons += (r - l + 1) * (r - l) / 2; // rough estimate
            return arr[l + k];
        }

        int numGroups = (r - l + 1 + 4) / 5;
        for (int i = 0; i < numGroups; i++) {
            int start = l + i * 5;
            int end = Math.min(start + 4, r);
            Arrays.sort(arr, start, end + 1);
            comparisons += (end - start + 1) * (end - start) / 2;
            int median = start + (end - start) / 2;
            swap(arr, l + i, median);
        }

        int pivot = select(arr, l, l + numGroups - 1, numGroups / 2, depth + 1);
        int pivotIndex = partition(arr, l, r, pivot);

        int rank = pivotIndex - l;
        if (k < rank) return select(arr, l, pivotIndex - 1, k, depth + 1);
        else if (k > rank) return select(arr, pivotIndex + 1, r, k - rank - 1, depth + 1);
        else return arr[pivotIndex];
    }

    private int partition(int[] arr, int l, int r, int pivotValue) {
        int pivotIndex = l;
        for (int i = l; i <= r; i++) {
            comparisons++;
            if (arr[i] == pivotValue) {
                pivotIndex = i;
                break;
            }
        }
        swap(arr, pivotIndex, r);
        int store = l;
        for (int i = l; i < r; i++) {
            comparisons++;
            if (arr[i] < pivotValue) {
                swap(arr, store, i);
                store++;
            }
        }
        swap(arr, store, r);
        return store;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        swaps++;
    }
}
