package com.ifmo.lesson17;

public class GerFactory extends Factory {
    @Override
    public Car createCar() {
        return new Bmw();
    }
}
