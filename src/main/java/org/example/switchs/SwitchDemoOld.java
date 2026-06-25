package org.example.switchs;

public class SwitchDemoOld {
    static void main() {
        String User=null;


        switch(User){
            case "Mayank":
                System.out.println("Mayank");
                break;
            case "Ram":
                System.out.println("Ram");
                break;
            case null:
                System.out.println("Null");
                break;
            default:
                System.out.println("Default");
                break;
        }
    }
}
