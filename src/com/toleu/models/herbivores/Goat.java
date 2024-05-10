package com.toleu.models.herbivores;

import com.toleu.models.abstracts.Entity;

public class Goat extends Herbivore{
    public Goat() {
        super();
    }

    public Goat(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Goat(Entity entity) {
        super(entity.getWeight(),
                entity.getMaxCountOnField(),
                entity.getSpeed(),
                entity.getKgToFullEating());
    }
}
