package com.toleu.models.predators;

import com.toleu.models.abstracts.Entity;

public class Bear extends Predator{
    public Bear() {
        super();
    }

    protected Bear(Double weight,
                   Integer maxCountOnField,
                   Integer speed,
                   Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Bear(Entity entity){
        super(entity.getWeight(),
                entity.getMaxCountOnField(),
                entity.getSpeed(),
                entity.getKgToFullEating());
    }
}
