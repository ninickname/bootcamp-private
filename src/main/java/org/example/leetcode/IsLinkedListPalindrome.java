package org.example.leetcode;

public class IsLinkedListPalindrome {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(1));
        boolean palindrome = new IsLinkedListPalindrome().isPalindrome(listNode);
        System.out.println("palindrome : "+ palindrome);

    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head ;
        ListNode fast = head ;

        while(fast!=null && fast.next !=null){
            fast = fast.next.next ;
            slow = slow.next ;
        }
        ListNode revercedHead = reverceLinkedList(slow );

        while (revercedHead!=null){
            if (head.val != revercedHead.val){
                return false ;
            }
            head = head.next ;
            revercedHead = revercedHead.next ;
        }
        return true ;
    }

    ListNode reverceLinkedList(ListNode head ){
        ListNode prev = null;
        ListNode curr = head ;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = prev ;
            prev = curr;
            curr = next ;
        }
        return prev;
    }
}
