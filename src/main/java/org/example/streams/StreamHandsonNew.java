package org.example.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamHandsonNew {
    void main(){
        List<String> list = List.of("apple", "banana", "cherry");
        java.util.List<String> upperCaseList = list.stream().map((t) -> t.toUpperCase()).collect(Collectors.toList());

//        upperCaseList.forEach(System.out::println);

        String [] strings= {"apple","banana","cherry"};
//        Arrays.stream(strings).map(String::toUpperCase).forEach(System.out::println);
//
//        Stream.of("apple","banana","cherry").map(String::toUpperCase).forEach(System.out::println);
//
//        Stream<Integer> integerStream=Stream.iterate(0, n-> n+200).limit(20);
//
//        integerStream.forEach(System.out::println);

//        Stream.of(1,1,2,2,3).distinct().forEach(System.out::println);
//        Stream.of(9,8,7,2,5,8).sorted(Comparator.reverseOrder()).forEach(System.out::print);
//
//        Stream.of(1,1,5,4,3).limit(2).forEach(System.out::println);
//        Stream.of(1,1,5,4,3).skip(2).forEach(System.out::print);
//
        java.util.List<List<String>> lists=List.of(List.of("A", "B"), List.of("C", "D"));

//        lists.stream().flatMap(t-> t.stream()).forEach(System.out::println);

//        Stream.of("apple", "banana", "cherry").peek( t -> System.out.println("Processing: " + t)).map(String::toUpperCase).forEach(System.out::println);

//        Stream.of(1,2,3,4).takeWhile(n -> n< 3).collect(Collectors.toList()).forEach(System.out::println);
//        Stream.of(11,9,2,11).dropWhile(n -> n > 3).collect(Collectors.toList()).forEach(System.out::println);

//        boolean b= Stream.of("apple","banana","cherry").anyMatch(s-> s.equals("apple"));
//        System.out.println(b);
//        boolean b1= Stream.of("apple","banana","cherry").allMatch(s-> s.length() >= 5);
//        System.out.println(b1);
//        boolean b12= Stream.of("apple","banana","cherry").noneMatch(s-> s.length() < 5);
//        System.out.println(b12);

//        java.lang.Integer integer =Stream.of(1,2,7,5,23,2).reduce(0, (a, b)-> a+b).intValue();
//        System.out.println(integer);

//        Stream.of(1,2,7,5,23,2).max(Integer::compareTo).stream().forEach(System.out::println);


//        Stream.of(1,2,7,5,23,2).collect(Collectors.toList()).forEach(System.out::println);
//        String string= Stream.of("apple","banana","cherry").collect(Collectors.joining(", ")).toString();
//        System.out.println(string);


        List<String> pets = List.of("Dog", "Cat", "Bird", "Ant");

// Grouping by the length of the word
// Output: {3=[Dog, Cat, Ant], 4=[Bird]}

//        java.util.Map<Integer, String> collect=pets.stream().collect(Collectors.groupingBy(String::length,Collectors.joining(", ")));
//
//        collect.forEach((k,v)->{
//            System.out.println(k);
//            System.out.println(v);
//        });

//        java.util.Map<Integer, List<String>> stringStringMap=pets.stream().collect(Collectors.groupingBy(String::length),Collectors.joining(", "));
//        System.out.println(stringStringMap);
//        System.out.println(collect);

        record Employee(int salary, String name, String dept){};

        Employee emp1 = new Employee(100, "Alice", "HR");
        Employee emp2 = new Employee(2250, "Bob", "IT");
        Employee emp3 = new Employee(3000, "John", "IT");
        List<Employee> employees = List.of(emp1, emp2, emp3);
//
//        java.util.Map<String, List<Employee>> employeeMap = employees.stream().collect(Collectors.groupingBy(Employee::dept));
//        java.util.Map<String, Optional<Employee>> employeeMapmaxemp = employees.stream().collect(
//                Collectors.groupingBy(
//                        Employee::dept,
//                        Collectors.maxBy(Comparator.comparingInt(Employee::salary))
//                )
//        );
//
//        System.out.println(employeeMap);
//
//        System.out.println(employeeMapmaxemp);
//
//        java.util.Map<String,Integer> collectedSum=employees.stream().collect(Collectors.groupingBy(Employee::dept,Collectors.summingInt(Employee::salary))
//
//        );
//
//        System.out.println(collectedSum);
//
//        java.util.Map<String,Double> averageSalaries =employees.stream().collect(Collectors.groupingBy(Employee::dept,Collectors.averagingInt(Employee::salary)));
//
//        System.out.println(averageSalaries);
//
//
//        IntStream.range(1, 10).sum();

// Creating a list of 1,000,000 numbers
//        List<Integer> massiveList = IntStream.rangeClosed(1, 1000000).boxed().toList();

// Doing heavy CPU math across all CPU cores
//        long primeCount = massiveList.parallelStream()
//                .filter(Math::isPrime) // Expensive CPU task
//                .count();

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        stream.forEach(System.out::println);

        // ❌ ERROR: Stream already consumed!
        stream.forEach(System.out::println);








    }
}
