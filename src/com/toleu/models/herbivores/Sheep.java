package com.toleu.models.herbivores;

import com.toleu.models.abstracts.Entity;

public class Sheep extends Herbivore{
    public Sheep() {
        super();
    }

    public Sheep(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Sheep(Entity entity) {
        super(entity.getWeight(),
                entity.getMaxCountOnField(),
                entity.getSpeed(),
                entity.getKgToFullEating());
    }
}
