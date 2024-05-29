package org.example;

import org.example.basics.NonBinaryTreeNode;
import org.example.basics.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class DFSTest {

    DFS  dfs = new DFS();


    @Test
    void findPathToNode() {
        Integer startNode = 1 ;
        Predicate<Integer> test = endNode->endNode==3;

        List<Pair<Integer, Integer>> edges = new ArrayList<>();
        edges.add( new Pair<>(1,2));
        edges.add( new Pair<>(2,3));
        edges.add( new Pair<>(2,4));

        List<NonBinaryTreeNode<Integer>> pathToNode = dfs.findPathToNode(edges, startNode, test);
        Assertions.assertNotNull(pathToNode);
        Assertions.assertEquals(pathToNode.size() ,3);

    }
    @Test
    void getPathFromRootToFinalNode(){


    }

    @Test
    void buildTreeFromEdges() {
    }
}