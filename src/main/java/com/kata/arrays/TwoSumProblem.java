package com.kata.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Kata 9: Two Sum Problem
 * 
 * Problem: Given an array of integers and a target sum, find two numbers
 * that add up to the target. Return their indices.
 * Assumption: Each input has exactly one solution, no element used twice.
 * 
 * Example:
 *   Input: nums = [2, 7, 11, 15], target = 9
 *   Output: [0, 1] (because nums[0] + nums[1] = 2 + 7 = 9)
 * 
 * Difficulty: ⭐⭐ Medium
 * Time Complexity: O(n) with HashMap
 * Space Complexity: O(n) for HashMap
 */
public class TwoSumProblem {

    /**
     * Basic Solution: Brute Force
     * O(n^2) time - check every pair
     * O(1) space
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution found");
    }

    /**
     * Optimized Solution: HashMap approach
     * O(n) time - single pass with lookup
     * O(n) space - HashMap storage
     * BEST solution for interviews
     */
    public static int[] twoSumHashMap(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (indexMap.containsKey(complement)) {
                return new int[]{indexMap.get(complement), i};
            }

            indexMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution found");
    }

    /**
     * Two-Pointer Solution: For sorted array
     * O(n log n) time - due to sorting
     * O(1) space - no extra data structure
     * Works only if array is sorted or can be sorted
     */
    public static int[] twoSumSorted(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        throw new IllegalArgumentException("No two sum solution found");
    }

    /**
     * Find all pairs with given sum
     * Can have multiple solutions
     */
    public static java.util.List<int[]> findAllTwoSum(int[] nums, int target) {
        java.util.List<int[]> result = new java.util.ArrayList<>();

        if (nums == null || nums.length < 2) {
            return result;
        }

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (indexMap.containsKey(complement)) {
                result.add(new int[]{indexMap.get(complement), i});
            }

            indexMap.put(nums[i], i);
        }

        return result;
    }

    /**
     * Find three numbers that sum to target
     * Extension of two sum problem
     */
    public static int[] threeSumToTarget(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("Array must have at least 3 elements");
        }

        for (int i = 0; i < nums.length - 2; i++) {
            int remaining = target - nums[i];
            try {
                int[] pair = twoSumHashMap(
                        java.util.Arrays.copyOfRange(nums, i + 1, nums.length),
                        remaining
                );
                return new int[]{i, pair[0] + i + 1, pair[1] + i + 1};
            } catch (IllegalArgumentException e) {
                // Continue to next iteration
            }
        }

        throw new IllegalArgumentException("No three sum solution found");
    }
}
