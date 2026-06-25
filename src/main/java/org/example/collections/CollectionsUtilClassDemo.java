package org.example.collections;

import java.util.*;

public class CollectionsUtilClassDemo {
    static void main() {
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6,7,8));
        int index = Collections.binarySearch(list, 5);
        System.out.println("Index of 5: " + index);

        TreeMap<Integer, String> integerStringMap = new TreeMap<>(Map.of(1, "One", 2, "Two", 3, "Three"));
        integerStringMap.floorEntry(2);

        NavigableMap<Integer, String> synchronizedMap = Collections.synchronizedNavigableMap(new TreeMap<>(integerStringMap));
        java.lang.String value =synchronizedMap.floorEntry(2).getValue();
        System.out.println("Value of floorEntry for key 2: " + value);




    }
}
