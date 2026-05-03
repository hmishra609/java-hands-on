package org.example.threads;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demonstrates virtual thread pinning leading to carrier exhaustion.
 *
 * Run with:
 *   javac VirtualThreadPinningDemo.java
 *   java -Djdk.virtualThreadScheduler.parallelism=2 VirtualThreadPinningDemo
 *
 * Optional: add -Djdk.tracePinnedThreads=full to see pinning stack traces.
 */
public class VirtualThreadPinningDemo {

    private static final int NUM_THREADS = 4;
    // Each thread gets its OWN lock so they can all enter simultaneously
    private static final Object[] LOCKS = new Object[NUM_THREADS];
    static {
        for (int i = 0; i < NUM_THREADS; i++) LOCKS[i] = new Object();
    }

    public static void main(String[] args) throws Exception {
        int carriers = Integer.getInteger("jdk.virtualThreadScheduler.parallelism",
                Runtime.getRuntime().availableProcessors());
        System.out.println("Carrier threads: " + carriers);
        System.out.println("Virtual threads: " + NUM_THREADS);
        System.out.println();

        System.out.println("=== Part 1: synchronized (carriers get exhausted) ===\n");
        demonstrateSynchronizedPinning(carriers);

        System.out.println("\n=== Part 2: ReentrantLock (carriers stay free) ===\n");
        demonstrateReentrantLockFix(carriers);
    }

    static void demonstrateSynchronizedPinning(int carriers) throws Exception {
        AtomicInteger completed = new AtomicInteger(0);
        long start = System.currentTimeMillis();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < NUM_THREADS; i++) {
                final int id = i;
                executor.submit(() -> {
                    long t = System.currentTimeMillis() - start;
                    System.out.printf("[%4dms] VT-%d entering synchronized block%n", t, id);
                    synchronized (LOCKS[id]) {
                        t = System.currentTimeMillis() - start;
                        System.out.printf("[%4dms] VT-%d acquired lock, sleeping 2s (carrier PINNED)%n", t, id);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        t = System.currentTimeMillis() - start;
                        System.out.printf("[%4dms] VT-%d done%n", t, id);
                    }
                    completed.incrementAndGet();
                    return null;
                });
            }
            executor.close();
        }

        long elapsed = System.currentTimeMillis() - start;
        System.out.println("\nSynchronized result:");
        System.out.println("  Completed: " + completed.get() + "/" + NUM_THREADS);
        System.out.println("  Elapsed:   " + elapsed + "ms");
        System.out.println("  Why: Each sleeping VT pins its carrier. Only " + carriers
            + " can run at a time.");
    }

    static void demonstrateReentrantLockFix(int carriers) throws Exception {
        AtomicInteger completed = new AtomicInteger(0);
        ReentrantLock[] locks = new ReentrantLock[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) locks[i] = new ReentrantLock();

        long start = System.currentTimeMillis();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < NUM_THREADS; i++) {
                final int id = i;
                executor.submit(() -> {
                    long t = System.currentTimeMillis() - start;
                    System.out.printf("[%4dms] VT-%d acquiring ReentrantLock%n", t, id);
                    locks[id].lock();
                    try {
                        t = System.currentTimeMillis() - start;
                        System.out.printf("[%4dms] VT-%d acquired lock, sleeping 2s (carrier FREE)%n", t, id);
                        Thread.sleep(2000);
                        t = System.currentTimeMillis() - start;
                        System.out.printf("[%4dms] VT-%d done%n", t, id);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        locks[id].unlock();
                    }
                    completed.incrementAndGet();
                    return null;
                });
            }
            executor.close();
        }

        long elapsed = System.currentTimeMillis() - start;
        System.out.println("\nReentrantLock result:");
        System.out.println("  Completed: " + completed.get() + "/" + NUM_THREADS);
        System.out.println("  Elapsed:   " + elapsed + "ms");
        System.out.println("  Why: VTs unmount during Thread.sleep(), " + carriers
            + " carriers serve all " + NUM_THREADS + " VTs concurrently.");
    }
}