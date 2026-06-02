package com.kata.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Factorial Tests")
class FactorialTest {

    @Test
    @DisplayName("Should calculate factorial of 5")
    void testFactorial5() {
        assertEquals(120, Factorial.factorialIterative(5));
    }

    @Test
    @DisplayName("Should handle 0 factorial")
    void testFactorial0() {
        assertEquals(1, Factorial.factorialIterative(0));
    }

    @Test
    @DisplayName("Should handle 1 factorial")
    void testFactorial1() {
        assertEquals(1, Factorial.factorialIterative(1));
    }

    @Test
    @DisplayName("Should calculate factorial of 10")
    void testFactorial10() {
        assertEquals(3628800, Factorial.factorialIterative(10));
    }

    @Test
    @DisplayName("Recursive should match iterative")
    void testRecursiveVsIterative() {
        for (int i = 0; i <= 15; i++) {
            assertEquals(
                    Factorial.factorialIterative(i),
                    Factorial.factorialRecursive(i)
            );
        }
    }

    @Test
    @DisplayName("Tail-recursive should match iterative")
    void testTailRecursiveVsIterative() {
        for (int i = 0; i <= 15; i++) {
            assertEquals(
                    Factorial.factorialIterative(i),
                    Factorial.factorialTailRecursive(i)
            );
        }
    }

    @Test
    @DisplayName("Should throw exception for negative")
    void testNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorialIterative(-1);
        });
    }

    @Test
    @DisplayName("Should validate input bounds")
    void testValidInputBounds() {
        assertTrue(Factorial.isValidFactorialInput(0));
        assertTrue(Factorial.isValidFactorialInput(20));
        assertFalse(Factorial.isValidFactorialInput(21));
        assertFalse(Factorial.isValidFactorialInput(-1));
    }

    @Test
    @DisplayName("Safe factorial should work within bounds")
    void testSafeFactorial() {
        assertEquals(120, Factorial.factorialSafe(5));
    }

    @Test
    @DisplayName("Safe factorial should throw for overflow")
    void testSafeFactorialOverflow() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorialSafe(21);
        });
    }

    @Test
    @DisplayName("Should calculate 20!")
    void testFactorial20() {
        assertEquals(2432902008176640000L, Factorial.factorialIterative(20));
    }
}
