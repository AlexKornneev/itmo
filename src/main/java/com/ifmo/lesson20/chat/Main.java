package com.ifmo.lesson20.chat;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new HelloThread());
            thread.setName("T-" + i);
            thread.start();

            System.out.println("Before start: " + thread.isAlive() + thread.getState());
           // thread.start();
            thread.join();
            System.out.println("After join: " + thread.isAlive()+ thread.getState());
        }
    }
    public static class HelloThread implements Runnable {
        @Override
        public void run() {
            System.out.printf("Hello, multithreaded world! (%s)\n",
                    Thread.currentThread().getName());
        }
    }
}