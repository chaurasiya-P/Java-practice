package main.java.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

    public static void main(String[] args) {

        //With thread pool of 2 size, both runnable and callable tasks are executed in parallel

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable r = () -> {
            for(int i=0;i<5;i++) {

                System.out.println("Runnable task in execution by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Callable<String> c = () -> {
            for(int i=0;i<5;i++) {
                System.out.println("Callable task in execution by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return "Done";
        };

        executorService.submit(r);    //--> It is also fine for runnable ->  executorService.execute(r);

        try {
            System.out.println(executorService.submit(c).get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread before shutdown");
        executorService.shutdown();
        System.out.println("Main thread after shutdown");
    }
}
