package com.toleu.models.abstracts;

import com.toleu.sevice.AnimalControl;

public abstract class Animal extends Entity implements AnimalControl {
   private int healthPercent;
    private boolean isMovedInThisLap;
    private boolean isNewBornAnimal;
    protected Animal(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
        this.healthPercent = 100;
        this.isMovedInThisLap = false;
    }

    public int getHealthPercent() {
        return healthPercent;
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

    public void decreaseHealthPercent(int decreaseFor) {

        this.healthPercent -= decreaseFor;
    }
}
