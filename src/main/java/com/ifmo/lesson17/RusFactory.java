package com.ifmo.lesson17;

public class RusFactory extends Factory {
    @Override
    public Car createCar() {
        return new Lada();
    }
}