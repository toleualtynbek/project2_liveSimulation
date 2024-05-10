package com.toleu.sevice.impl;

import com.toleu.models.enums.DirectionType;

import java.util.Random;

public class ChooseDirectionServiceImpl {
    private final Random random;

    public ChooseDirectionServiceImpl(Random random) {
        this.random = random;
    }

    public DirectionType chooseDirection() {
        random.nextInt(4);
        return DirectionType.values()[random.nextInt(DirectionType.values().length)];
    }
}
