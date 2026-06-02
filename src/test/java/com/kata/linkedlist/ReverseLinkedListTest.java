package com.kata.linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Reverse Linked List Tests")
class ReverseLinkedListTest {

    @Test
    @DisplayName("Should reverse a simple linked list")
    void testReverseSimple() {
        ListNode head = ListNode.fromArray(new int[]{1, 2, 3, 4, 5});
        ListNode reversed = ReverseLinkedList.reverseIterative(head);
        int[] result = ListNode.toArray(reversed);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, result);
    }

    @Test
    @DisplayName("Should handle single node")
    void testSingleNode() {
        ListNode head = new ListNode(42);
        ListNode reversed = ReverseLinkedList.reverseIterative(head);
        assertEquals(42, reversed.val);
        assertNull(reversed.next);
    }

    @Test
    @DisplayName("Should handle null")
    void testNull() {
        ListNode reversed = ReverseLinkedList.reverseIterative(null);
        assertNull(reversed);
    }

    @Test
    @DisplayName("Recursive should match iterative")
    void testRecursiveVsIterative() {
        int[] arr = {1, 2, 3, 4, 5};
        
        ListNode head1 = ListNode.fromArray(arr);
        ListNode reversed1 = ReverseLinkedList.reverseIterative(head1);
        int[] result1 = ListNode.toArray(reversed1);
        
        ListNode head2 = ListNode.fromArray(arr);
        ListNode reversed2 = ReverseLinkedList.reverseRecursive(head2);
        int[] result2 = ListNode.toArray(reversed2);
        
        assertArrayEquals(result1, result2);
    }

    @Test
    @DisplayName("Should reverse two nodes")
    void testTwoNodes() {
        ListNode head = ListNode.fromArray(new int[]{1, 2});
        ListNode reversed = ReverseLinkedList.reverseIterative(head);
        int[] result = ListNode.toArray(reversed);
        assertArrayEquals(new int[]{2, 1}, result);
    }

    @Test
    @DisplayName("Recursive helper should work")
    void testRecursiveHelper() {
        ListNode head = ListNode.fromArray(new int[]{1, 2, 3, 4});
        ListNode reversed = ReverseLinkedList.reverseRecursiveHelper(head);
        int[] result = ListNode.toArray(reversed);
        assertArrayEquals(new int[]{4, 3, 2, 1}, result);
    }

    @Test
    @DisplayName("Should reverse between indices")
    void testReverseBetween() {
        ListNode head = ListNode.fromArray(new int[]{1, 2, 3, 4, 5});
        ListNode reversed = ReverseLinkedList.reverseBetween(head, 2, 4);
        int[] result = ListNode.toArray(reversed);
        assertArrayEquals(new int[]{1, 4, 3, 2, 5}, result);
    }

    @Test
    @DisplayName("Should reverse k groups")
    void testReverseKGroup() {
        ListNode head = ListNode.fromArray(new int[]{1, 2, 3, 4, 5});
        ListNode reversed = ReverseLinkedList.reverseKGroup(head, 2);
        int[] result = ListNode.toArray(reversed);
        assertArrayEquals(new int[]{2, 1, 4, 3, 5}, result);
    }

    @Test
    @DisplayName("Should handle k=1 (no reverse)")
    void testReverseK1() {
        ListNode head = ListNode.fromArray(new int[]{1, 2, 3});
        ListNode result = ReverseLinkedList.reverseKGroup(head, 1);
        assertArrayEquals(new int[]{1, 2, 3}, ListNode.toArray(result));
    }

    @Test
    @DisplayName("Should get middle of list")
    void testGetMiddle() {
        ListNode head = ListNode.fromArray(new int[]{1, 2, 3, 4, 5});
        ListNode middle = ReverseLinkedList.getMiddle(head);
        assertEquals(3, middle.val);
    }

    @Test
    @DisplayName("Should work with large list")
    void testLargeList() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        
        ListNode head = ListNode.fromArray(arr);
        ListNode reversed = ReverseLinkedList.reverseIterative(head);
        int[] result = ListNode.toArray(reversed);
        
        assertEquals(100, result.length);
        assertEquals(100, result[0]);
        assertEquals(1, result[99]);
    }
}
