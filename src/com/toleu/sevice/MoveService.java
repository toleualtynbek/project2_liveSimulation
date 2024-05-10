package com.toleu.sevice;

import com.toleu.models.abstracts.Animal;
import com.toleu.models.enums.DirectionType;
import com.toleu.configuration.FieldConfig;

public interface MoveService {
    void move(Animal entityToMove, FieldConfig from, DirectionType direction, int speed);

}
