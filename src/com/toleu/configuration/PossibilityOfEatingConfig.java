package com.toleu.configuration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toleu.models.abstracts.Entity;
import com.toleu.models.enums.EntityType;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class PossibilityOfEatingConfig {
    private Map<Map<Entity,Entity>,Long> possibilityOfEating;
    // ((wolf,mouse)=80)
    // ((mouse,wolf)=0)
    // ((wolf,grass)=0)


    public Map<Map<Entity, Entity>, Long> getPossibilityOfEating() {

        return possibilityOfEating;
    }

    public PossibilityOfEatingConfig(ObjectMapper objectMapper, String pathToJson) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Map<Map<Entity,Entity>,Long> possibilityOfEating = new HashMap<>();
        ReflectionClass reflectionClass = new ReflectionClass();
        File file = new File(pathToJson);
        Entity entityHunter = null;
        Entity entityFood = null;
        JsonNode jn = objectMapper.readTree(file);
        for (JsonNode node : jn){
            for (EntityType value : EntityType.values()){
                String from = node.get("from").asText();
                String to = node.get("to").asText();
                if (from.equals(value.getType())){
                    entityHunter = reflectionClass.createEntityTypeClass(value);
                } else if (to.equals(value.getType())) {
                    entityFood = reflectionClass.createEntityTypeClass(value);
                }
            }
            int percent = node.get("percent").isNull() ? 0 : node.get("percent").asInt();
            Map<Entity,Entity> entityMap = new HashMap<>();
            entityMap.put(entityHunter,entityFood);
            possibilityOfEating.put(entityMap, (long) percent);
        }
        this.possibilityOfEating = possibilityOfEating;
    }
}
