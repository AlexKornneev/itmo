package com.ifmo.kontrosha;

import java.util.Random;

public class Barrier implements Runnable {
    private static final int THREADS = 3;

    private static class Await {
        public boolean set = false;
    }

    private static final Await[] awaits = new Await[THREADS];
    private static final Thread[] threads = new Thread[THREADS];
    private static Random rnd = new Random();
    private final int threadNum;

    private Barrier(int num) {
        this.threadNum = num;
    }

    public static int getRndNumber() {
        return rnd.nextInt(1000) * 10;
    }

    public void run() {
        synchronized (awaits) {
            awaits[this.threadNum].set = true;
            awaits.notify();
        }

        final long startExecution = System.currentTimeMillis();
        executeTask();
        final long finishExecution = System.currentTimeMillis();
        System.out.println("Поток N" + this.threadNum + ". запущен в : " +
                startExecution + ". окончен в: " + finishExecution +
                ". Выполнялся: " + (finishExecution - startExecution) + ".");
    }

    public void executeTask() {
        int temp = 1000;
        for (int i = 0; i < getRndNumber(); i++)
            for (int j = 0; j < getRndNumber(); j++)
                for (int k = 0; k < getRndNumber(); k++)
                    temp = temp / temp * temp;
    }

    public static void main(String[] args) {
        for (int i = 0; i < THREADS; i++) {
            awaits[i] = new Await();
        }

        System.out.println("Запускаем " + THREADS + " потока...");

        synchronized (Barrier.class) {
            synchronized (awaits) {
                for (int i = 0; i < THREADS; i++) {
                    final Barrier mainThread = new Barrier(i);
                    threads[i] = new Thread(mainThread, "Поток N" + i);
                    threads[i].start();
                }

                System.out.println("Ждем статра у барьера ...");

                boolean isAllStarted = false;
                while (!isAllStarted) {
                    try {
                        awaits.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    isAllStarted = true;
                    for (int i = 0; i < THREADS; i++) {
                        if (!awaits[i].set) {
                            isAllStarted = false;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < THREADS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}