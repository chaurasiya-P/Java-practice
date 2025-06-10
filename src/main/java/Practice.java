package main.java;

public class Practice {
    public static void main(String[] args) {
        System.out.println("Starting git testing");

        System.out.println("test to print numbers in random order using two thread");
        ThreadTest test = new ThreadTest();
        ThreadTest test2 = new ThreadTest();
        test.start();
        test2.start();


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("test to print numbers in fixed order using two thread and having join on them");
        try {
            ThreadTest test3 = new ThreadTest();
            ThreadTest test4 = new ThreadTest();
            test3.start();
            test3.join();
            test4.join();
            test4.start();
        } catch (Exception e) {
            System.out.println("Error in join");
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Runnable test for random order print");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++) {
                    System.out.println("Runnable " + Thread.currentThread().getName() + " " + i);
                }
            }
        };

        //Runnable as functional interface
        Runnable runnable2 = () -> {
            for(int i=0;i<5;i++) {
                System.out.println("Runnable as functional interface " + Thread.currentThread().getName() + " " + i);
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        AnonymousTest anonymousTest = new AnonymousTest() {
            @Override
            public void test1() {
                System.out.println("test for anonymous inner class");
            }

            @Override
            public int test2(int n) {
                return n*n;
            }
        };

        anonymousTest.test1();
        System.out.println("return: " + anonymousTest.test2(5));



        //////////////// Constructor test  -> if constructor created with parameter, then default constructor
        // i.e. constructor with no argument will not exist
        ConstructorTest test1 = new ConstructorTest("ab");
        test1.setA(2);

        ConstructorTest test3 = new ConstructorTest();
        test3.setA(3);
        test3.setB("abc");

        System.out.println(test1.getA() + " " + test1.getB() + " " + test3.getA() + " " + test3.getB());

    }
}

class ThreadTest extends Thread{

    @Override
    public void run() {
        for(int i = 0; i<5; i++) {
            System.out.println(currentThread().getName() +" "+ i);
        }
    }
}