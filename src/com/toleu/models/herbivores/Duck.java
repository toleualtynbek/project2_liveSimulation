package com.toleu.models.herbivores;

import com.toleu.models.abstracts.Entity;

public class Duck extends Herbivore{
    public Duck() {
        super();
    }

    public Duck(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Duck(Entity entity) {
        super(entity.getWeight(),
                entity.getMaxCountOnField(),
                entity.getSpeed(),
                entity.getKgToFullEating());
    }
}
