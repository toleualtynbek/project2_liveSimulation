package com.toleu.models.herbivores;

import com.toleu.models.abstracts.Entity;

public class Boar extends Herbivore{
    public Boar() {
        super();
    }

    public Boar(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Boar(Entity entity) {
        super(entity.getWeight(),
                entity.getMaxCountOnField(),
                entity.getSpeed(),
                entity.getKgToFullEating());
    }
}
