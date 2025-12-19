package org.example.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ManualReentrantLock {
    private final ReentrantLock lock = new ReentrantLock();

    public void outer() {
        lock.lock(); // Hold count = 1
        try {
            System.out.println("Lock acquired in outer(). Hold count: " + lock.getHoldCount());
            inner();
        } finally {
            lock.unlock(); // Hold count becomes 0
            System.out.println("Lock released in outer().");
        }
    }

    public void inner() {
        lock.lock(); // Hold count = 2 (Re-entrant)
        try {
            System.out.println("Lock acquired in inner(). Hold count: " + lock.getHoldCount());
        } finally {
            lock.unlock(); // Hold count becomes 1
            System.out.println("Lock released in inner().");
        }
    }

    public static void main(String[] args) {
        new ManualReentrantLock().outer();
    }
}