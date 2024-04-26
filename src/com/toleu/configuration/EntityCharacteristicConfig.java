package com.toleu.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toleu.models.abstracts.Entity;
import com.toleu.models.enums.EntityType;

import java.util.HashMap;
import java.util.Map;

public class EntityCharacteristicConfig {
    private Map<EntityType, Entity> entityMapConfig;

    public Map<EntityType, Entity> getEntityMapConfig() {
        return entityMapConfig;
    }

    public EntityCharacteristicConfig(ObjectMapper objectMapper, String pathToJson) {
        //TODO kod which parse json file to entityMapConfig
        HashMap<EntityType,Entity> entityMapConfig = new HashMap<>();

        entityMapConfig.put(EntityType.GRASS,new Entity(10.0,100,null,null));
        entityMapConfig.put(EntityType.WOLF,new Entity(100.0,10,1,10.0));

        this.entityMapConfig = entityMapConfig;
    }
}
