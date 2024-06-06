package org.example.leetcode;

import java.util.List;

public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reverseBetween(listNode, 1, 5);
        System.out.println("aaa");
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode();
        ListNode curr = newHead;
        newHead.next = head;
        if (left > 1) {
            for (int i = 1; i < left; i++) {
                curr = curr.next;
            }
        }
        ListNode lastBeforeReplace = curr;
        ListNode startOfEndSequence = curr.next;
        for (int i = 0; i < right - left; ++i) {
            curr = curr.next;
        }

        ListNode endOfTheSeqeusnce = curr == null ? null : curr.next;
        ListNode beginingOfTheTail = endOfTheSeqeusnce == null ? null : endOfTheSeqeusnce.next;
        reverseInPLace(startOfEndSequence, endOfTheSeqeusnce);

        lastBeforeReplace.next = endOfTheSeqeusnce;
        startOfEndSequence.next = beginingOfTheTail;
        return newHead.next;
    }


    private static void reverseInPLace(ListNode startNode, ListNode endNode) {
        ListNode curr = startNode;
        ListNode nextNode = startNode.next;
        startNode.next = null;
        while (curr != endNode) {
            curr = nextNode;
            nextNode = nextNode.next;
            curr.next = startNode;
            startNode = curr;
        }
    }


}
