package datatypes.impl;

import datatypes.Queue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @Test
    public void shouldInsertAllEntries() {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        Random random = new Random();
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            int nextInt = random.nextInt();
            priorityQueue.add(nextInt);
            if (nextInt < minimum)
                minimum = nextInt;
        }
        assertEquals(minimum, priorityQueue.peek());
        List<Integer> list=new ArrayList<>();
        List<Integer> sorted=new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            Integer poll = priorityQueue.poll();
            list.add(poll);
            sorted.add(poll);
        }
        sorted.sort(Comparator.naturalOrder());
        assertIterableEquals(sorted,list);

    }

}