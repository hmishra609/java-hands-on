package org.example.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    static void main() {
        // 2. LinkedHashMap (The "First-Come-First-Served" Map)
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Z", 1);
        linkedHashMap.put("A", 2);
        linkedHashMap.put("B", 3);
        linkedHashMap.put("X", 4);
        System.out.println("LinkedHashMap (Insertion Order): " + linkedHashMap);

    }
}
