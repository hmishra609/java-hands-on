package org.example.collections.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemoMinHeap {
    static void main() {
        PriorityQueue<Integer> pq= new PriorityQueue<>();

        pq.add(5);
        pq.add(2);
        pq.add(4);
        pq.add(3);
        pq.add(6);


        System.out.println("PriorityQueue: getting the smallest element" + pq.peek());


    }
}
