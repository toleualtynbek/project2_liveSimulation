package com.toleu.models.enums;

import com.toleu.models.herbivores.Mouse;
import com.toleu.models.plants.Grass;
import com.toleu.models.predators.Wolf;

public enum EntityType {
    GRASS("grass",Grass.class),
    WOLF("wolf",Wolf.class),
    MOUSE("mouse",Mouse.class);

    private String type;
    private Class clazz;

    EntityType(String type, Class clazz) {
        this.type = type;
        this.clazz = clazz;
    }
}
