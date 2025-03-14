package com.vovi.task1;

public class Arccos {

    public static double calc(double x, int terms) {
        if (x < -1 || x > 1) {
            throw new IllegalArgumentException("x must be in [-1, 1]");
        }
        if (terms < 0) {
            throw new IllegalArgumentException("terms must be >= 0");
        }
        return arccosTaylorSeries(x, terms);
    }

    private static double arccosTaylorSeries(double x, int terms) {
        double result = Math.PI / 2;
        double term = x;
        for (int n = 0; n < terms; n++) {
            result -= term;
            if (n < terms - 1) {
                term *= x * x * (2 * n + 1) * (2 * n + 1) / ((2 * n + 2) * (2 * n + 3));
            }
        }
        return result;
    }

    private static double arccosNearBoundary(double x, int terms) {
        double sqrtArg = (1 - x) / 2;
        double arcsinArg = Math.sqrt(sqrtArg);
        return 2 * arcsinTaylorSeries(arcsinArg, terms);
    }

    private static double arcsinTaylorSeries(double x, int terms) {
        double result = x;
        double term = x;
        double xx = x * x;
        for (int n = 1; n < terms; n++) {
            term *= xx * (2 * n - 1) / (2 * n);
            result += term / (2 * n + 1);
        }
        return result;
    }
}