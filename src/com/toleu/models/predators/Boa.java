package com.toleu.models.predators;

import com.toleu.models.abstracts.Entity;

public class Boa extends Predator{
    public Boa() {
        super();
    }

    protected Boa(Double weight,
                  Integer maxCountOnField,
                  Integer speed,
                  Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Boa(Entity entity){
        super(entity.getWeight(),
                entity.getMaxCountOnField(),
                entity.getSpeed(),
                entity.getKgToFullEating());
    }
}
