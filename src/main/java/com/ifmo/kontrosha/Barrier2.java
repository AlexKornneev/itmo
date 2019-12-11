package com.ifmo.kontrosha;

import java.util.concurrent.CyclicBarrier;

public class Barrier2 {
    private static final CyclicBarrier Barrier = new CyclicBarrier(3, new executeTask());

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new Thread(new Raner(i)).start();
            Thread.sleep(400);
        }
    }

    public static class executeTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Потоки запущены ");
            } catch (InterruptedException e) {
            }
        }
    }

    public static class Raner implements Runnable {
        private int ThreadNumber;

        public Raner(int ThreadNumber) {
            this.ThreadNumber = ThreadNumber;
        }


        @Override
        public void run() {
            try {
                System.out.printf("Поток №%d прибыл к барьеру и ждет.\n", ThreadNumber);
                Barrier.await();
                System.out.printf("Поток №%d продолжил движение.\n", ThreadNumber);
            } catch (Exception ignored) {
            }
        }
    }
}
