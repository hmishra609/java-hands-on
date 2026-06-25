package org.example.threads;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class CallableDemo {
    void main() throws ExecutionException, InterruptedException {
        int num=5;
        Callable<Integer> factorial= () -> {
            int result = 1;
            for(int i=1; i<=num;i++){
                result *= i;
            }
            return result;
        };

        Supplier<Integer> factorialSupplier = () -> {;
            int result = 1;
            for(int i=1; i<=num;i++){
                result *= i;
            }
            return result;
        };

//        callableWithFuture(factorial);
//        CompletableFuture.supplyAsync(factorialSupplier)
//                         .thenAccept(result -> System.out.println("Factorial result: " + result));

        ScheduledExecutorService scheduler
                = Executors.newScheduledThreadPool(5);
        scheduler.scheduleAtFixedRate(() ->
                        System.out.println(
                                "Health Check 2 - Every 10 seconds"),
                0, 1, TimeUnit.SECONDS);

    }

    private static void callableWithFuture(Callable<Integer> factorial) throws InterruptedException, ExecutionException {
        ExecutorService executorService= Executors.newSingleThreadExecutor();


        Future<Integer> future=executorService.submit(factorial);
        System.out.println(future.get()); // blocking call
    }
}
