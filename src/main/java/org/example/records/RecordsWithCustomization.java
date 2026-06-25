package org.example.records;

import java.util.Locale;

public class RecordsWithCustomization {


    public record Person(int id, String name, int salary) {

        public Person {
            if(salary < 1000) {
                throw new IllegalArgumentException("Salary must be greater than 1000");
            }
            name=name.toLowerCase();
        }


    }

    static void main() {

        record Test(int id, String name, int salary) {}
        Person person = new Person(1, "John", 10000);

        Test test=new Test(1, "John", 10000);
        System.out.println(test);
        System.out.println(person);




    }
}
