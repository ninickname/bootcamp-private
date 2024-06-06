package org.example.basics;

public class Node<T> {
    public T val;
    public Node<T> next;

    public Node(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + (next == null ? "null" : next.val) +
                '}';
    }

    public String toStringFull() {
        return val + "->" + (next == null ? null : next.toStringFull());
    }
}
