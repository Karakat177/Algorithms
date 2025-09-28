package com.assignment1;

import com.assignment1.sort.DeterministicSelect;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class SelectTest {
    @Test
    public void testMatchesSortedKth() {
        Random rand = new Random();
        for (int t = 0; t < 100; t++) {
            int n = rand.nextInt(500) + 50;
            int[] arr = rand.ints(n, 0, 10000).toArray();
            int[] sorted = arr.clone();
            Arrays.sort(sorted);
            int k = rand.nextInt(n);

            DeterministicSelect ds = new DeterministicSelect();
            int result = ds.select(arr.clone(), k);

            assertEquals(sorted[k], result);
        }
    }
}
