package com.vovi.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ArccosTest {

    @ParameterizedTest(name = "arccos({0})")
    @DisplayName("Check boundary values")
    @ValueSource(doubles = {-0.9999, 0, 1}) // Test values close to boundaries
    void checkBoundaryValues(double x) {
        int terms = 10000; // Increase terms for better accuracy near boundaries
        double expected = Math.acos(x); // Expected value using Math.acos
        double actual = Arccos.calc(x, terms); // Actual value from our implementation
        assertEquals(expected, actual, 0.01, "arccos(" + x + ") should be " + expected);
    }

    @ParameterizedTest(name = "arccos({0}) = {1}")
    @DisplayName("Check intermediate values")
    @CsvSource({
            "-0.5, 2.0944",
            "0.5, 1.0472",
            "-0.7071, 2.3562",
            "0.7071, 0.7854"
    })
    void checkIntermediateValues(double x, double expected) {
        int terms = 100; // Number of terms in the Taylor series
        double actual = Arccos.calc(x, terms); // Actual value from our implementation
        assertEquals(expected, actual, 0.0001, "arccos(" + x + ") should be " + expected);
    }

    @ParameterizedTest(name = "arccos({0}) should throw IllegalArgumentException")
    @DisplayName("Check invalid inputs")
    @ValueSource(doubles = {-2, -1.1, 1.1, 2})
    void checkInvalidInputs(double x) {
        int terms = 100; // Number of terms in the Taylor series
        assertThrows(IllegalArgumentException.class, () -> Arccos.calc(x, terms),
                "arccos(" + x + ") should throw IllegalArgumentException");
    }

    @ParameterizedTest(name = "arccos({0}) should throw IllegalArgumentException for invalid terms")
    @DisplayName("Check invalid terms")
    @ValueSource(ints = {-1, -10})
    void checkInvalidTerms(int terms) {
        double x = 0.5;
        assertThrows(IllegalArgumentException.class, () -> Arccos.calc(x, terms),
                "arccos(" + x + ") should throw IllegalArgumentException for invalid terms");
    }
}