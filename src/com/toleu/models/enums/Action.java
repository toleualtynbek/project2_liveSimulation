package com.toleu.models.enums;

import java.util.Random;

public enum Action {
    MOVE,
    EAT,
    MULTIPLY;
    public static Action GetRandomeAction() {
        Random random = new Random();
        var val = random.nextInt(values().length);
        return Action.values()[val];
    }
}
