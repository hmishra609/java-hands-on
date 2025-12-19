package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, ExecutionException {
        ExecutorService executorService= Executors.newFixedThreadPool(5);


        CallableFutureExample(executorService);
        RunnableFutureExample(executorService);

    }

    private static void CallableFutureExample(ExecutorService executorService) throws InterruptedException {
        Callable<String> r= () -> { System.out.println("Thread with Name is running" + Thread.currentThread().getName()); return Thread.currentThread().getName();};
        Callable<String> r1= () -> { System.out.println("Thread with Name is running" + Thread.currentThread().getName()); return Thread.currentThread().getName();};
        Callable<String> r2= () -> { System.out.println("Thread with Name is running" + Thread.currentThread().getName()); return Thread.currentThread().getName();};
        Callable<String> r3= () -> { System.out.println("Thread with Name is running" + Thread.currentThread().getName()); return Thread.currentThread().getName();};
        Callable<String> r4= () -> { System.out.println("Thread with Name is running" + Thread.currentThread().getName()); return Thread.currentThread().getName();};
        Callable<String> r5= () -> { System.out.println("Thread with Name is running" + Thread.currentThread().getName()); return Thread.currentThread().getName();};


        List<Callable<String>> tasks= Arrays.asList(r,r1,r2,r3,r4);

        List<Future<String>> futures= executorService.invokeAll(tasks);


        for(Future<String> f:futures){
            try {
                System.out.println("Result from Future: " + f.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private static void RunnableFutureExample(ExecutorService executorService) throws InterruptedException, ExecutionException {
        Runnable r= () -> { System.out.println("Thread with Name is running" + Thread.currentThread().getName()); };

        Future<?> future= executorService.submit(r);

        System.out.println("Result from Future: " + future.get());

    }
}
