package org.example;

import org.example.*;
import org.example.basics.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BFSTest {

    private final BFS bfs = new BFS();

    @Test
    void basicPath() {
        int startPoint = 1 ;
        int endPoint = 3 ;

        List<Pair<Integer, Integer>> paris = new ArrayList<>();

        paris.add( new Pair<>(1,2));
        paris.add( new Pair<>(2,3));
        List<Integer> shortestPath = bfs.findShortestPath(paris, startPoint, endPoint);

        Assertions.assertNotNull(shortestPath );
        Assertions.assertEquals(shortestPath.size(),3 );
        Assertions.assertEquals(shortestPath.get(0) , 1 );
        Assertions.assertEquals(shortestPath.get(1) , 2 );
        Assertions.assertEquals(shortestPath.get(2) , 3 );
    }

}