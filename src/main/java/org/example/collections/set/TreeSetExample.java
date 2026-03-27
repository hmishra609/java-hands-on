package org.example.collections.set;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {

        // 3. TreeSet (The "Alphabetical" Set)
        TreeSet<String> tree = new TreeSet<>((a, b) -> Integer.compare(a.length(),b.length())); // Custom Comparator: Sort by String Length (Reverse)

        tree.add("a");
        tree.add("bb");
        tree.add("ccc");
        tree.add("dddd");

        java.util.NavigableSet<String> descendingSet =tree.descendingSet();
        System.out.println("TreeSet (Natural Sorted Order): " + tree);
        System.out.println("TreeSet (Descending Order): " + descendingSet);
        System.out.println("higher - > "+tree.higher("bb"));
        System.out.println("ceiling -> "+tree.ceiling("ccc"));
        System.out.println("first -> "+tree.first());

        System.out.println("subset from ddd to bb -> "+tree.subSet("bb", true, "dddd", true));



    }
}