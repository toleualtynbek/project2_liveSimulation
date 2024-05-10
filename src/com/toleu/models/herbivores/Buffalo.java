package com.toleu.models.herbivores;

import com.toleu.models.abstracts.Entity;

public class Buffalo extends Herbivore{
    public Buffalo() {
        super();
    }

    public Buffalo(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Buffalo(Entity entity) {
        super(entity.getWeight(),
                entity.getMaxCountOnField(),
                entity.getSpeed(),
                entity.getKgToFullEating());
    }
}
