package com.ifmo.lesson17;

public class UsFactory extends Factory {
    @Override
    public Car createCar() {

        return new Crysler();

    }
}
