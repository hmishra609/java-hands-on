package org.example.locks;

import java.util.concurrent.locks.ReentrantLock;

public class LockLeakDemo {
    private final ReentrantLock lock = new ReentrantLock();

    public void riskyTask(boolean shouldFail) {
        lock.lock(); 
        System.out.println(Thread.currentThread().getName() + " acquired the lock.");

        if (shouldFail) {
            System.out.println(Thread.currentThread().getName() + " is crashing...");
            // ERROR: We throw an exception BEFORE calling unlock()
            // and we didn't use a finally block!
            throw new RuntimeException("Kaboom!"); 
        }

        lock.unlock();
        System.out.println(Thread.currentThread().getName() + " released the lock.");
    }

    public static void main(String[] args) throws InterruptedException {
        LockLeakDemo demo = new LockLeakDemo();

        // Thread 1: Crashes while holding the lock
        Thread t1 = new Thread(() -> {
            try {
                demo.riskyTask(true);
            } catch (Exception e) {
                System.out.println("Caught exception from T1: " + e.getMessage());
            }
        }, "Worker-1");

        // Thread 2: Tries to get the lock after T1 crashed
        Thread t2 = new Thread(() -> {
            System.out.println("Worker-2 is trying to get the lock...");
            demo.riskyTask(false);
            System.out.println("Worker-2 finished successfully!");
        }, "Worker-2");

        t1.start();
        Thread.sleep(100); // Ensure T1 goes first
        t2.start();
    }
}