package org.example.collections.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class QueueDemo {
    public static void main(String[] args) {

        // we are using Deque as a Queue, because Queue interface does not have methods to add/remove from both ends, but Deque does.
        Deque<String> queue = new ArrayDeque<>();
        // adding to the end of the queue
        queue.offer("a");
        // a
        queue.offer("b");
        // a,b
        queue.offer("c");
        // a,b,c

        System.out.println("Queue (FIFO): " + queue);

        queue.offer("d");
        // a,b,c,d

        System.out.println("Queue after adding 'd': " + queue);

        // removing from the front of the queue
        String removed = queue.poll();
        System.out.println("Removed from queue: " + removed);
        System.out.println("Queue after removing: " + queue);
        // b,c,d
    }
}
