package com.assignment1;

import com.assignment1.geometry.ClosestPair;
import com.assignment1.geometry.Point2D;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class ClosestPairTest {
    @Test
    public void testSimplePair() {
        Point2D[] pts = {
                new Point2D(0, 0),
                new Point2D(1, 1),
                new Point2D(2, 2),
                new Point2D(1.1, 1.1)
        };
        ClosestPair cp = new ClosestPair();
        double result = cp.find(pts);
        assertTrue(result < 0.2);
    }

    @Test
    public void testAgainstBruteForce() {
        int n = 500;
        Point2D[] pts = new Point2D[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            pts[i] = new Point2D(rand.nextDouble() * 1000, rand.nextDouble() * 1000);
        }

        ClosestPair cp = new ClosestPair();
        double fast = cp.find(pts);
        double slow = bruteForce(pts);

        assertEquals(slow, fast, 1e-12);
    }

    private double bruteForce(Point2D[] pts) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < pts.length; i++) {
            for (int j = i + 1; j < pts.length; j++) {
                double dx = pts[i].x - pts[j].x;
                double dy = pts[i].y - pts[j].y;
                double dist = Math.sqrt(dx * dx + dy * dy);
                min = Math.min(min, dist);
            }
        }
        return min;
    }
}
