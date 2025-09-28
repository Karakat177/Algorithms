package com.assignment1.util;

public class Metrics {
    public int comparisons = 0;
    public int maxDepth = 0;
    public long timeMillis = 0;
    public int swaps = 0;

    public void startTimer() {
        timeMillis = System.currentTimeMillis();
    }

    public void stopTimer() {
        timeMillis = System.currentTimeMillis() - timeMillis;
    }

    public void print(String name) {
        System.out.println(name + " Metrics:");
        System.out.println("Time (ms): " + timeMillis);
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println("Max Recursion Depth: " + maxDepth);
    }
}
