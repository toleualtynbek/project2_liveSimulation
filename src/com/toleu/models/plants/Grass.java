package com.toleu.models.plants;

import com.toleu.models.abstracts.Entity;
import com.toleu.models.enums.EntityType;
import com.toleu.models.plants.Plant;

public class Grass extends Plant {
    public Grass(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Grass(Entity entity){
        super(entity.getWeight(),
                entity.getMaxCountOnField(),
                entity.getSpeed(),
                entity.getKgToFullEating());
    }

}
