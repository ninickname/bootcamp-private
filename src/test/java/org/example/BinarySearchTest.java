package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.example.*;
import org.example.basics.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    @Test
    void getIndexUsingBinarySearch() {
        int number = 1;
        int indexUsingBinarySearch = new BinarySearch().getIndexUsingBinarySearch(Arrays.asList(0, 1, 2, 3, 4, 5), number);

        Assertions.assertEquals(indexUsingBinarySearch, number);
    }
}