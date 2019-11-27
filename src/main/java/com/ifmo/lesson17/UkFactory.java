package com.ifmo.lesson17;

public class UkFactory extends Factory {
    @Override
    public Car createCar() {
        return new Bentley();
    }
}
