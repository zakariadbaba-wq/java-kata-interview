package com.kata.linkedlist;

/**
 * Kata 10: Reverse a Singly Linked List
 * 
 * Problem: Reverse a singly linked list in-place.
 * Given the head of a linked list, reverse it and return the new head.
 * 
 * Example:
 *   Input: 1 -> 2 -> 3 -> 4 -> null
 *   Output: 4 -> 3 -> 2 -> 1 -> null
 * 
 * Difficulty: ⭐⭐ Medium
 * Time Complexity: O(n)
 * Space Complexity: O(1) for iterative, O(n) for recursive
 */
public class ReverseLinkedList {

    /**
     * Iterative Solution: Three-pointer approach
     * Most efficient and commonly used in interviews
     * O(n) time, O(1) space
     */
    public static ListNode reverseIterative(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            // Store next node
            next = current.next;

            // Reverse the link
            current.next = prev;

            // Move pointers forward
            prev = current;
            current = next;
        }

        return prev; // New head
    }

    /**
     * Recursive Solution
     * O(n) time, O(n) space (call stack)
     * More elegant but uses stack memory
     */
    public static ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        ListNode newHead = reverseRecursive(head.next);

        // Put the first element at the end
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * Recursive Solution with helper
     * Alternative recursive approach
     */
    public static ListNode reverseRecursiveHelper(ListNode head) {
        return reverseRecursiveHelperUtil(head, null);
    }

    private static ListNode reverseRecursiveHelperUtil(ListNode current, ListNode prev) {
        if (current == null) {
            return prev;
        }

        ListNode next = current.next;
        current.next = prev;

        return reverseRecursiveHelperUtil(next, current);
    }

    /**
     * Reverse a portion of linked list (between indices left and right)
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevLeft = dummy;

        // Find the node before 'left'
        for (int i = 0; i < left - 1; i++) {
            prevLeft = prevLeft.next;
        }

        ListNode current = prevLeft.next;

        // Reverse the sublist
        for (int i = 0; i < right - left; i++) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = prevLeft.next;
            prevLeft.next = next;
        }

        return dummy.next;
    }

    /**
     * Reverse every k group in linked list
     * Groups of k nodes are reversed
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        // Check if there are at least k nodes
        ListNode current = head;
        for (int i = 0; i < k; i++) {
            if (current == null) {
                return head;
            }
            current = current.next;
        }

        // Reverse first k nodes
        ListNode prev = null;
        current = head;

        for (int i = 0; i < k; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Recursively reverse remaining groups
        head.next = reverseKGroup(current, k);

        return prev;
    }

    /**
     * Get the middle of a linked list (useful for other problems)
     */
    public static ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
