package com.toleu.sevice.impl;

import com.toleu.configuration.EntityCharacteristicConfig;
import com.toleu.configuration.FieldConfig;
import com.toleu.models.Island;
import com.toleu.models.abstracts.Animal;
import com.toleu.models.abstracts.Entity;
import com.toleu.models.enums.DirectionType;
import com.toleu.models.enums.EntityType;
import com.toleu.sevice.MoveService;

import java.util.List;
import java.util.Map;

public class MoveServiceImpl implements MoveService {
    private Island island;
    public MoveServiceImpl(Island island, EntityCharacteristicConfig entityCharacteristicConfig, ChooseDirectionServiceImpl chooseDirectionService) {
        // move wolf
        island = moveAnmals(island, entityCharacteristicConfig, chooseDirectionService);
    }
    private Island moveAnmals(Island island, EntityCharacteristicConfig entityCharacteristicConfig, ChooseDirectionServiceImpl chooseDirectionService) {

        for (Map.Entry<FieldConfig, List<Entity>> fieldListEntry : island.getIsland().entrySet()) {
            FieldConfig field = fieldListEntry.getKey();
            List<Animal> entities = fieldListEntry.getValue()
                    .stream()
                    .filter(Animal.class::isInstance)
                    .map(el -> (Animal) el)
                    .toList();
            for(Animal entity : entities){
                for (EntityType value : EntityType.values()) {
                    int speed = getSpeed(entityCharacteristicConfig, value);
                    var directionToMove = chooseDirectionService.chooseDirection();
                    move(entity, field, directionToMove, speed);
                }
            }
        }
        return island;
    }
    public Island getIsland() {
        return island;
    }
    @Override
    public void move(Animal entity, FieldConfig from, DirectionType direction, int speed) {

    }
    private static Integer getSpeed(EntityCharacteristicConfig entityCharacteristicConfig, EntityType entityType) {
        return entityCharacteristicConfig
                .getEntityMapConfig()
                .get(entityType)
                .getSpeed();
    }
}
