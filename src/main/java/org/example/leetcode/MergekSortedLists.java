package org.example.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = new ListNode(2, new ListNode(6));
        ListNode listNode1 = new MergekSortedLists().mergeKLists(new ListNode[]{listNode, listNode2, listNode3});
        System.out.println("aaa");
    }

        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> q = new PriorityQueue<>( (t,o)->Integer.compare(t.val,o.val));
            for (int i = 0; i < lists.length; i++) {
                if(lists[i]!=null){
                    q.add(lists[i]);
                }
            }
            ListNode ret = new ListNode();
            ListNode curr = ret;
            while(!q.isEmpty()){
                ListNode temp = q.poll();
                curr.next = temp;
                temp = temp.next ;
                curr = curr.next;

                if (temp!=null){
                    q.add(temp);
                }
            }
            return ret.next;
        }

}
