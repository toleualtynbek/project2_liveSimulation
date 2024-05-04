package com.toleu.models.predators;

import com.toleu.models.abstracts.Entity;

public class Fox extends Predator{
    protected Fox(Double weight,
                   Integer maxCountOnField,
                   Integer speed,
                   Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Fox(Entity entity){
        super(entity.getWeight(),
                entity.getMaxCountOnField(),
                entity.getSpeed(),
                entity.getKgToFullEating());
    }
}
