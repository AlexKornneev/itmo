package com.ifmo.lesson21.Pizza;

public class Chef implements Runnable {
    private Restaurant rest;

    public void makeFood() throws InterruptedException {
        synchronized (rest) {
            rest.notifyAll();
            while (rest.orderTaken == false)
                rest.wait();
            System.out.println("Приступили к готовке");
            Thread.sleep(1000);
            rest.putFood(rest.getOrder());
            System.out.println("Заказ приготовлен");
        }
    }

    public Chef(Restaurant rest) {
        this.rest = rest;
    }

    @Override
    public void run() {
        try {
            makeFood();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}