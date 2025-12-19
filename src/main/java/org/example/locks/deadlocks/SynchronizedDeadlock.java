package org.example.locks.deadlocks;

public class SynchronizedDeadlock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void methodA() {
        synchronized (lock1) {
            System.out.println("T1: Holding lock 1...");
            sleep(100); // Give T2 time to grab lock 2
            System.out.println("T1: Waiting for lock 2...");
            synchronized (lock2) {
                System.out.println("T1: Acquired both!");
            }
        }
    }

    public void methodB() {
        synchronized (lock2) {
            System.out.println("T2: Holding lock 2...");
            sleep(100); // Give T1 time to grab lock 1
            System.out.println("T2: Waiting for lock 1...");
            synchronized (lock1) {
                System.out.println("T2: Acquired both!");
            }
        }
    }

    private void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }

    public static void main(String[] args) {
        SynchronizedDeadlock demo = new SynchronizedDeadlock();
        new Thread(demo::methodA, "Thread-1").start();
        new Thread(demo::methodB, "Thread-2").start();
    }
}