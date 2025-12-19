package org.example;

import java.util.concurrent.*;

public class ConcurrencyF_CF {

    public static void main(String[] args) throws Exception {
        
        // --- 1. THE FUTURE WAY (Blocking/Sequential) ---
        // Total time = Task A + Task B
        System.out.println("Starting Future Demo...");
        long start1 = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<String> f1 = executor.submit(() -> { Thread.sleep(1000); return "Burger"; });
        String burger = f1.get(); // STOP! Wait 1 second.

        Future<String> f2 = executor.submit(() -> { Thread.sleep(1000); return "Fries"; });
        String fries = f2.get();  // STOP! Wait 1 second.

        System.out.println("Future Result: " + burger + " & " + fries + 
                           " | Total Time: " + (System.currentTimeMillis() - start1) + "ms");


        System.out.println("\n-----------------------------------\n");


        // --- 2. THE COMPLETABLEFUTURE WAY (Non-blocking/Parallel) ---
        // Total time = Max(Task A, Task B)
        System.out.println("Starting CompletableFuture Demo...");
        long start2 = System.currentTimeMillis();

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> { 
            try { Thread.sleep(1000); } catch (Exception e) {} return "Burger"; 
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> { 
            try { Thread.sleep(1000); } catch (Exception e) {} return "Fries"; 
        });

        // Combine them WITHOUT stopping the main thread
        cf1.thenCombine(cf2, (res1, res2) -> res1 + " & " + res2)
           .thenAccept(meal -> {
               System.out.println("CF Result: " + meal + 
                                  " | Total Time: " + (System.currentTimeMillis() - start2) + "ms");
           });

        // Main thread is free!
        System.out.println("Main thread is already doing other work...");
        
        Thread.sleep(1500); // Wait so we can see the result before JVM exits
        executor.shutdown();
    }
}