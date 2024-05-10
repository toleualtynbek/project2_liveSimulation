package com.toleu.models.plants;

import com.toleu.models.abstracts.Entity;

public abstract class Plant extends Entity {
    public Plant(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Plant() {
        super();
    }
}
