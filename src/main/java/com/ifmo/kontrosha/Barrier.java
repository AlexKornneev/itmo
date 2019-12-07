package com.ifmo.kontrosha;

public class Barrier implements Runnable {

    public static void main(String[] args) {

        MyThread3 thread1 = new MyThread3("MyThread1");
        thread1.start();
        MyThread3 thread2 = new MyThread3("MyThread2");
        thread2.start();
        MyThread3 thread3 = new MyThread3("MyThread3");
        thread3.start();
    }

    @Override
    public void run() {

    }
}

class MyThread3 implements Runnable {
    Thread mythread;
    private String threadname;

    MyThread3(String name) {
        threadname = name;
    }

    @Override
    public void run() {
        System.out.println("Thread running" + threadname);
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            System.out.println(threadname);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }
    }

    public void start() {
        System.out.println("Thread started");
        if (mythread == null) {
            mythread = new Thread(this, threadname);
            mythread.start();
        }
    }
}
