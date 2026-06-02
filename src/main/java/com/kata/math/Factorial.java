package com.kata.math;

/**
 * Kata 5: Factorial
 * 
 * Problem: Calculate the factorial of a number n.
 * Factorial is the product of all positive integers less than or equal to n.
 * 
 * Example:
 *   5! = 5 × 4 × 3 × 2 × 1 = 120
 *   0! = 1 (by definition)
 * 
 * Difficulty: ⭐ Easy
 * Time Complexity: O(n)
 * Space Complexity: O(1) for iterative, O(n) for recursive (call stack)
 */
public class Factorial {

    /**
     * Iterative Solution: Simple loop-based approach
     * Most efficient, no risk of stack overflow
     */
    public static long factorialIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    /**
     * Recursive Solution: Classic recursive approach
     * Shows understanding of recursion
     * WARNING: Risk of stack overflow for large n
     */
    public static long factorialRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }

        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recursive case
        return n * factorialRecursive(n - 1);
    }

    /**
     * Optimized Solution: Tail-recursive (though Java doesn't optimize it)
     * Better form of recursion
     */
    public static long factorialTailRecursive(int n) {
        return factorialTailRecursiveHelper(n, 1);
    }

    private static long factorialTailRecursiveHelper(int n, long accumulator) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }

        if (n == 0 || n == 1) {
            return accumulator;
        }

        return factorialTailRecursiveHelper(n - 1, n * accumulator);
    }

    /**
     * Validate if n is within reasonable bounds
     * Prevents overflow for large factorials
     */
    public static boolean isValidFactorialInput(int n) {
        return n >= 0 && n <= 20; // 20! fits in long
    }

    /**
     * Calculate factorial with overflow check
     */
    public static long factorialSafe(int n) {
        if (!isValidFactorialInput(n)) {
            throw new IllegalArgumentException(
                    "n must be between 0 and 20 to avoid overflow");
        }

        return factorialIterative(n);
    }
}
