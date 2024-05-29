package org.example;

import org.example.basics.*;

import java.util.*;
import java.util.function.Predicate;


public class DFS {

    /*
     * timings
     *
     * start :
     * end pseudo :
     * end coding :
     * end verifying:
     * submit :
     *
     * time complexity estimation : O( )
     *
     * space complexity estimation : O( )
     *
     * bugs found during verification :
     *
     * bugs found during submition :
     *
     * understading the question \ pseudo :
     *
     */

    // ASSUMING THAT WE GET NON CIRCULAR TREE !!!!
    // if the tree is circular we need to also mark nodes as seen and manage that also
    public List<NonBinaryTreeNode<Integer>> findPathToNode(List<Pair<Integer, Integer>> edges, Integer startNode,
                                                           Predicate<Integer> testIsFinalNode) {
        NonBinaryTreeNode<Integer> root = buildTreeFromEdges(edges, startNode);
        List<NonBinaryTreeNode<Integer>> pathFromRootToFinalNode = getPathFromRootToFinalNode(root, testIsFinalNode);
        return pathFromRootToFinalNode;
    }

    public List<NonBinaryTreeNode<Integer>> getPathFromRootToFinalNode(NonBinaryTreeNode<Integer> node,
                                                                       Predicate<Integer> testIsFinalNode) {

        if (testIsFinalNode.test(node.val)) {
            return   new ArrayList<>(List.of(node));
        } else if (node.children == null || node.children.isEmpty()) {
            return null;
        } else {
            for (NonBinaryTreeNode<Integer> child : node.children) {
                List<NonBinaryTreeNode<Integer>> ret = getPathFromRootToFinalNode(child, testIsFinalNode);
                if (ret != null) {
                    ret.add(node);
                    return ret;
                }
            }
        }
        return null;
    }

    public NonBinaryTreeNode<Integer> buildTreeFromEdges(List<Pair<Integer, Integer>> edges, Integer startNode) {
        Map<Integer, NonBinaryTreeNode<Integer>> valToNode = new HashMap<>();
        for (Pair<Integer, Integer> edge : edges) {
            NonBinaryTreeNode<Integer> from = valToNode.computeIfAbsent(edge.val, NonBinaryTreeNode::new);
            NonBinaryTreeNode<Integer> to = valToNode.computeIfAbsent(edge.val2, NonBinaryTreeNode::new);
            from.addToChildren(to);
        }
        return valToNode.get(startNode);
    }
}
