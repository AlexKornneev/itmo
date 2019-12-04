package com.ifmo.lesson21.Pizza;

public class Waiter implements Runnable {
    private Restaurant rest;

    public void waiterService() throws InterruptedException {
        synchronized (rest) {
            rest.notifyAll();
            while (rest.clientOrder == false)
                rest.wait();
            System.out.println("Официант уточняет заказ");
            Thread.sleep(10000);
            rest.putOrder(rest.getClientOrder());
            while (rest.orderReady == false)
                rest.wait();
            rest.putOrderReceived(rest.getFood());
        }
    }

    public Waiter(Restaurant rest) {
        this.rest = rest;
    }

    @Override
    public void run() {
        try {
            waiterService();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}