package com.toleu.models.herbivores;

import com.toleu.models.abstracts.Entity;

public class Horse extends Herbivore{
    public Horse() {
        super();
    }

    public Horse(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Horse(Entity entity) {
        super(entity.getWeight(),
                entity.getMaxCountOnField(),
                entity.getSpeed(),
                entity.getKgToFullEating());
    }
}
