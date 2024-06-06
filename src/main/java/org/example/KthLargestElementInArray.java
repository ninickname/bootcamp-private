package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthLargestElementInArray {
    /**
     * in order to find the k largetst elemnt we are gonna do the following.
     * pick a pivot - for ease lets take the first elemnt as a pivot
     * saparate the aray into 2 arrays  (smallerArr , biggerArr), and a pivotCounter .
     * go over the array, saparate all things smaller than the value to the smaller array , the bigger into bigger, and each time the same value as the pivot appears, add it to the counter .
     * after devision as such , check for sizes of k
     * if smallerArr bigger than k , then the answer lies within smallerArr , and we shuold shrink the problem into looking for the kth element there
     * if smallerArr + pivotCounter bigger than k , the PIVOT is the number we are seeking for
     * else , we shuold look into (k-pivotCounter- smallerArr size) newKth-largest element in the second array.
     */

    public static void main(String[] args) {
        int[] input = new int[100];
//        List<Integer> testArray = Arrays.asList(11, 2, 7, 4, 5, 6, 3, 8, 9, 10, 1);
        Arrays.fill(input, 0, 99, 1);
        Arrays.setAll(input, i -> i % 50);
        List<Integer> testArray2 = Arrays.stream(input).boxed().toList();
        int testK = 2;

        int kLargestElementInArray = findKLargestElementInArray(testArray2, testK);
        System.out.println(kLargestElementInArray);
    }

    static int findKLargestElementInArray(List<Integer> arr, int k) {
        List<Integer> smallerArr = new ArrayList<>();
        List<Integer> biggerArr = new ArrayList<>();
        int pivot = arr.get(0);
        int pivotCounter = 0;

        for (int curr : arr) {
            if (pivot > curr) {
                biggerArr.add(curr);
            } else if (pivot < curr) {
                smallerArr.add(curr);
            } else {
                pivotCounter++;
            }
        }
        if (smallerArr.size() > k) {
            return findKLargestElementInArray(smallerArr, k);
        } else if (smallerArr.size() + pivotCounter > k) {
            return pivot;
        } else {
            return findKLargestElementInArray(biggerArr, k - pivotCounter - smallerArr.size());
        }
    }
}
