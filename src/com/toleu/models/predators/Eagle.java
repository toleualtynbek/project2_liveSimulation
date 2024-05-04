package com.toleu.models.predators;

import com.toleu.models.abstracts.Entity;

public class Eagle extends Predator{
    protected Eagle(Double weight,
                   Integer maxCountOnField,
                   Integer speed,
                   Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Eagle(Entity entity){
        super(entity.getWeight(),
                entity.getMaxCountOnField(),
                entity.getSpeed(),
                entity.getKgToFullEating());
    }
}
