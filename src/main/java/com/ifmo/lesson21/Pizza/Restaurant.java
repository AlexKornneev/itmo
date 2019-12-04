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
        System.out.println("Принимаю заказ у клиента #" + orderId);
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
        System.out.println("оформить заказ клиента #" + l);
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
        System.out.println("Заказ получен офицантом #" + orderId);
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
        System.out.println("Заказ передан на кухню #" + l);
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
        System.out.println("Готовый заказ передан официанту #" + orderId);
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
        System.out.println("Официант забрал заказ с кухни #" + n);
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
        System.out.println("Заказ выдан клиенту #" + orderId);
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
        System.out.println("Заказ получен клиентом #" + l);
    }

}
