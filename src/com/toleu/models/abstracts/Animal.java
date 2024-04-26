package com.toleu.models.abstracts;

import com.toleu.sevice.AnimalControl;

public abstract class Animal extends Entity implements AnimalControl {
    private boolean isMovedInThisLap = false;
    protected Animal(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    @Override
    public void move() {

    }

    @Override
    public void multiply() {

    }

    @Override
    public void chooseDirection() {

    }
}
