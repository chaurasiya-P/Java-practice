package main.java;

public class OddEvenPrint {

    int count = 1;

    private synchronized void printEven() throws InterruptedException {
        while(count%2!=0) {
            wait();
        }
        System.out.println(count);
        count++;
        notify();
    }
    private synchronized void printOdd() throws InterruptedException {
        while(count%2==0) {
            wait();
        }
        System.out.println(count);
        count++;
        notify();
    }

    public static void main(String[] args) {
        OddEvenPrint oddEvenPrint = new OddEvenPrint();

        Runnable even = () -> {
            try {
                for(int i=0;i<10;i++) {
                    oddEvenPrint.printEven();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable odd = () -> {
            try {
                for(int i=0;i<10;i++) {
                    oddEvenPrint.printOdd();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread event = new Thread(even);
        Thread oddt = new Thread(odd);
        event.start();
        oddt.start();
    }

}
