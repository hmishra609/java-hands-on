package org.example.collections.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackDemo {

    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println("Stack (LIFO): " + stack);
        String popped = stack.pop();
        System.out.println("Popped from stack: " + popped);
        System.out.println("Stack after popping: " + stack);
    }
}
