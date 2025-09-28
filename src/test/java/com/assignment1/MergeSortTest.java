package com.assignment1;

import com.assignment1.sort.MergeSort;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {
    @Test
    public void testSortedCorrectly() {
        int[] arr = new Random().ints(1000, 0, 10000).toArray();
        int[] expected = arr.clone();
        Arrays.sort(expected);

        MergeSort ms = new MergeSort();
        ms.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testReverseArray() {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) arr[i] = arr.length - i;
        int[] expected = arr.clone();
        Arrays.sort(expected);

        MergeSort ms = new MergeSort();
        ms.sort(arr);

        assertArrayEquals(expected, arr);
    }
}

