package org.example.records;

public class RecordDemo {

    public record Employee(int id, String name, int age, int salary) {}


    static void main() {
        Employee emp1 = new Employee(1, "Alice", 30, 50000);
        Employee emp2 = new Employee(2, "Bob", 25, 45000);

        System.out.println(emp1);
        System.out.println(emp2);

        // Accessing components
        System.out.println("Employee 1 Name: " + emp1.name());
        System.out.println("Employee 2 Salary: " + emp2.salary());
    }


}
