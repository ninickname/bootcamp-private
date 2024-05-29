package org.example;

import org.example.basics.*;

import java.util.*;

public class BinarySearch {
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

    public int getIndexUsingBinarySearch(List<Integer> orderedList, Integer number) {
        return getIndexUsingBinarySearch(orderedList, number, 0, orderedList.size());
    }

    private int getIndexUsingBinarySearch(List<Integer> orderedList, int number, int startIndex, int endIndex) {
        if (endIndex - startIndex == 0) {
            return number == orderedList.get(startIndex) ? startIndex : -1;
        }

        int pivot = (endIndex - startIndex) / 2 + startIndex;
        if (number == orderedList.get(pivot)) {
            return pivot;
        }
        if (number < orderedList.get(pivot)) {
            return getIndexUsingBinarySearch(orderedList, number, startIndex, pivot);
        } else {
            return getIndexUsingBinarySearch(orderedList, number, pivot+1 , endIndex);
        }
    }
}