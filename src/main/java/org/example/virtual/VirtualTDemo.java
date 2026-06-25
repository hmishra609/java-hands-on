package org.example.virtual;

import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualTDemo {
    int NUM_OF_TASKS = 10000;
    int BLOCKING_TIME_MS = 1000;
    void main() {

        Callable<String> Task = () -> {
            try{
                Thread.sleep(BLOCKING_TIME_MS);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            return Thread.currentThread().getName();
        };

        System.out.println("Starting the Simulation");

        System.out.println("Running with Traditional Platform Threads (Pool of 200)...");

        ExecutorService executorService= Executors.newFixedThreadPool(200);

        long runtime=runWorkload(executorService,Task);
        System.out.println("Runtime with Platform Threads: "+runtime+" milliseconds");

        System.out.println("Running with Virtual Threads...");

        ExecutorService virtualThreadExecutor= Executors.newVirtualThreadPerTaskExecutor();
        long runtimevirtual=runWorkload(virtualThreadExecutor,Task);
        System.out.println("Runtime with Virtual Threads: "+runtimevirtual+" milliseconds");


    }

    public long runWorkload(ExecutorService executorService,Callable<String> task) {
        Instant start = Instant.now();

        try(executorService){
        IntStream.range(0, NUM_OF_TASKS).forEach(i ->
                executorService.submit(task)
                );
        }
        Instant end = Instant.now();

        return end.toEpochMilli() - start.toEpochMilli();


    }
}
