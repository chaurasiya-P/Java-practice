package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumerProblem {

    List<Integer> list = new ArrayList<>();

    private synchronized void producer() throws InterruptedException {
//        synchronized (this) {
//            if(list.size()==5) {
//                wait();
//            }
//            int t = new Random().nextInt()%25;
//            System.out.println("Produced: " + t);
//            list.add(t);
//            notify();
//        }
        //Thread.sleep(7000);
        while(list.size()==5) {
            wait();
        }
        int t = new Random().nextInt()%25;
        System.out.println("Produced: " + t);
        list.add(t);
        notify();
    }

    private synchronized void consumer() throws InterruptedException {
//        synchronized (this) {
//            if(list.size()==0) {
//                wait();
//            }
//            int t = list.get(list.size()-1);
//            list.remove(list.size()-1);
//            System.out.println("Consumed: " + t);
//            notify();
//        }
        System.out.println(Thread.currentThread().getName());
        while(list.size()==0) {
            wait();
        }
        int t = list.get(list.size()-1);
        list.remove(list.size()-1);
        System.out.println("Consumed: " + t);
        notify();

    }

    public static void main(String[] args) {
        ProducerConsumerProblem producerConsumerProblem = new ProducerConsumerProblem();
        Thread producer = new Thread(() -> {
            try {
                for(int i=0;i<10;i++) {
                    producerConsumerProblem.producer();
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                //Thread.sleep(2000);
                for(int i=0;i<10;i++) {
                    producerConsumerProblem.consumer();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        producer.start();
        consumer.start();
    }
}
