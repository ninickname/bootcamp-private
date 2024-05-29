package org.example;

import org.example.basics.*;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class TopologicalSort {
    /*
     * timings
     * 
     * start        : 13:22
     * end pseudo   : 13: 35 - with some random interruptions on watsapp- killed it afterwards . 
     * end coding   : 14 : 10 with some additnal distractions - killing it in the prev line didnt do the trick . 
     * end verifying:
     * submit       :
     * 
     * time complexity estimation : O( E )
     * 
     * space complexity estimation : O( E )
     * 
     * bugs found during verification :
     * 
     * bugs found during submition :
     
     * understading the question \ pseudo :

     so we need to order all the courses.
     to begin we need to find for each course how many courses he depends on 
     then resolve all the courses that dont depend on anything.
     for each course that doesnt depend on anything , add them to list,
      and decrease counter for all the courses that depend on them 

      so if we get as input 
        calc2 depends on calc1 
        
        then we know that we have 2 courses , 
        calc1 - doesnt depend on anything 
        calc1 - has a list of courses that depend on it -> calc2
        calc2 - depends on 1 course .


        so we start from executing calc1 , then all the courses that depend on it ,we decrease the counter, and check if now the counter is 0 also 
        the counter was changed from 1 to 0 , we add it to the list of courses that can be executed.
     */

 //  A is dependant on B  -> calc2 depends on calc1 
    public List<String> getPossibleOrder(List<Pair<String,String>> courses){
        
        Map<String,List<String>> courseToDependats = new HashMap<>(); // so in this map we will contain calc1->[calc2,calc3]
        Map<String , Integer>  courseToDependsOnCounter = new HashMap<>();// and this one will contain calc2-> ( 1 )
        for (Pair<String,String> dep :courses){
            courseToDependats.merge(dep.val2,  new ArrayList<>(Arrays.asList(dep.val)), (l1,l2)->{
                l1.addAll(l2);
                return l1;
            });
            courseToDependsOnCounter.merge(dep.val, 1, Integer::sum);
            courseToDependsOnCounter.merge(dep.val2, 0, Integer::sum);
        }

        //init order 
        List<String> ret = new  ArrayList<>();

        Queue<String> coursesThatCanBeStudied = new LinkedList<>();

        List<String> temp = courseToDependsOnCounter.entrySet().stream().filter((kv)-> kv.getValue() == 0 ).map(Entry::getKey).toList();
        coursesThatCanBeStudied.addAll(temp);
        
        while (!coursesThatCanBeStudied.isEmpty()){
            String curr = coursesThatCanBeStudied.poll();
            ret.add(curr);
            List<String> coursesDependsOnThis = courseToDependats.get(curr);
            if (coursesDependsOnThis == null){
                continue;
            }
            for(String dependant : coursesDependsOnThis){
                courseToDependsOnCounter.put(dependant,courseToDependsOnCounter.get(dependant)-1);
                if (courseToDependsOnCounter.get(dependant) == 0 ){
                    coursesThatCanBeStudied.add(dependant);
                }
            }
        }

        if (courseToDependsOnCounter.size() == ret.size()){
            return ret;
        }
        else {
            return null;
        }
    }

}