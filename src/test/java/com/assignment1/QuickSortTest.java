package com.assignment1;

import com.assignment1.sort.QuickSort;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {
    @Test
    public void testSortedCorrectly() {
        int[] arr = new Random().ints(1000, 0, 10000).toArray();
        int[] expected = arr.clone();
        Arrays.sort(expected);

        QuickSort qs = new QuickSort();
        qs.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testDepthBounded() {
        int n = 10000;
        int[] arr = new Random().ints(n, 0, 100000).toArray();
        QuickSort qs = new QuickSort();
        qs.sort(arr);

        int bound = 2 * (int) Math.floor(Math.log(n) / Math.log(2)) + 10;
        assertTrue(qs.maxDepth <= bound);
    }
}
