package com.ifmo.lesson21.Pizza;

public class Restaurant {
    boolean clientOrder;
    boolean orderTaken;
    boolean orderReady;
    boolean orderReceived;
    long orderId;

    public Restaurant() {
    }

    public void makeRestaurant() {
        Client cl = new Client(this);
        Chef ch = new Chef(this);
        Waiter w = new Waiter(this);
        Thread t1 = new Thread(cl);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(ch);

        t1.start();
        t2.start();
        t3.start();
    }

    synchronized long getClientOrder() {
        while (!clientOrder) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        clientOrder = false;
        notifyAll();
        System.out.println("принимаю заказ у клиента Rest" + orderId);
        return orderId;
    }

    synchronized void putclientOrder(long l) {
        while (clientOrder) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        clientOrder = true;
        this.orderId = l;
        notifyAll();
        System.out.println("оформление заказа клиента Rest" + l);
    }

    synchronized long getOrder() {
        while (!orderTaken) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        orderTaken = false;
        notifyAll();
        System.out.println("заказ получен офицантом Rest" + orderId);
        return orderId;
    }

    synchronized void putOrder(long l) {
        while (orderTaken) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        orderTaken = true;
        this.orderId = l;
        notifyAll();
        System.out.println("заказ передан на кухню Rest" + l);
    }

    synchronized long getFood() {
        while (!orderReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        orderReady = false;
        notifyAll();
        System.out.println("готовый заказ передан официанту Rest" + orderId);
        return orderId;
    }

    synchronized void putFood(long n) {
        while (orderReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        orderReady = true;
        this.orderId = n;
        notifyAll();
        System.out.println("официант забрал заказ с кухни Rest" + n);
    }

    synchronized long getOrderReceived() {
        while (!orderReceived) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        orderReceived = false;
        notifyAll();
        System.out.println("заказ выдан клиенту Rest" + orderId);
        return orderId;
    }

    synchronized void putOrderReceived(long l) {
        while (orderReceived) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        orderReceived = true;
        this.orderId = l;
        notifyAll();
        System.out.println("заказ получен клиентом Rest" + l);
    }

}
