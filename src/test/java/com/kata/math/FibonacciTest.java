package com.kata.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Fibonacci Tests")
class FibonacciTest {

    @Test
    @DisplayName("Should calculate fib(0)")
    void testFib0() {
        assertEquals(0, Fibonacci.fibonacciIterative(0));
    }

    @Test
    @DisplayName("Should calculate fib(1)")
    void testFib1() {
        assertEquals(1, Fibonacci.fibonacciIterative(1));
    }

    @Test
    @DisplayName("Should calculate fib(5)")
    void testFib5() {
        assertEquals(5, Fibonacci.fibonacciIterative(5));
    }

    @Test
    @DisplayName("Should calculate fib(10)")
    void testFib10() {
        assertEquals(55, Fibonacci.fibonacciIterative(10));
    }

    @Test
    @DisplayName("Memoized should match iterative")
    void testMemoizedVsIterative() {
        for (int i = 0; i <= 20; i++) {
            assertEquals(
                    Fibonacci.fibonacciIterative(i),
                    Fibonacci.fibonacciMemoized(i)
            );
        }
    }

    @Test
    @DisplayName("Array-based should match iterative")
    void testArrayVsIterative() {
        for (int i = 0; i <= 20; i++) {
            assertEquals(
                    Fibonacci.fibonacciIterative(i),
                    Fibonacci.fibonacciArray(i)
            );
        }
    }

    @Test
    @DisplayName("Naive recursive should work for small n")
    void testNaiveRecursive() {
        assertEquals(5, Fibonacci.fibonacciNaive(5));
    }

    @Test
    @DisplayName("Should generate Fibonacci sequence")
    void testGenerateSequence() {
        long[] seq = Fibonacci.generateFibonacciSequence(6);
        long[] expected = {0, 1, 1, 2, 3, 5};
        assertArrayEquals(expected, seq);
    }

    @Test
    @DisplayName("Should handle empty sequence")
    void testEmptySequence() {
        long[] seq = Fibonacci.generateFibonacciSequence(0);
        assertEquals(0, seq.length);
    }

    @Test
    @DisplayName("Should identify Fibonacci numbers")
    void testIsFibonacciNumber() {
        assertTrue(Fibonacci.isFibonacciNumber(0));
        assertTrue(Fibonacci.isFibonacciNumber(1));
        assertTrue(Fibonacci.isFibonacciNumber(5));
        assertTrue(Fibonacci.isFibonacciNumber(55));
        assertFalse(Fibonacci.isFibonacciNumber(4));
        assertFalse(Fibonacci.isFibonacciNumber(10));
    }

    @Test
    @DisplayName("Should throw exception for negative")
    void testNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Fibonacci.fibonacciIterative(-1);
        });
    }

    @Test
    @DisplayName("Iterative should be most efficient")
    void testIterativeEfficiency() {
        long start = System.currentTimeMillis();
        long result = Fibonacci.fibonacciIterative(30);
        long end = System.currentTimeMillis();
        
        assertEquals(832040, result);
        assertTrue((end - start) < 100); // Should be very fast
    }

    @Test
    @DisplayName("Large Fibonacci number")
    void testLargeFibonacci() {
        assertEquals(89, Fibonacci.fibonacciIterative(11));
        assertEquals(987, Fibonacci.fibonacciIterative(16));
    }
}
