package com.assignment1;

import com.assignment1.sort.MergeSort;
import com.assignment1.sort.QuickSort;
import com.assignment1.sort.DeterministicSelect;
import com.assignment1.geometry.ClosestPair;
import com.assignment1.geometry.Point2D;
import com.assignment1.util.Metrics;
import com.assignment1.util.CSVWriter;
import com.assignment1.util.ArraysUtil;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] sizes = {100, 500, 1000, 5000, 10000};

        CSVWriter.writeHeader("results.csv");

        for (int n : sizes) {
            int[] arr = ArraysUtil.randomIntArray(n, 100000);

            // MergeSort
            Metrics m1 = new Metrics();
            MergeSort ms = new MergeSort();
            m1.startTimer();
            ms.sort(ArraysUtil.copy(arr));
            m1.stopTimer();
            m1.comparisons = ms.comparisons;
            m1.swaps = ms.swaps;
            m1.maxDepth = ms.maxDepth;
            CSVWriter.write("results.csv", "MergeSort", m1, n);

            // QuickSort
            Metrics m2 = new Metrics();
            QuickSort qs = new QuickSort();
            m2.startTimer();
            qs.sort(ArraysUtil.copy(arr));
            m2.stopTimer();
            m2.comparisons = qs.comparisons;
            m2.swaps = qs.swaps;
            m2.maxDepth = qs.maxDepth;
            CSVWriter.write("results.csv", "QuickSort", m2, n);

            // Select
            Metrics m3 = new Metrics();
            DeterministicSelect ds = new DeterministicSelect();
            m3.startTimer();
            ds.select(ArraysUtil.copy(arr), n / 2);
            m3.stopTimer();
            m3.comparisons = ds.comparisons;
            m3.swaps = ds.swaps;
            m3.maxDepth = ds.maxDepth;
            CSVWriter.write("results.csv", "Select", m3, n);

            // Closest Pair
            Metrics m4 = new Metrics();
            Point2D[] pts = new Point2D[n];
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                pts[i] = new Point2D(rand.nextDouble() * 1000, rand.nextDouble() * 1000);
            }
            ClosestPair cp = new ClosestPair();
            m4.startTimer();
            cp.find(pts);
            m4.stopTimer();
            m4.comparisons = cp.comparisons;
            m4.swaps = 0;
            m4.maxDepth = cp.maxDepth;
            CSVWriter.write("results.csv", "ClosestPair", m4, n);

            System.out.println("Done. Results saved to results.csv");
        }
    }

}
