package com.toleu.models.herbivores;

import com.toleu.models.abstracts.Entity;

public class Caterpillar extends Herbivore{
    public Caterpillar() {
        super();
    }

    public Caterpillar(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Caterpillar(Entity entity) {
        super(entity.getWeight(),
                entity.getMaxCountOnField(),
                entity.getSpeed(),
                entity.getKgToFullEating());
    }
}
