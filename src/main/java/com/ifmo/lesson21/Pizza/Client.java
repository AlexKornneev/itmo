package com.ifmo.lesson21.Pizza;

import java.util.concurrent.TimeUnit;

public class Client implements Runnable {
    // final нужен или нет?
    private Restaurant rest;

    public void makeOrder() throws InterruptedException {
        synchronized (rest) {
            rest.notifyAll();
            System.out.println("Готовим Ваш заказ");
            Thread.sleep(1000);
            rest.putclientOrder(rest.orderId);
            System.out.println("Ваш заказ готов!");
            while (!rest.orderReceived)
                rest.wait();
            rest.getOrderReceived();
        }
    }

    public Client(Restaurant rest) {
        this.rest = rest;
    }

    public void run() {
        try {
            makeOrder();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        while (true) {
//            Cooking c = cookingQueue.poll(2, TimeUnit.SECONDS);
//            if (c != null) {
//            }
//            Order o = clientQueue.poll(2, TimeUnit.SECONDS);
//            if (!orderQueue.offer(o, 120, TimeUnit.SECONDS)) {
//                break;
//            }
    }
}