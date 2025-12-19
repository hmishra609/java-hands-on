package org.example.locks.deadlocks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantDeadlockDemo {
    private final ReentrantLock lock1 = new ReentrantLock();
    private final ReentrantLock lock2 = new ReentrantLock();

    public void methodA() {
        String threadName = Thread.currentThread().getName();
        
        lock1.lock();
        try {
            System.out.println(threadName + ": Acquired lock1, waiting for lock2...");
            
            // Artificial delay to ensure Thread-2 can grab lock2
            Thread.sleep(100); 

            lock2.lock();
            try {
                System.out.println(threadName + ": Acquired both locks!");
            } finally {
                lock2.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
        }
    }

    public void methodB() {
        String threadName = Thread.currentThread().getName();
        
        lock2.lock(); // T2 starts with lock2
        try {
            System.out.println(threadName + ": Acquired lock2, waiting for lock1...");
            
            Thread.sleep(100); 

            lock1.lock(); // T2 tries to get lock1 (Held by T1)
            try {
                System.out.println(threadName + ": Acquired both locks!");
            } finally {
                lock1.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock2.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantDeadlockDemo demo = new ReentrantDeadlockDemo();

        new Thread(demo::methodA, "Thread-1").start();
        new Thread(demo::methodB, "Thread-2").start();
    }
}