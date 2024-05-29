package org.example;

import org.example.basics.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;



public class BFS {
    /*
     * timings
     * 
     * start : 14:50
     * end pseudo : 14:58
     * end coding : 15:57 -> TONS of distractions, couldnt really focus , some env issues 
     * end verifying :
     * submit :
     * 
     * pesudo code :
     * 
     * time complexity estimation : O( n )// amount of edges 
     * 
     * space complexity estimation : O( n )
     * 
     * bugs found during verification :
     * 
     * bugs found during submition :
     */

    /*
     * understading the question
     * given list of mappings<Node,Node> , start node , end node ;
     * stage 1 
     * build tree:
     * node -> list of nodes its connected to
     * 
     * check if s and t are in graph , if no return null.
     * 
     * stage 2
     * create another map, this map will inidcate where we came from , to find the
     * backtrace , and will also mark that this node is visited .
     * start from s; add it to the map , with value null
     * 
     * traverse all the children of s , add them to the map with value s.
     * thaverse their childer, until T is found or mo more children availalbe ,
     * stage 3 
     * if t is found , then , print back all the route it took to get there
     * if there are no childen left and t was not seen , then there is no path.
     */



    public List<Integer> findShortestPath(List<Pair<Integer, Integer>> pairs, int startPoint, int endPoint) {
        Map<Integer,List<Integer>>  nodesToChildren = new HashMap<>();
        //stage1 
        for (Pair<Integer, Integer> p : pairs) {
            nodesToChildren.merge(p.val, new ArrayList<>( Arrays.asList(p.val2)), (arr1,arr2)->{ arr2.addAll(arr1); return arr2;});
        }
        if (nodesToChildren.get(startPoint) == null ){
            return null;
        }

        //stage 2 
        Map<Integer,Integer> nodeToParent = new HashMap<>();
        
        nodeToParent.put(startPoint, null);

        Queue<Integer> childenToBeTraversed = new LinkedList<>();
        childenToBeTraversed.add(startPoint);

        boolean endPointFound = false;
        while(!childenToBeTraversed.isEmpty()  ){
            Integer curr = childenToBeTraversed.poll();
            if (nodeToParent.get(curr) == null && curr!=startPoint){
                continue;
            }
            List<Integer> currChildren = nodesToChildren.get(curr);
            for(Integer child : currChildren){
                if(nodeToParent.get(child) == null){
                    nodeToParent.put(child, curr);
                    childenToBeTraversed.add(child);      
                    if(endPoint == child){
                        endPointFound = true;
                        break;
                    }  
                }    
            } 
            if(endPointFound){                
                break;
            }           
        }

        //stage 3 
        if (!endPointFound){
            return null;
        }

        List<Integer> path = new ArrayList<>();
        Integer curr = endPoint;
        while (curr!=null){
            path.add(curr);
            curr=nodeToParent.get(curr);
        }

        return path.reversed();
    }
}