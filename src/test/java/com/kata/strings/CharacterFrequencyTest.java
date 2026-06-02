package com.kata.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Character Frequency Tests")
class CharacterFrequencyTest {

    @Test
    @DisplayName("Should count frequency of single character")
    void testSingleCharacter() {
        Map<Character, Integer> freq = CharacterFrequency.countFrequency("a");
        assertEquals(1, freq.get('a'));
    }

    @Test
    @DisplayName("Should count frequency in simple string")
    void testSimpleString() {
        Map<Character, Integer> freq = CharacterFrequency.countFrequency("hello");
        assertEquals(1, freq.get('h'));
        assertEquals(1, freq.get('e'));
        assertEquals(2, freq.get('l'));
        assertEquals(1, freq.get('o'));
    }

    @Test
    @DisplayName("Should ignore case")
    void testIgnoreCase() {
        Map<Character, Integer> freq = CharacterFrequency.countFrequency("Hello");
        assertEquals(1, freq.get('h'));
        assertEquals(1, freq.get('e'));
        assertEquals(2, freq.get('l'));
        assertEquals(1, freq.get('o'));
    }

    @Test
    @DisplayName("Should handle empty string")
    void testEmptyString() {
        Map<Character, Integer> freq = CharacterFrequency.countFrequency("");
        assertTrue(freq.isEmpty());
    }

    @Test
    @DisplayName("Should handle null")
    void testNull() {
        Map<Character, Integer> freq = CharacterFrequency.countFrequency(null);
        assertTrue(freq.isEmpty());
    }

    @Test
    @DisplayName("Should include spaces")
    void testWithSpaces() {
        Map<Character, Integer> freq = CharacterFrequency.countFrequency("hello world");
        assertEquals(1, freq.get(' '));
    }

    @Test
    @DisplayName("Should find most frequent character")
    void testMostFrequent() {
        Character mostFreq = CharacterFrequency.findMostFrequent("aabbbbcc");
        assertEquals('b', mostFreq);
    }

    @Test
    @DisplayName("Should exclude spaces when specified")
    void testNoSpaces() {
        Map<Character, Integer> freq = CharacterFrequency.countFrequencyNoSpaces("hello world");
        assertFalse(freq.containsKey(' '));
    }

    @Test
    @DisplayName("Array-based solution should match HashMap")
    void testArrayVsHashMap() {
        String input = "programming";
        Map<Character, Integer> hashFreq = CharacterFrequency.countFrequency(input);
        Map<Character, Integer> arrayFreq = CharacterFrequency.countFrequencyArray(input);

        assertEquals(hashFreq.size(), arrayFreq.size());
        for (char c : hashFreq.keySet()) {
            assertEquals(hashFreq.get(c), arrayFreq.get(c));
        }
    }

    @Test
    @DisplayName("Should count all characters in string")
    void testAllCharactersCounted() {
        Map<Character, Integer> freq = CharacterFrequency.countFrequency("aaa");
        assertEquals(1, freq.size());
        assertEquals(3, freq.get('a'));
    }

    @Test
    @DisplayName("Special characters should be included")
    void testSpecialCharacters() {
        Map<Character, Integer> freq = CharacterFrequency.countFrequencyNoSpaces("a!b!c");
        assertEquals(2, freq.get('!'));
    }
}
