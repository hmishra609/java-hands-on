package org.example.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamHandson {
    public static void main(String[] args) {
//        List<String> names= Arrays.asList("Alice","bob","charlie");
//
//        Stream<String> stream = names.stream();
//
//        String [] arr=  {"Alice","bob","charlie"};
//        Stream<String> stringStream =Arrays.stream(arr);
//        java.util.stream.Stream<Integer> integerStream =Stream.of(1,2,3);
//
//        Stream<Double> doubleStream=Stream.generate(Math::random).limit(10);


        List<Integer> integerList =Arrays.asList(1, 2, 3,4,5,6,7,8,9,10,19, 11, 12, 13, 14,14);
//        List<Integer> evens=integerList.stream().filter(n -> n%2!=0).toList();
//        System.out.println(evens);


//        java.util.List<Integer> squares =integerList.stream().filter(n -> n%2==0)
//                                                              .map(b -> b*b).toList();
//          System.out.println(squares);


//
//       java.util.Optional<Integer> first =integerList.stream().filter(n-> n > 10).sorted().findFirst();
//
//        System.out.println(first.orElse(0));

//        long count=integerList.stream().filter(n-> n> 5).count();

//        java.lang.Integer sum =integerList.stream().reduce(0,(a, b)-> a+b);
//        System.out.println(sum);

//        System.out.println(integerList.stream().filter(n -> n%2==0).reduce(0,Integer::sum));

//        java.lang.Integer max =integerList.stream().reduce(0,(a, b) -> Integer.max(a,b));
//        System.out.println(max);

//        java.lang.Integer reduce =integerList.stream().filter(a -> a % 2==0)
//                .map(b -> b*b)
//                .reduce(0, Integer::sum);
//        System.out.println(reduce);

//         integerList.stream().distinct().forEach(System.out::println);
//        double v=integerList.stream().mapToInt(Integer::intValue).average().orElse(0.0);
//        System.out.println(v);

//        integerList.stream()
//                .distinct()
//                .sorted(Comparator.reverseOrder()).forEach(System.out::println);


        List<String> stringList = Arrays.asList("ffv","rfffr","rgverge","grrgrwgga","a");
//        stringList.stream().sorted((a,b) -> a.length()-b.length()).forEach(System.out::println);

//        System.out.println(stringList.stream().filter(s -> s.startsWith("r")).toList().size());

//        System.out.println(stringList.stream().collect(Collectors.joining(",")));
//        System.out.println(stringList.stream().collect(Collectors.joining(",","{","}")));

//          boolean ispositive =integerList.stream().allMatch(n -> n > 0);
//        System.out.println(ispositive);

//        System.out.println(integerList.stream().anyMatch(n -> n%3==0));

        //List of list of integer
//        List<List<Integer>> listOfLists = Arrays.asList(
//                Arrays.asList(1, 2, 3),
//                Arrays.asList(4, 5),
//                Arrays.asList(6, 7, 8, 9)
//        );
//
//        listOfLists.stream().flatMap(List::stream).forEach(System.out::println);
//
//        listOfLists.forEach(System.out::println);


//        List<String> stringList1 = Arrays.asList("","","ffv","rfffr","rgverge","grrgrwgga","a");
//        stringList1.stream().filter(s -> !s.isEmpty()).findFirst().ifPresent(System.out::println);

//        integerList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);

////            List of employee objects
//        List<Employee> employees = Arrays.asList(
//                new Employee("Alice", 30, "10000"),
//                new Employee("Bob", 25, "1000"),
//                new Employee("Charlie", 35, "100"),
//                new Employee("David", 28, "500")
//        );
//
////        employees.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);
//
//        employees.stream().map(Employee::getAge).mapToInt(Integer::intValue).average().ifPresent(System.out::println);

//            java.util.Map<Boolean, List<Integer>>  listMap=integerList.stream().collect(Collectors.partitioningBy(n-> n%2==0 ));
//            List<Integer> even=listMap.get(true);
//            List<Integer> odd=listMap.get(false);
//            even.forEach(System.out::println);
//            odd.forEach(System.out::println);

//        stringList.stream().collect(Collectors.groupingBy(b -> b.startsWith("r"))).keySet().stream().forEach(System.out::println);
//        stringList.stream().collect(Collectors.groupingBy(b -> b.length())).keySet().stream().forEach(System.out::println);

        List<String> strings = Arrays.asList("Apple", "Apple","Banana", "Banana","Cat");
        java.util.Map<String, Long> countmap=strings.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(countmap);

    }
}
