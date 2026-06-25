package org.example.collections.map;

import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
            // 1. HashMap (The "Jumbled" Map)
            java.util.Map<String, Integer> hashMap = new java.util.HashMap<>();
            hashMap.put("Z", 1); hashMap.put("A", 2); hashMap.put("B", 3); hashMap.put("X", 4);
        System.out.println("================================Hashmap====================================");
            System.out.println("HashMap (Unpredictable): " + hashMap);

            if(hashMap.containsKey("Z")){
                System.out.println("Value for key 'Z': " + hashMap.get("Z"));
            } else {
                System.out.println("Key 'Z' not found in HashMap.");
            }

            // 2. LinkedHashMap (The "First-Come-First-Served" Map)
            java.util.Map<String, Integer> linkedHashMap = new java.util.LinkedHashMap<>();
            linkedHashMap.put("Z", 1); linkedHashMap.put("A", 2); linkedHashMap.put("B", 3); linkedHashMap.put("X", 4);
        System.out.println("================================LinkedHashMap====================================");
            System.out.println("LinkedHashMap (Insertion Order): " + linkedHashMap);


            // 3. TreeMap (The "Alphabetical" Map)
            java.util.TreeMap<String, Integer> treeMap = new java.util.TreeMap<>((a, b) -> a.compareTo(b) );
            treeMap.put("Z", 1); treeMap.put("A", 2); treeMap.put("B", 3); treeMap.put("X", 4);
        System.out.println("================================TreeMap====================================");
            System.out.println("TreeMap (Natural Sorted Order): " + treeMap);
            java.util.Map <String,Integer> kvMap =treeMap.descendingMap();

        System.out.println("First entry in TreeMap: " + treeMap.firstEntry().getKey());


        System.out.println("TreeMap (Descending Order) printing using forEach): ");
            kvMap.forEach((k,v)->{
                System.out.println("Key: " + k + ", Value: " + v);
            });
    }
}
