package org.example.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockBlockingDemo {
    private final ReentrantLock lock = new ReentrantLock();

    public void outer() {
        lock.lock(); // T1: Hold count = 1
        try {
            System.out.println(Thread.currentThread().getName() + " [OUTER] acquired. Hold count: " + lock.getHoldCount());
            
            // Artificial delay to give Thread 2 time to try and fail
            Thread.sleep(1000); 
            
            inner();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // T1: Hold count becomes 0 (Finally released!)
            System.out.println(Thread.currentThread().getName() + " [OUTER] released lock.");
        }
    }

    public void inner() {
        lock.lock(); // T1: Hold count = 2 (RE-ENTRANT SUCCESS)
        try {
            System.out.println(Thread.currentThread().getName() + " [INNER] acquired. Hold count: " + lock.getHoldCount());
            Thread.sleep(2000); // Holding the lock for a while
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // T1: Hold count becomes 1
            System.out.println(Thread.currentThread().getName() + " [INNER] released lock.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockBlockingDemo demo = new ReentrantLockBlockingDemo();

        // Thread 1: The "Owner" who will re-enter the lock
        Thread t1 = new Thread(demo::outer, "OwnerThread");

        // Thread 2: The "Competitor" who will be blocked
        Thread t2 = new Thread(() -> {
            System.out.println("            " + Thread.currentThread().getName() + " is trying to get lock...");
            demo.outer();
            System.out.println("            " + Thread.currentThread().getName() + " finally finished!");
        }, "CompetitorThread");

        t1.start();
        Thread.sleep(200); // Ensure T1 gets the lock first
        t2.start();
    }
}