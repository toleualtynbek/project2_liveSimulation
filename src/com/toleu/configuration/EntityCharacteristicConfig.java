package com.toleu.configuration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toleu.models.abstracts.Entity;
import com.toleu.models.enums.EntityType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EntityCharacteristicConfig {
    private Map<EntityType, Entity> entityMapConfig;

    public Map<EntityType, Entity> getEntityMapConfig() {

        return entityMapConfig;
    }

    public EntityCharacteristicConfig(ObjectMapper objectMapper, String pathToJson) {

        HashMap<EntityType,Entity> entityMapConfig = new HashMap<>();
        File file = new File(pathToJson);

        for (EntityType value : EntityType.values()){
            Entity entity = null;
            try {
                JsonNode jn = objectMapper.readTree(file);
                JsonNode jo = jn.get(value.getType());
                double weight = jo.get("weight").asDouble();
                int speed = jo.get("speed").asInt();
                double kgToFullEating = jo.get("kgToFullEating").asDouble();
                double maxCountOnField = jo.get("maxCountOnField").asInt();
                entity = new Entity(weight, (int) maxCountOnField,speed,kgToFullEating);
              } catch (IOException e) {
                System.err.println(e.getMessage());
            }
            entityMapConfig.put(value,entity);
        }

        this.entityMapConfig = entityMapConfig;
    }
}
