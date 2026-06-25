package org.example.switchs;

public class SwitchDemoNew {
    static void main() {
        String User=null;


        String test=switch(User){
            case "Mayank" ->{
                System.out.println("Mayank");
                yield "Mayank";
            }


            case "Ram" -> {
                System.out.println("Ram");
                yield "Mayank";


            }
            case null ->{
                System.out.println("Null");
                yield "Mayank";
            }

            default ->{
                System.out.println("Default");
                yield "Mayank";
            }

        };
        System.out.println(test);
    }
}
