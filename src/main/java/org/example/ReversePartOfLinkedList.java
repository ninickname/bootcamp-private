package org.example;

import org.example.basics.Node;
import org.example.basics.Pair;
import org.example.basics.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversePartOfLinkedList {
/*
    // we want to devide the list to 3 sublists
    // head
    // the part to be swapped
    // the tail
   each part can be empty , so this needs to be taken into account.

   init newHead.
   assain to the new Head as next the content of the head if exists .
   iterate over the list unil the first element is found
   save it aside .
   iterate over all the chunk that shuold be reverced
   and each time assaign the current next to be the prevoius current
   until you get to the last node.
   the last nodes next shuold be the begining of the tail.
   assign the last node next to be the current as we did before , and assagn it as the next of the end of the head .
   return the new head
 */


    public static void main(String[] args) {
        try {
//            Node<Integer> linkedListFromArray = Utils.createLinkedListFromArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            Node<Integer> linkedListFromArray = Utils.createLinkedListFromArray(Arrays.asList(1, 2,3,4,5));
            System.out.println("before swap");
            System.out.println(linkedListFromArray.toStringFull());

            List<Pair<Integer,Integer>> inputs = new ArrayList<>();
//            inputs.add( new Pair<>(0,1));
//            inputs.add( new Pair<>(2,100));
//            inputs.add( new Pair<>(1,2));
//            inputs.add( new Pair<>(0,10));
            inputs.add( new Pair<>(1,5));


            for (Pair<Integer, Integer> input : inputs) {
                try {
                    Integer fromIndex = input.val;
                    Integer toIndex = input.val2;
                    System.out.println("input: start - " + fromIndex + " , end - " + toIndex);
                    Node<Integer> integerNode = new ReversePartOfLinkedList().reversePartOfLinkedList(linkedListFromArray, fromIndex, toIndex);
                    System.out.println(integerNode.toStringFull());
                }catch (Exception e ){
                    System.out.println(" program failed with the following exception" + e.getMessage() );
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("WTF");
        }
        System.out.println("done");
    }

    Node<Integer> reversePartOfLinkedList(Node<Integer> head, int from, int to) {
        Node<Integer> newHead = new Node<>(null);
        Node<Integer> curr = newHead;
        newHead.next = head;
        if (from > 1) {
            for (int i = 1; i < from ; i++) {
                curr = curr.next;
            }
        }
        // here we got to the node where we want to begin the swaps from
        Node<Integer> lastNodeBeforeReplace = curr;
        //just extract the tail
        Node<Integer> startOfSeqene = curr.next;
        for (int i = 0; i < to - from; i++) {
            curr = curr.next;
        }
        Node<Integer> endOfSequence = curr == null ? null:curr.next;
        Node<Integer> beginingOfTheTail = endOfSequence == null ? null: endOfSequence.next;


        reverseInPlace(startOfSeqene, endOfSequence);

        lastNodeBeforeReplace.next = endOfSequence;
        startOfSeqene.next = beginingOfTheTail;

        return newHead.next;
    }

    void reverseInPlace(Node<Integer> startNode, Node<Integer> endNode) {
        Node<Integer> curr = startNode;
        Node<Integer> temp = startNode.next;
        startNode.next = null;
        while (curr != endNode) {
            curr = temp;
            temp = temp.next;
            curr.next = startNode;
            startNode = curr;
        }
    }
}