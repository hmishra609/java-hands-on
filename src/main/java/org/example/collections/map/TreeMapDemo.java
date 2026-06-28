package org.example.collections.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    static void main() {
        // 3. TreeMap (The "Alphabetical" Map)
        TreeMap<String, Integer> treeMap = new TreeMap<>((a, b) -> a.compareTo(b) );
        treeMap.put("Z", 1);
        treeMap.put("A", 2);
        treeMap.put("B", 3);
        treeMap.put("X", 4);

        System.out.println("TreeMap (Natural Sorted Order): " + treeMap);
        System.out.println("First entry in TreeMap: " + treeMap.firstEntry().getKey());
        System.out.println("Last entry in TreeMap: " + treeMap.lastEntry().getKey());


        Map<String,Integer> kvMap =treeMap.descendingMap();



        System.out.println("TreeMap (Descending Order) printing using forEach): ");
        kvMap.forEach((k,v)->{
            System.out.println("Key: " + k + ", Value: " + v);
        });
    }
}
