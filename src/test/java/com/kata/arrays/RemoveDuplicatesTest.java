package com.kata.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Remove Duplicates Tests")
class RemoveDuplicatesTest {

    @Test
    @DisplayName("Should remove duplicates from array")
    void testRemoveDuplicates() {
        int[] array = {1, 2, 2, 3, 4, 4, 5};
        int[] result = RemoveDuplicates.removeDuplicates(array);
        assertEquals(5, result.length);
        assertTrue(Arrays.stream(result).anyMatch(x -> x == 1));
        assertTrue(Arrays.stream(result).anyMatch(x -> x == 2));
        assertTrue(Arrays.stream(result).anyMatch(x -> x == 3));
        assertTrue(Arrays.stream(result).anyMatch(x -> x == 4));
        assertTrue(Arrays.stream(result).anyMatch(x -> x == 5));
    }

    @Test
    @DisplayName("Should handle array with no duplicates")
    void testNoDuplicates() {
        int[] array = {1, 2, 3, 4, 5};
        int[] result = RemoveDuplicates.removeDuplicates(array);
        assertEquals(5, result.length);
    }

    @Test
    @DisplayName("Should handle array with all duplicates")
    void testAllDuplicates() {
        int[] array = {1, 1, 1, 1, 1};
        int[] result = RemoveDuplicates.removeDuplicates(array);
        assertEquals(1, result.length);
        assertEquals(1, result[0]);
    }

    @Test
    @DisplayName("Should handle empty array")
    void testEmptyArray() {
        int[] array = {};
        int[] result = RemoveDuplicates.removeDuplicates(array);
        assertEquals(0, result.length);
    }

    @Test
    @DisplayName("Should handle null")
    void testNull() {
        int[] result = RemoveDuplicates.removeDuplicates(null);
        assertEquals(0, result.length);
    }

    @Test
    @DisplayName("Stream solution should work")
    void testStreamSolution() {
        int[] array = {1, 2, 2, 3, 4, 4, 5};
        int[] result = RemoveDuplicates.removeDuplicatesStream(array);
        assertEquals(5, result.length);
    }

    @Test
    @DisplayName("Should preserve order with LinkedHashSet")
    void testPreserveOrder() {
        int[] array = {5, 3, 5, 1, 3, 2};
        int[] result = RemoveDuplicates.removeDuplicatesPreserveOrder(array);
        assertEquals(4, result.length);
        assertEquals(5, result[0]); // First appearance
        assertEquals(3, result[1]); // First appearance
        assertEquals(1, result[2]); // First appearance
        assertEquals(2, result[3]); // First appearance
    }

    @Test
    @DisplayName("Should detect duplicates")
    void testHasDuplicates() {
        assertTrue(RemoveDuplicates.hasDuplicates(new int[]{1, 2, 2, 3}));
        assertFalse(RemoveDuplicates.hasDuplicates(new int[]{1, 2, 3, 4}));
    }

    @Test
    @DisplayName("Should count unique elements")
    void testCountUnique() {
        assertEquals(5, RemoveDuplicates.countUnique(new int[]{1, 2, 2, 3, 4, 4, 5}));
        assertEquals(4, RemoveDuplicates.countUnique(new int[]{1, 1, 1, 1}));
    }

    @Test
    @DisplayName("Sorted solution should work")
    void testSortedSolution() {
        int[] array = {1, 2, 2, 3, 4, 4, 5};
        int[] result = RemoveDuplicates.removeDuplicatesSorted(array);
        assertEquals(5, result.length);
    }

    @Test
    @DisplayName("Should handle single element")
    void testSingleElement() {
        int[] array = {42};
        int[] result = RemoveDuplicates.removeDuplicates(array);
        assertEquals(1, result.length);
        assertEquals(42, result[0]);
    }
}
