package org.example.basics;

import java.util.List;

public class Utils {

    public static <T> Node<T> createLinkedListFromArray(List<T> nodes) {
        Node<T> ret = new Node<>(null);
        Node<T> curr = ret;
        for (T node : nodes) {
            curr.next = new Node<>(node);
            curr = curr.next;
        }
        return ret.next;
    }
}
