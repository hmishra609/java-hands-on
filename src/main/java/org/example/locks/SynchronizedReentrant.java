package org.example.locks;

public class SynchronizedReentrant {
    
    public synchronized void outer() {
        System.out.println("Thread entered outer()");
        
        // Re-entering the lock on the same 'this' object
        inner(); 
        
        System.out.println("Thread finished outer()");
    }

    public synchronized void inner() {
        System.out.println("Thread entered inner() - Re-entrancy worked!");
    }

    public static void main(String[] args) {
        new SynchronizedReentrant().outer();
    }
}