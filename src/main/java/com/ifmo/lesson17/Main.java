package com.ifmo.lesson17;

public class Main {
    public static void main(String[] args) {
        Factory factory = Factory.getFactory("US");
        final var car = factory.createCar();

        System.out.println(car);
    }
}
