package com.assignment1.geometry;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {
    public int comparisons = 0;
    public int maxDepth = 0;

    public double find(Point2D[] points) {
        if (points == null || points.length < 2) return Double.POSITIVE_INFINITY;
        Point2D[] sortedX = points.clone();
        Point2D[] sortedY = points.clone();
        Arrays.sort(sortedX, Comparator.comparingDouble(p -> p.x));
        Arrays.sort(sortedY, Comparator.comparingDouble(p -> p.y));
        return closest(sortedX, sortedY, 0, points.length - 1, 1);
    }

    private double closest(Point2D[] px, Point2D[] py, int l, int r, int depth) {
        maxDepth = Math.max(maxDepth, depth);

        if (r - l <= 3) {
            double min = Double.POSITIVE_INFINITY;
            for (int i = l; i <= r; i++) {
                for (int j = i + 1; j <= r; j++) {
                    comparisons++;
                    min = Math.min(min, dist(px[i], px[j]));
                }
            }
            return min;
        }

        int mid = (l + r) / 2;
        double midX = px[mid].x;


        Point2D[] leftY = new Point2D[mid - l + 1];
        Point2D[] rightY = new Point2D[r - mid];
        int li = 0, ri = 0;
        for (Point2D p : py) {
            if (p.x <= midX) leftY[li++] = p;
            else rightY[ri++] = p;
        }

        double d1 = closest(px, leftY, l, mid, depth + 1);
        double d2 = closest(px, rightY, mid + 1, r, depth + 1);
        double d = Math.min(d1, d2);


        Point2D[] strip = new Point2D[py.length];
        int s = 0;
        for (Point2D p : py) {
            if (Math.abs(p.x - midX) < d) {
                strip[s++] = p;
            }
        }


        for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s && strip[j].y - strip[i].y < d; j++) {
                comparisons++;
                double dist = dist(strip[i], strip[j]);
                if (dist < d) d = dist;
            }
        }

        return d;
    }

    private double dist(Point2D a, Point2D b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
