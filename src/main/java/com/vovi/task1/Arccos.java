package com.vovi.task1;

public class Arccos {

    // Method to calculate arccos using the Taylor series expansion
    public static double calc(double x, int terms) {
        // Ensure x is within the domain of arccos [-1, 1]
        if (x < -1 || x > 1) {
            throw new IllegalArgumentException("x must be in [-1, 1]");
        }

        // Ensure terms is non-negative
        if (terms < 0) {
            throw new IllegalArgumentException("terms must be >= 0");
        }

        // Use identity for values close to 1 or -1
        if (x > 0.999999 || x < -0.999999) {
            return arccosNearBoundary(x, terms);
        }

        // Use Taylor series for other values
        return arccosTaylorSeries(x, terms);
    }

    // Taylor series implementation for arccos(x)
    private static double arccosTaylorSeries(double x, int terms) {
        double result = Math.PI / 2; // First term π/2
        double term = x; // First term in the series: x

        for (int n = 0; n < terms; n++) {
            // Update the result with the current term
            result -= term;

            // Compute the next term iteratively to avoid numerical overflow
            if (n < terms - 1) {
                term *= x * x * (2 * n + 1) * (2 * n + 1) / ((2 * n + 2) * (2 * n + 3));
            }
        }

        return result;
    }

    // Identity-based implementation for values close to 1 or -1
    private static double arccosNearBoundary(double x, int terms) {
        // Use the identity: arccos(x) = 2 * arcsin(sqrt((1 - x) / 2))
        double sqrtArg = (1 - x) / 2;
        double arcsinArg = Math.sqrt(sqrtArg);
        return 2 * arcsinTaylorSeries(arcsinArg, terms);
    }

    // Taylor series implementation for arcsin(x)
    private static double arcsinTaylorSeries(double x, int terms) {
        double result = x; // First term: x
        double term = x; // First term in the series: x
        double xx = x * x; // x^2

        for (int n = 1; n < terms; n++) {
            // Compute the next term iteratively
            term *= xx * (2 * n - 1) / (2 * n);

            // Update the result with the current term
            result += term / (2 * n + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        double x1 = -0.999999;
        double x2 = 0.999999;
        int terms = 1000; // Increase terms for better accuracy near boundaries

        System.out.println("Arccos(" + x1 + ") = " + calc(x1, terms));
        System.out.println("Arccos(" + x2 + ") = " + calc(x2, terms));
    }
}