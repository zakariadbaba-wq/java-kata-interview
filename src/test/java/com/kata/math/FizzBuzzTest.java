package com.kata.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("FizzBuzz Tests")
class FizzBuzzTest {

    @Test
    @DisplayName("Should handle FizzBuzz for 15")
    void testFizzBuzz15() {
        List<String> result = FizzBuzz.fizzBuzz(15);
        assertEquals(15, result.size());
        assertEquals("Fizz", result.get(2));    // Index 2 = 3
        assertEquals("Buzz", result.get(4));    // Index 4 = 5
        assertEquals("FizzBuzz", result.get(14)); // Index 14 = 15
    }

    @Test
    @DisplayName("Should handle single element")
    void testSingleElement() {
        List<String> result = FizzBuzz.fizzBuzz(1);
        assertEquals(1, result.size());
        assertEquals("1", result.get(0));
    }

    @Test
    @DisplayName("Should handle Fizz only")
    void testFizzOnly() {
        List<String> result = FizzBuzz.fizzBuzz(9);
        assertEquals("Fizz", result.get(2));  // 3
        assertEquals("Fizz", result.get(5));  // 6
        assertEquals("Fizz", result.get(8));  // 9
    }

    @Test
    @DisplayName("Should handle Buzz only")
    void testBuzzOnly() {
        List<String> result = FizzBuzz.fizzBuzz(10);
        assertEquals("Buzz", result.get(4));  // 5
        assertEquals("Buzz", result.get(9));  // 10
    }

    @Test
    @DisplayName("Should handle numbers")
    void testNumbers() {
        List<String> result = FizzBuzz.fizzBuzz(5);
        assertEquals("1", result.get(0));
        assertEquals("2", result.get(1));
        assertEquals("4", result.get(3));
    }

    @Test
    @DisplayName("Flexible solution should match basic")
    void testFlexibleVsBasic() {
        List<String> basic = FizzBuzz.fizzBuzz(15);
        List<String> flexible = FizzBuzz.fizzBuzzFlexible(15);
        assertEquals(basic, flexible);
    }

    @Test
    @DisplayName("All solutions should be consistent")
    void testAllConsistent() {
        List<String> basic = FizzBuzz.fizzBuzz(20);
        List<String> flexible = FizzBuzz.fizzBuzzFlexible(20);
        List<String> dictionary = FizzBuzz.fizzBuzzDictionary(20);

        assertEquals(basic, flexible);
        assertEquals(flexible, dictionary);
    }

    @Test
    @DisplayName("Should work for large numbers")
    void testLargeNumbers() {
        List<String> result = FizzBuzz.fizzBuzz(100);
        assertEquals(100, result.size());
        assertEquals("FizzBuzz", result.get(29)); // 30
    }

    @Test
    @DisplayName("Should handle multiple of 3 and 5 combined")
    void testMultiplesOf15() {
        List<String> result = FizzBuzz.fizzBuzz(30);
        assertEquals("FizzBuzz", result.get(14)); // 15
        assertEquals("FizzBuzz", result.get(29)); // 30
    }
}
