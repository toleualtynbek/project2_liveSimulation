package com.toleu.models.enums;

import com.toleu.models.herbivores.*;
import com.toleu.models.plants.Grass;
import com.toleu.models.predators.*;

public enum EntityType {
    GRASS("grass",Grass.class),
    WOLF("wolf",Wolf.class),
    MOUSE("mouse",Mouse.class),
    BOA("boa", Boa.class),
    FOX("fox", Fox.class),
    BEAR("bear", Bear.class),
    EAGLE("eagle", Eagle.class),
    HORSE("horse", Horse.class),
    DEER("deer", Deer.class),
    RABBIT("rabbit", Rabbit.class),
    GOAT("goat", Goat.class),
    SHEEP("sheep", Sheep.class),
    BOAR("boar", Boar.class),
    BUFFALO("buffalo", Buffalo.class),
    DUCK("duck", Duck.class),
    CATERPILLAR("caterpillar", Caterpillar.class);


    private String type;
    private Class clazz;

    EntityType(String type, Class clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    public String getType() {
        return type;
    }

    public Class getClazz() {
        return clazz;
    }
}
