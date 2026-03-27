package org.example.threads;

import java.util.concurrent.CompletableFuture;

public class CompletableThreadDemo {

    public static void main(String[] args) {
//        CompletableFuture.supplyAsync(() -> "Data")
//                .thenApply(String::toUpperCase)          // Non-blocking transformation
//                .thenAccept(System.out::println)         // Non-blocking consumption
//                .exceptionally(ex -> {                   // Smooth error handling
//                    System.err.println("Error: " + ex);
//                    return null;
//                }).join();

        CompletableFuture.supplyAsync(()-> "Test Completable future")
                .thenApply((s) -> s.length()).thenAccept((s)-> System.out.println("Length of string: " + s));
    }
}
