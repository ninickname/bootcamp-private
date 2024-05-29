package org.example;

import org.example.basics.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TopologicalSortTest {
    TopologicalSort tps = new TopologicalSort();
    @Test
    void getPossibleOrder() {
        String linearAlgebra = "linearAlgebra";

        List<Pair<String, String>> courses = new ArrayList<>();
        courses.add(new Pair<>("calc2","calc1"));
        courses.add(new Pair<>("calc3","calc2"));
        courses.add(new Pair<>("calc3","calc1"));
        courses.add(new Pair<>("calc1" , linearAlgebra));


        List<String> possibleOrder = tps.getPossibleOrder(courses);
        assertNotNull(possibleOrder);
        assertEquals(possibleOrder.get(0), linearAlgebra);
    }
}