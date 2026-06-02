package com.kata.arrays;

/**
 * Kata 7: Find Second Largest Element in Array
 * 
 * Problem: Find the second largest element in an array of integers.
 * Handle edge cases: array with less than 2 unique elements.
 * 
 * Example:
 *   Input: [1, 5, 3, 9, 2]
 *   Output: 5
 * 
 * Difficulty: ⭐⭐ Medium
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SecondLargestElement {

    /**
     * Basic Solution: Track largest and second largest
     * Single pass through array
     */
    public static int findSecondLargest(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException(
                    "Array must have at least 2 elements");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "Array must have at least 2 unique elements");
        }

        return secondLargest;
    }

    /**
     * Alternative Solution: Handle duplicates differently
     * Allow duplicate largest values
     */
    public static int findSecondLargestAllowDuplicates(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException(
                    "Array must have at least 2 elements");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "Array must have at least 2 elements");
        }

        return secondLargest;
    }

    /**
     * Stream-based Solution: Using Java Streams
     * More functional approach
     */
    public static int findSecondLargestStream(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException(
                    "Array must have at least 2 elements");
        }

        return java.util.Arrays.stream(array)
                .boxed()
                .distinct()
                .sorted((a, b) -> Integer.compare(b, a))
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Array must have at least 2 unique elements"));
    }

    /**
     * Sorting Solution: Sort and pick second largest
     * O(n log n) time - less efficient but simple
     */
    public static int findSecondLargestSorted(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException(
                    "Array must have at least 2 elements");
        }

        int[] sorted = array.clone();
        java.util.Arrays.sort(sorted);

        for (int i = sorted.length - 2; i >= 0; i--) {
            if (sorted[i] != sorted[sorted.length - 1]) {
                return sorted[i];
            }
        }

        throw new IllegalArgumentException(
                "Array must have at least 2 unique elements");
    }

    /**
     * Get top k largest elements
     */
    public static int[] findTopKLargest(int[] array, int k) {
        if (array == null || array.length < k || k <= 0) {
            throw new IllegalArgumentException("Invalid array or k value");
        }

        return java.util.Arrays.stream(array)
                .boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .limit(k)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
