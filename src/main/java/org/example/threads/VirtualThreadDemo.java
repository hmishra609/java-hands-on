package org.example.threads;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadDemo {

        public static void main(String[] args) throws ExecutionException, InterruptedException {
            // Use a Virtual Thread Per Task Executor
            try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
                IntStream.range(0, 5).forEach(i -> {
                    executor.submit(() -> {
                        String threadName = Thread.currentThread().toString();
                        System.out.println("Step 1: Running on " + threadName);

                        // This simulates a blocking I/O call (e.g., Database Query)
                        // At this point, the VT is UNMOUNTED from the carrier.
                        try {
                            Thread.sleep(Duration.ofSeconds(1));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        // Once the sleep finishes, the VT is MOUNTED again.
                        // Notice that the 'worker' (Carrier) might have changed!
                        System.out.println("Step 2: Resumed on " + Thread.currentThread().toString());
                    });
                });
            }


//            ExecutorService executorService= Executors.newVirtualThreadPerTaskExecutor();
//            executorService.submit(() -> {
//                System.out.println("Running on "+ Thread.currentThread().toString());
//            }).get();


        }
    }

