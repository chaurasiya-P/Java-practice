package main.java.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool {

    public static void main(String[] args) {

        //With single thread, both runnable and callable will be executed in sequence

        ExecutorService executorService = Executors.newSingleThreadExecutor();

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

        executorService.submit(c);

        try {
            System.out.println(executorService.submit(c).get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        //If we comment above try-catch block, then main thread will terminate earlier
        //As we are using get() for future, so main thread is waiting for result, so main thread print comes into last
        System.out.println("Main thread before shutdown");
        executorService.shutdown();
        System.out.println("Main thread after shutdown");
    }
}
