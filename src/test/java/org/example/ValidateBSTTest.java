package org.example;

import org.example.basics.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateBSTTest {
    ValidateBST validateBST = new ValidateBST();
    @Test
    void isBST() {
        TreeNode<Integer> leftSubTree = new TreeNode<>(5,new TreeNode<>(4),new TreeNode<>(6));
        assertTrue( validateBST.isBST(leftSubTree));

        TreeNode<Integer> rightSubTree = new TreeNode<>(9,new TreeNode<>(8),null);
        assertTrue( validateBST.isBST(rightSubTree));

        TreeNode<Integer> node = new TreeNode<>(7,leftSubTree,rightSubTree);

        assertTrue( validateBST.isBST(node));
        rightSubTree.left.val=700;

        assertFalse( validateBST.isBST(node));
    }
}