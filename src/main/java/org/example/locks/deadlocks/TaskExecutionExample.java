package org.example.locks.deadlocks;

import java.util.concurrent.*;

import java.util.Random;

public class TaskExecutionExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // 1. Create an ExecutorService (Thread Pool)

        // A FixedThreadPool with 2 threads is a good choice for this example.

        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println("ExecutorService (Thread Pool) created with 2 threads.");

        System.out.println("---");
/*
        // 2. Submit a Runnable Task (No return value)

        // The execute() method is typically used for Runnables.

        System.out.println("Submitting Runnable task (execution only)...");

        Runnable simpleTask = new SimpleRunnableTask("Runnable-Task-1");

        executor.execute(simpleTask);

        // You can also use submit() for a Runnable, which returns a Future<Void>

        Future<?> runnableFuture = executor.submit(new SimpleRunnableTask("Runnable-Task-2"));

        // We can wait for the Runnable to complete using the Future, but there's no result to get.

        // runnableFuture.get(); // This line would block until the task is done.*/

        System.out.println("---");

        // 3. Submit a Callable Task (With a return value)

        // The submit() method must be used for Callables, as it returns a Future.

        System.out.println("Submitting Callable task (execution + return value)...");

//        Callable<Integer> complexTask = new ComplexCallableTask("Callable-Task-A");

        Callable<Integer> lambdaCallableTask = () -> {
            System.out.println("[Task] Starting execution on thread: " + Thread.currentThread().getName());

            Random random = new Random();
            int randomNumber = random.nextInt(100);

            TimeUnit.SECONDS.sleep(1);

            System.out.println("[Task] Calculating result: " + randomNumber + " + 5");

            int finalResult = randomNumber + 5;

            System.out.println("[Task] Finished execution.");

            return finalResult;
        };

        Future<Integer> futureResult = executor.submit(lambdaCallableTask);

        // 4. Retrieve the Result using Future

        // The get() method is blocking—it waits for the task to complete.

        System.out.println("Waiting for Callable result...");

        Integer result = futureResult.get();

        System.out.println("*** Callable Result Received: " + result + " ***");

        System.out.println("---");

        // 5. Shutdown the ExecutorService

        executor.shutdown();

        System.out.println("ExecutorService shut down (no new tasks accepted).");

        // Wait for all currently executing and queued tasks to finish

        if (executor.awaitTermination(5, TimeUnit.SECONDS)) {

            System.out.println("All tasks finished and ExecutorService terminated.");

        } else {

            System.out.println("Not all tasks finished within the timeout.");

        }

    }

}

class SimpleRunnableTask implements Runnable {

    private final String name;

    public SimpleRunnableTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("[" + name + "] Starting execution on thread: " + Thread.currentThread().getName());
            // Simulate work being done
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("[" + name + "] Finished execution.");

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
            System.out.println("[" + name + "] Interrupted.");
        }
    }

}

//class ComplexCallableTask implements Callable<Integer> {
//
//    private final String name;
//
//    public ComplexCallableTask(String name) {
//        this.name = name;
//    }
//
//    // The call() method is required and returns a result of type Integer
//
//    @Override
//
//    public Integer call() throws Exception {
//
//        System.out.println("[" + name + "] Starting execution on thread: " + Thread.currentThread().getName());
//
//        // Simulate work and calculate a return value
//
//        Random random = new Random();
//
//        int randomNumber = random.nextInt(100);
//
//        TimeUnit.SECONDS.sleep(1); // Longer simulation time
//
//        System.out.println("[" + name + "] Calculating result: " + randomNumber + " + 5");
//
//        int finalResult = randomNumber + 5;
//
//        System.out.println("[" + name + "] Finished execution.");
//
//        return finalResult; // This value is returned to the Future
//
//    }
//
//}