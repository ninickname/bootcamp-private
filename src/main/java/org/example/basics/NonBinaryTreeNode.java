package org.example.basics;

import java.util.ArrayList;
import java.util.List;

public class NonBinaryTreeNode<T> {
    public T val;
    public List<NonBinaryTreeNode<T>> children;
    
    
    public NonBinaryTreeNode(T val){
        this.val = val;
        this.children = new ArrayList<>();
    }

    public void addToChildren(NonBinaryTreeNode<T> val){
        children.add(val);
    }
}