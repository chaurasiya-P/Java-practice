package main.java;

public class OneTwoThreePrint {

    int count = 1;

    private synchronized void onePrint() throws InterruptedException {
        while (count%3!=1) {
            wait();
        }
        System.out.println(count);
        count++;
        notifyAll();
    }

    private synchronized void twoPrint() throws InterruptedException {
        while (count%3!=2) {
            wait();
        }
        System.out.println(count);
        count++;
        notifyAll();
    }

    private synchronized void threePrint() throws InterruptedException {
        while (count%3!=0) {
            wait();
        }
        System.out.println(count);
        count++;
        notifyAll();
    }

    public static void main(String[] args) {
        OneTwoThreePrint oneTwoThreePrint = new OneTwoThreePrint();

        Thread one = new Thread(() -> {
            for(int i=0;i<50;i++) {
                try {
                    oneTwoThreePrint.onePrint();
//                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread two = new Thread(() -> {
            for(int i=0;i<50;i++) {
                try {
                    oneTwoThreePrint.twoPrint();
//                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread three = new Thread(() -> {
            for(int i=0;i<50;i++) {
                try {
                    oneTwoThreePrint.threePrint();
//                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        one.start();
        two.start();
        three.start();
    }
}
