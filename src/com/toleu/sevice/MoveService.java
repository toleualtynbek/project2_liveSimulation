package com.toleu.sevice;

import com.toleu.models.Island;
import com.toleu.models.abstracts.Animal;
import com.toleu.models.abstracts.Entity;
import com.toleu.models.enums.DirectionType;
import com.toleu.models.island.Field;

public interface MoveService {
    void move(Animal entityToMove, Field from, DirectionType direction, int speed);

}
