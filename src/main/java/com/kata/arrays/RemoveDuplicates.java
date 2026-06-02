package com.kata.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Kata 8: Remove Duplicates from Array
 * 
 * Problem: Remove all duplicate elements from an array.
 * Return an array with only unique elements.
 * Order may not be preserved.
 * 
 * Example:
 *   Input: [1, 2, 2, 3, 4, 4, 5]
 *   Output: [1, 2, 3, 4, 5]
 * 
 * Difficulty: ⭐⭐ Medium
 * Time Complexity: O(n)
 * Space Complexity: O(n) for HashSet
 */
public class RemoveDuplicates {

    /**
     * Basic Solution: Using HashSet
     * Simple and efficient
     */
    public static int[] removeDuplicates(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }

        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : array) {
            uniqueSet.add(num);
        }

        int[] result = new int[uniqueSet.size()];
        int index = 0;
        for (int num : uniqueSet) {
            result[index++] = num;
        }

        return result;
    }

    /**
     * Stream-based Solution
     * Functional approach using streams
     */
    public static int[] removeDuplicatesStream(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }

        return java.util.Arrays.stream(array)
                .distinct()
                .toArray();
    }

    /**
     * Preserve Order Solution: LinkedHashSet
     * Maintains insertion order
     */
    public static int[] removeDuplicatesPreserveOrder(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }

        Set<Integer> uniqueSet = new java.util.LinkedHashSet<>();
        for (int num : array) {
            uniqueSet.add(num);
        }

        int[] result = new int[uniqueSet.size()];
        int index = 0;
        for (int num : uniqueSet) {
            result[index++] = num;
        }

        return result;
    }

    /**
     * Sorted Array Solution: Two-pointer approach
     * Works only on sorted arrays, O(1) space
     * In-place modification of array
     */
    public static int[] removeDuplicatesSorted(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }

        // If not sorted, sort first
        int[] sorted = array.clone();
        java.util.Arrays.sort(sorted);

        int uniqueCount = 1;
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] != sorted[i - 1]) {
                uniqueCount++;
            }
        }

        int[] result = new int[uniqueCount];
        result[0] = sorted[0];
        int index = 1;

        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] != sorted[i - 1]) {
                result[index++] = sorted[i];
            }
        }

        return result;
    }

    /**
     * Get count of unique elements
     */
    public static int countUnique(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        return new HashSet<Integer>(
                java.util.Arrays.asList(
                        java.util.Arrays.stream(array).boxed().toArray(Integer[]::new)
                )
        ).size();
    }

    /**
     * Check if array has duplicates
     */
    public static boolean hasDuplicates(int[] array) {
        if (array == null || array.length <= 1) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}
