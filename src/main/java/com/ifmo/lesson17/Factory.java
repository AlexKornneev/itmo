package com.ifmo.lesson17;

public abstract class Factory {
    public static Factory getFactory(String country) {
        switch (country) {
            case ("JP"):
                return new JpFactory();
            case ("US"):
                return new UsFactory();
            case ("RUS"):
                return new RusFactory();
            case ("Ger"):
                return new GerFactory();
            case ("UK"):
                return new UkFactory():
        }
        throw new IllegalArgumentException("NO Factory");
    }

//    public static Car createCar() {
//        return null;
//    }

    public abstract Car createCar();

    {
    }
}