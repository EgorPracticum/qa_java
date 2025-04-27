package com.example;

import java.util.List;

public class Lion {
    private final boolean hasMane;
    private final Predator predator;

    public Lion(String sex, Predator predator) throws Exception {
        this.predator = predator;
        if ("Самец".equals(sex)) {
            this.hasMane = true;
        } else if ("Самка".equals(sex)) {
            this.hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        if (predator instanceof Feline) {
            return ((Feline) predator).getKittens();
        }
        return 0;
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}