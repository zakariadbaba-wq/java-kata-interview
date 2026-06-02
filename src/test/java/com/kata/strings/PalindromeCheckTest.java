package com.kata.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Palindrome Check Tests")
class PalindromeCheckTest {

    @Test
    @DisplayName("Should identify simple palindrome")
    void testSimplePalindrome() {
        assertTrue(PalindromeCheck.isPalindrome("racecar"));
    }

    @Test
    @DisplayName("Should identify non-palindrome")
    void testNonPalindrome() {
        assertFalse(PalindromeCheck.isPalindrome("hello"));
    }

    @Test
    @DisplayName("Should ignore case")
    void testIgnoreCase() {
        assertTrue(PalindromeCheck.isPalindrome("RaceCar"));
    }

    @Test
    @DisplayName("Should ignore spaces")
    void testIgnoreSpaces() {
        assertTrue(PalindromeCheck.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    @DisplayName("Should handle single character")
    void testSingleCharacter() {
        assertTrue(PalindromeCheck.isPalindromeStrict("a"));
    }

    @Test
    @DisplayName("Should handle empty string")
    void testEmptyString() {
        assertTrue(PalindromeCheck.isPalindromeStrict(""));
    }

    @Test
    @DisplayName("Should handle null")
    void testNull() {
        assertFalse(PalindromeCheck.isPalindrome(null));
    }

    @Test
    @DisplayName("Should handle special characters")
    void testSpecialCharacters() {
        assertTrue(PalindromeCheck.isPalindrome("a1b1a"));
    }

    @Test
    @DisplayName("Two-pointer optimization should match basic solution")
    void testOptimizedVsBasic() {
        String input = "A man a plan a canal Panama";
        assertEquals(
                PalindromeCheck.isPalindrome(input),
                PalindromeCheck.isPalindromeOptimized(input)
        );
    }

    @Test
    @DisplayName("Should handle punctuation")
    void testPunctuation() {
        assertTrue(PalindromeCheck.isPalindrome("Was it a car or a cat I saw?"));
    }

    @Test
    @DisplayName("Numbers should be handled")
    void testWithNumbers() {
        assertTrue(PalindromeCheck.isPalindromeOptimized("12321"));
    }

    @Test
    @DisplayName("Single space is palindrome")
    void testSingleSpace() {
        assertTrue(PalindromeCheck.isPalindromeStrict(" "));
    }
}
