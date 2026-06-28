package org.example.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMapDemo {
    static void main() {
        // 2. LinkedHashMap (The "First-Come-First-Served" Map)
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String,Integer>(20,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> map){
                return size() > 4;
            }
        };
        linkedHashMap.put("Z", 1);
        linkedHashMap.put("A", 2);
        linkedHashMap.put("B", 3);
        linkedHashMap.put("X", 4);

        System.out.println("LinkedHashMap: " + linkedHashMap);


        linkedHashMap.get("A");

        System.out.println("LinkedHashMap after accessing 'A': " + linkedHashMap);
        linkedHashMap.get("B");

        System.out.println("LinkedHashMap after accessing 'B': " + linkedHashMap);
        linkedHashMap.get("X");
        System.out.println("LinkedHashMap after accessing 'X': " + linkedHashMap);
        linkedHashMap.put("Y", 5);

        System.out.println("LinkedHashMap after adding Y as size exceeded so lru removal of Z: " + linkedHashMap);




    }
}
