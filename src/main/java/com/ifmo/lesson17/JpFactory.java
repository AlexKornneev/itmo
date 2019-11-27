package com.ifmo.lesson17;

public class JpFactory extends Factory {
    @Override
    public Car createCar() {
        return new Toyota();
    }
}
