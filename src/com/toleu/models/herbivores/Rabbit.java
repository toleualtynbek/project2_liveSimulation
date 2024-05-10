package com.toleu.models.herbivores;

import com.toleu.models.abstracts.Entity;

public class Rabbit extends Herbivore{
    public Rabbit() {
        super();
    }

    public Rabbit(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Rabbit(Entity entity) {
        super(entity.getWeight(),
                entity.getMaxCountOnField(),
                entity.getSpeed(),
                entity.getKgToFullEating());
    }
}
