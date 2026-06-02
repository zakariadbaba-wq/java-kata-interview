package com.kata.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Second Largest Element Tests")
class SecondLargestElementTest {

    @Test
    @DisplayName("Should find second largest in normal array")
    void testSecondLargest() {
        int[] array = {1, 5, 3, 9, 2};
        assertEquals(5, SecondLargestElement.findSecondLargest(array));
    }

    @Test
    @DisplayName("Should handle array with two elements")
    void testTwoElements() {
        int[] array = {1, 2};
        assertEquals(1, SecondLargestElement.findSecondLargest(array));
    }

    @Test
    @DisplayName("Should handle negative numbers")
    void testNegativeNumbers() {
        int[] array = {-1, -5, -3, -9, -2};
        assertEquals(-2, SecondLargestElement.findSecondLargest(array));
    }

    @Test
    @DisplayName("Should throw with array too small")
    void testArrayTooSmall() {
        assertThrows(IllegalArgumentException.class, () -> {
            SecondLargestElement.findSecondLargest(new int[]{1});
        });
    }

    @Test
    @DisplayName("Should throw with null array")
    void testNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            SecondLargestElement.findSecondLargest(null);
        });
    }

    @Test
    @DisplayName("Stream solution should match basic")
    void testStreamVsBasic() {
        int[] array = {1, 5, 3, 9, 2};
        assertEquals(
                SecondLargestElement.findSecondLargest(array),
                SecondLargestElement.findSecondLargestStream(array)
        );
    }

    @Test
    @DisplayName("Should handle duplicates correctly")
    void testDuplicates() {
        int[] array = {5, 5, 3, 9, 2};
        assertEquals(5, SecondLargestElement.findSecondLargest(array));
    }

    @Test
    @DisplayName("Find top 3 elements")
    void testTopKLargest() {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] topK = SecondLargestElement.findTopKLargest(array, 3);
        assertEquals(3, topK.length);
        assertEquals(9, topK[0]);
        assertEquals(6, topK[1]);
        assertEquals(5, topK[2]);
    }

    @Test
    @DisplayName("Should throw when k is invalid")
    void testInvalidK() {
        int[] array = {1, 2, 3};
        assertThrows(IllegalArgumentException.class, () -> {
            SecondLargestElement.findTopKLargest(array, 5);
        });
    }

    @Test
    @DisplayName("Sorted solution should match basic")
    void testSortedVsBasic() {
        int[] array = {1, 5, 3, 9, 2};
        assertEquals(
                SecondLargestElement.findSecondLargest(array),
                SecondLargestElement.findSecondLargestSorted(array)
        );
    }
}
