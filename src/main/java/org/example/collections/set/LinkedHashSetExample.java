package org.example.collections.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
    public static void main(String[] args) {

        // 2. LinkedHashSet (The "First-Come-First-Served" Set)
        Set<String> linked = new LinkedHashSet<>();
        linked.add("Z"); linked.add("A"); linked.add("B"); linked.add("X");
        System.out.println("LinkedHashSet (Insertion Order): " + linked);




    }
}