package org.example.leetcode;

public class RemoveDuplicatesfromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        slow.next = null;
        while (fast != null) {
            while (fast != null && fast.val == head.val) {
                fast = fast.next;
            }
            slow.next = fast;
            if (fast != null) {
                head = head.next;
                fast = fast.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(2)));
        deleteDuplicates(listNode);
        System.out.println("aaa");
    }
}
