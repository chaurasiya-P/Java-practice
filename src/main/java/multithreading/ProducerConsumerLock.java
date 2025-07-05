package main.java.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerLock {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread producer = new Thread(() -> {
            for(int i=0;i<10;i++) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                producerConsumer.producer(lock, condition);
            }
        });

        Thread consumer = new Thread(() -> {
            for(int i=0;i<10;i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                producerConsumer.consumer(lock, condition);
            }
        });
        producer.start();
        consumer.start();
    }
}

class ProducerConsumer {
    int Max_Capacity = 4;
    List<Integer> buffer = new ArrayList<>();
    public void producer(ReentrantLock lock, Condition condition) {
        try {
            lock.lock();
            while(buffer.size() == Max_Capacity) {
                condition.await();
            }
            //Thread.sleep(500);
            int t = new Random().nextInt()%25;
            System.out.println("produced: " + t);
            buffer.add(t);
            condition.signal();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public void consumer(ReentrantLock lock, Condition condition) {
        try {
            lock.lock();
            while(buffer.size() == 0) {
                condition.await();
            }
            //Thread.sleep(500);
            int t = buffer.get(buffer.size()-1);
            System.out.println("Consumed: " + t);
            buffer.remove(buffer.size()-1);
            condition.signal();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }
}
