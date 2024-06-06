package org.example.leetcode;

class MyLinkedList {


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        myLinkedList.get(1);              // return 2
        myLinkedList.deleteAtIndex(3);    // now the linked list is 1->3
        myLinkedList.get(1);              // return 3
    }
    ListNode preHead;

    public MyLinkedList() {
        preHead = new ListNode();
    }

    public int get(int index) {
        ListNode curr = preHead.next ;

        for (int i = 0 ; i < index  && curr!=null; i++){
            curr=curr.next;
        }
        return curr == null?-1:curr.val;
    }

    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val , preHead.next);
        preHead.next = newHead;
    }

    public void addAtTail(int val) {
        ListNode prev = preHead ;
        ListNode curr = prev.next;
        while(curr!=null){
            curr = curr.next ;
            prev = prev.next ;
            if (curr== null || prev == null){
                return ;
            }
        }
        ListNode newPostPrev = new ListNode(val, prev.next);
        prev.next  = newPostPrev;
    }

    public void addAtIndex(int index, int val) {
        ListNode prev = preHead ;
        ListNode curr = prev.next;
        for (int i = 0 ; i < index ; i++){
            curr = curr.next ;
            prev = prev.next ;
//            if (curr== null || prev == null){
//                return ;
//            }
        }
        ListNode newPostPrev = new ListNode(val, prev.next);
        prev.next  = newPostPrev;
    }

    public void deleteAtIndex(int index) {
        ListNode prev = preHead ;
        ListNode curr = prev.next;
        for (int i = 0 ; i < index ; i++){
            curr = curr.next ;
            prev = prev.next ;
            if (curr== null || prev == null){
                return ;
            }
        }
        prev.next  = prev.next.next;
    }
}