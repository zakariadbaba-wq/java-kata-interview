package com.kata.linkedlist;

/**
 * ListNode: Singly Linked List Node
 * 
 * Generic linked list node for use in linked list operations.
 * Each node contains data and a reference to the next node.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    /**
     * Create a linked list from an array
     */
    public static ListNode fromArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    /**
     * Convert linked list to array for testing
     */
    public static int[] toArray(ListNode head) {
        java.util.List<Integer> values = new java.util.ArrayList<>();
        ListNode current = head;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        int[] result = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            result[i] = values.get(i);
        }

        return result;
    }

    /**
     * Get length of linked list
     */
    public static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }

    /**
     * Print linked list (for debugging)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;

        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.toString();
    }

    /**
     * Check equality of two linked lists
     */
    public static boolean equals(ListNode head1, ListNode head2) {
        ListNode current1 = head1;
        ListNode current2 = head2;

        while (current1 != null && current2 != null) {
            if (current1.val != current2.val) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return current1 == null && current2 == null;
    }
}
