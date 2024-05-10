package com.toleu.models.herbivores;

import com.toleu.models.abstracts.Entity;

public class Deer extends Herbivore{
    public Deer() {
        super();
    }

    public Deer(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Deer(Entity entity) {
        super(entity.getWeight(),
                entity.getMaxCountOnField(),
                entity.getSpeed(),
                entity.getKgToFullEating());
    }
}
