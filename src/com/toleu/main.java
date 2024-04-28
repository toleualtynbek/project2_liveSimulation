package com.toleu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toleu.configuration.AnimalRelationship;
import com.toleu.configuration.EntityCharacteristicConfig;
import com.toleu.configuration.IslandConfig;
import com.toleu.models.Island;
import com.toleu.models.abstracts.Animal;
import com.toleu.models.abstracts.Entity;
import com.toleu.models.enums.EntityType;
import com.toleu.models.island.Field;
import com.toleu.models.plants.Grass;
import com.toleu.models.predators.Wolf;
import com.toleu.sevice.MoveService;
import com.toleu.sevice.impl.ChooseDirectionServiceImpl;
import com.toleu.sevice.impl.MoveServiceImpl;

import java.util.*;
import java.util.stream.IntStream;

import static com.toleu.consts.Consts.*;

public class main {


    public static void main(String[] args){
        ObjectMapper objectMapper = new ObjectMapper();
        EntityCharacteristicConfig entityCharacteristicConfig = new EntityCharacteristicConfig(objectMapper, PATH_TO_ENTITY_CHARACTERISTICS);
        AnimalRelationship animalRelationship = new AnimalRelationship(objectMapper, PATH_TO_POSIBILITY);
        IslandConfig islandConfig = new IslandConfig(PATH_TO_SETTINGS);

        // stage to change default settings
        System.out.println("Поменять характерстики");
        islandConfig.setWidth(100);

        Random r = new Random();



        ChooseDirectionServiceImpl chooseDirectionService = new ChooseDirectionServiceImpl(r);

        Island island = createIsland(islandConfig);
        MoveService moveService = new MoveServiceImpl(island);
        int maxPlantOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.GRASS);
       // int maxWolfOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.WOLF);

        // fill plants
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxPlantOnField))
                .mapToObj(i -> createGrass(entityCharacteristicConfig))
                .forEach(value::add));

        // fill wolves
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxPlantOnField))
                        .mapToObj(i -> createWolf(entityCharacteristicConfig))
                        .forEach(value::add));


        // move wolf
        for (Map.Entry<Field, List<Entity>> fieldListEntry : island.getIsland().entrySet()) {
            Field field = fieldListEntry.getKey();
            List<Animal> entities = fieldListEntry.getValue()
                    .stream()
                    .filter(Animal.class::isInstance)
                    .map(el -> (Animal) el)
                    .toList();
            for(Animal entity : entities){
                int speed = getSpeed(entityCharacteristicConfig,EntityType.WOLF);
                var directionToMove = chooseDirectionService.chooseDirection();
                moveService.move(entity,field,directionToMove,speed);
            }
        }


        System.out.println(island);
    }

    private static Grass createGrass(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Grass(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.GRASS));
    }
    private static Wolf createWolf(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Wolf(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.WOLF));
    }

    private static Integer getMaxCountOnField(EntityCharacteristicConfig entityCharacteristicConfig,EntityType entityType) {
        return entityCharacteristicConfig
                .getEntityMapConfig()
                .get(entityType)
                .getMaxCountOnField();
    }

    private static Integer getSpeed(EntityCharacteristicConfig entityCharacteristicConfig,EntityType entityType) {
        return entityCharacteristicConfig
                .getEntityMapConfig()
                .get(entityType)
                .getSpeed();
    }
    private static Island createIsland(IslandConfig islandConfig) {

        Map<Field, List<Entity>> island = new HashMap<>();
        for (int i = 0; i < islandConfig.getHeight(); i++) {
            for (int j = 0; j < islandConfig.getWidth(); j++) {
                Field f = new Field(i,j);
                island.put(f,new ArrayList<>());
            }
        }
        return new Island(island);
    }
}
