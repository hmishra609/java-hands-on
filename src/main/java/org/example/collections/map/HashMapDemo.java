package org.example.collections.map;

public class HashMapDemo {
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




    }
}
