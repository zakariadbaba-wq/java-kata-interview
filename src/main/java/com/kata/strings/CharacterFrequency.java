package com.kata.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Kata 3: Character Frequency in a String
 * 
 * Problem: Count the frequency of each character in a string.
 * Return a map with characters as keys and their counts as values.
 * Ignore case sensitivity (treat 'A' and 'a' as same).
 * 
 * Example:
 *   Input: "Hello"
 *   Output: {h=1, e=1, l=2, o=1}
 * 
 * Difficulty: ⭐⭐ Medium
 * Time Complexity: O(n)
 * Space Complexity: O(k) where k is number of unique characters
 */
public class CharacterFrequency {

    /**
     * Basic Solution: Using HashMap
     */
    public static Map<Character, Integer> countFrequency(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        if (input == null || input.isEmpty()) {
            return frequencyMap;
        }

        String lowercase = input.toLowerCase();

        for (char c : lowercase.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        return frequencyMap;
    }

    /**
     * Alternative Solution: Excluding spaces
     * Count only alphabetic characters
     */
    public static Map<Character, Integer> countFrequencyNoSpaces(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        if (input == null || input.isEmpty()) {
            return frequencyMap;
        }

        String lowercase = input.toLowerCase();

        for (char c : lowercase.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
        }

        return frequencyMap;
    }

    /**
     * Optimized Solution: Using array for ASCII characters
     * Faster for small character sets (a-z only)
     */
    public static Map<Character, Integer> countFrequencyArray(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        if (input == null || input.isEmpty()) {
            return frequencyMap;
        }

        int[] frequency = new int[26]; // For a-z

        for (char c : input.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                frequency[c - 'a']++;
            }
        }

        // Convert array to map
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                frequencyMap.put((char) ('a' + i), frequency[i]);
            }
        }

        return frequencyMap;
    }

    /**
     * Find the most frequently occurring character
     */
    public static Character findMostFrequent(String input) {
        Map<Character, Integer> frequencyMap = countFrequencyNoSpaces(input);

        if (frequencyMap.isEmpty()) {
            return null;
        }

        return frequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
