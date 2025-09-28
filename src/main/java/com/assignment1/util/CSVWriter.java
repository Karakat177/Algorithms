package com.assignment1.util;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    public static void writeHeader(String filename) {
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write("Algorithm,Size,Time,Comparisons,Swaps,MaxDepth\n");
        } catch (IOException e) {
            System.err.println("CSV write error: " + e.getMessage());
        }
    }

    public static void write(String filename, String algo, Metrics m, int n) {
        try (FileWriter fw = new FileWriter(filename, true)) {
            fw.write(algo + "," + n + "," + m.timeMillis + "," + m.comparisons + "," + m.swaps + "," + m.maxDepth + "\n");
        } catch (IOException e) {
            System.err.println("CSV write error: " + e.getMessage());
        }
    }
}
