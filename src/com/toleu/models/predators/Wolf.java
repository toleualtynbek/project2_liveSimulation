package com.toleu.models.predators;

import com.toleu.models.abstracts.Entity;
import com.toleu.models.predators.Predator;

public class Wolf extends Predator {

    protected Wolf(Double weight,
                   Integer maxCountOnField,
                   Integer speed,
                   Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Wolf(Entity entity){
        super(entity.getWeight(),
                entity.getMaxCountOnField(),
                entity.getSpeed(),
                entity.getKgToFullEating());
    }
}
