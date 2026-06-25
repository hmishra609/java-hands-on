package org.example.virtual;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadDemo {

    // Number of simulated requests/tasks
    private static final int NUM_TASKS = 10_000;
    // Simulated database/network delay in milliseconds
    private static final int BLOCKING_TIME_MS = 1000; 

    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        long totalMemory = Runtime.getRuntime().totalMemory();

        // Convert bytes to megabytes and gigabytes
        double totalMb = totalMemory / (1024.0 * 1024.0);
        double totalGb = totalMb / 1024.0;


        long maxMemory = Runtime.getRuntime().maxMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long used= Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("Available Processors: " + processors);
        System.out.println("Free Memory (bytes): " + freeMemory/(1024.0 * 1024.0));
        System.out.println("Max Memory (bytes): " + maxMemory/(1024.0 * 1024.0));
        System.out.println("Used Memory (bytes): " + used/(1024.0 * 1024.0));
        System.out.println("Total Memory: " + String.format("%.2f MB", totalMb) + " (" + String.format("%.3f GB", totalGb) + ")");

    }


}