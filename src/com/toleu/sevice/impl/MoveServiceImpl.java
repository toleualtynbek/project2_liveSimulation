package com.toleu.sevice.impl;

import com.toleu.models.Island;
import com.toleu.models.abstracts.Animal;
import com.toleu.models.abstracts.Entity;
import com.toleu.models.enums.DirectionType;
import com.toleu.models.island.Field;
import com.toleu.sevice.MoveService;

public class MoveServiceImpl implements MoveService {
    private final Island island;

    public MoveServiceImpl(Island island) {
        this.island = island;
    }

    @Override
    public void move(Animal entity, Field from, DirectionType direction, int speed) {

    }
}
