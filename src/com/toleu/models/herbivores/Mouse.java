package com.toleu.models.herbivores;

import com.toleu.models.abstracts.Entity;
import com.toleu.models.herbivores.Herbivore;

public class Mouse extends Herbivore {
    public Mouse() {
        super();
    }

    public Mouse(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Mouse(Entity entity) {
        super(entity.getWeight(),
                entity.getMaxCountOnField(),
                entity.getSpeed(),
                entity.getKgToFullEating());
    }
}
