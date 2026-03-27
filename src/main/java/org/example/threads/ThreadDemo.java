package org.example.threads;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1= new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1: " + i);
            }
        });
        t1.start();

        Thread t2= new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2: " + i);
            }
        });

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();

        System.out.println("Main thread is running...");
        System.out.println("Main thread is running...");
    }

}
