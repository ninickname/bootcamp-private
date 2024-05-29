package org.example;

import org.example.basics.*;

public class ValidateBST {
    /*
     * timings
     * 
     * start        : 
     * end pseudo   :
     * end coding   :
     * end verifying:
     * submit       :
     * 
     * time complexity estimation : O(  )
     * 
     * space complexity estimation : O(  )
     * 
     * bugs found during verification :
     * 
     * bugs found during submition :
     
     * understading the question \ pseudo :
     
     */

    public boolean isBST (TreeNode<Integer> root){
        return isBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
    } 

    private boolean isBST (TreeNode<Integer> root , int minRange, int maxRange ){
        if (root == null){
            return true;
        }
        if (root.val >= maxRange || root.val<=minRange  ){
            return false;
        }
        return isBST(root.left , minRange , root.val) && isBST(root.right , root.val , maxRange);
    }
}