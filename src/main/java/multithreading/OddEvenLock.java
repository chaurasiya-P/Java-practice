package main.java.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenLock {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        OddEven oddEven = new OddEven();

        Thread odd = new Thread(() -> {
            for(int i=0;i<10;i++) oddEven.oddPrint(lock, condition);
        });

        Thread even = new Thread(() -> {
            for(int i=0;i<10;i++) oddEven.evenPrint(lock, condition);
        });
        odd.start();
        even.start();
    }

}

class OddEven {
    int counter = 1;
    public void oddPrint(ReentrantLock lock, Condition condition) {
        try {
            lock.lock();
            while(counter%2==0) {
                condition.await();
            }
            Thread.sleep(500);
            System.out.println(counter);
            counter++;
            condition.signal();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public void evenPrint(ReentrantLock lock, Condition condition) {
        try {
            lock.lock();
            while(counter%2!=0) {
                condition.await();
            }
            Thread.sleep(500);
            System.out.println(counter);
            counter++;
            condition.signal();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }
}
