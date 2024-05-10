package com.toleu.sevice.impl;

import com.toleu.configuration.EntityCharacteristicConfig;
import com.toleu.configuration.IslandConfig;
import com.toleu.models.Island;
import com.toleu.models.abstracts.Entity;
import com.toleu.configuration.FieldConfig;
import com.toleu.models.enums.EntityType;
import com.toleu.models.herbivores.*;
import com.toleu.models.plants.Grass;
import com.toleu.models.predators.Eagle;
import com.toleu.models.predators.Bear;
import com.toleu.models.predators.Boa;
import com.toleu.models.predators.Fox;
import com.toleu.models.predators.Wolf;

import java.util.*;
import java.util.stream.IntStream;

public class CreateService {


    Random r = new Random();
    public CreateService() {

    }

    public CreateService(EntityCharacteristicConfig entityCharacteristicConfig, Island island) {
        createEntity(entityCharacteristicConfig, island);
    }

    private void createEntity(EntityCharacteristicConfig entityCharacteristicConfig, Island island) {

        int maxPlantOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.GRASS);
        int maxWolfOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.WOLF);
        int maxBoaOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.BOA);
        int maxFoxOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.FOX);
        int maxBearOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.BEAR);
        int maxEagleOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.EAGLE);
        int maxHorseOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.HORSE);
        int maxDeerOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.DEER);
        int maxRabbitOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.RABBIT);
        int maxMouseOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.MOUSE);
        int maxGoatOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.GOAT);
        int maxSheepOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.SHEEP);
        int maxBoarOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.BOAR);
        int maxBuffaloOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.BUFFALO);
        int maxDuckOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.DUCK);
        int maxCaterpillarOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.CATERPILLAR);

        // fill plants
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxPlantOnField))
                        .mapToObj(i -> createGrass(entityCharacteristicConfig))
                        .forEach(value::add));
        // fill wolves
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxWolfOnField))
                        .mapToObj(i -> createWolf(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxBoaOnField))
                        .mapToObj(i -> createBoa(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxFoxOnField))
                        .mapToObj(i -> createFox(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxBearOnField))
                        .mapToObj(i -> createBear(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxEagleOnField))
                        .mapToObj(i -> createEagle(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxHorseOnField))
                        .mapToObj(i -> createHorse(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxDeerOnField))
                        .mapToObj(i -> createDeer(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxRabbitOnField))
                        .mapToObj(i -> createRabbit(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxMouseOnField))
                        .mapToObj(i -> createMouse(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxGoatOnField))
                        .mapToObj(i -> createGoat(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxSheepOnField))
                        .mapToObj(i -> createSheep(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxBoarOnField))
                        .mapToObj(i -> createBoar(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxBuffaloOnField))
                        .mapToObj(i -> createBuffalo(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxDuckOnField))
                        .mapToObj(i -> createDuck(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, r.nextInt(maxCaterpillarOnField))
                        .mapToObj(i -> createCaterpillar(entityCharacteristicConfig))
                        .forEach(value::add));
    }

    public Island createIsland(IslandConfig islandConfig) {
        Map<FieldConfig, List<Entity>> island = new HashMap<>();
        for (int i = 0; i < islandConfig.getHeight(); i++) {
            for (int j = 0; j < islandConfig.getWidth(); j++) {
                FieldConfig f = new FieldConfig(i,j);
                island.put(f,new ArrayList<>());
            }
        }
        return new Island(island);
    }
    private static Grass createGrass(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Grass(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.GRASS));
    }
    private static Wolf createWolf(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Wolf(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.WOLF));
    }
    private static Boa createBoa(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Boa(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.BOA));
    }
    private static Fox createFox(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Fox(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.FOX));
    }
    private static Bear createBear(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Bear(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.BEAR));
    }
    private static Eagle createEagle(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Eagle(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.EAGLE));
    }
    private static Horse createHorse(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Horse(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.HORSE));
    }
    private static Deer createDeer(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Deer(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.DEER));
    }
    private static Rabbit createRabbit(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Rabbit(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.RABBIT));
    }
    private static Mouse createMouse(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Mouse(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.MOUSE));
    }
    private static Goat createGoat(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Goat(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.GOAT));
    }
    private static Sheep createSheep(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Sheep(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.SHEEP));
    }
    private static Boar createBoar(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Boar(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.BOAR));
    }
    private static Buffalo createBuffalo(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Buffalo(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.BUFFALO));
    }
    private static Duck createDuck(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Duck(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.DUCK));
    }
    private static Caterpillar createCaterpillar(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Caterpillar(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.CATERPILLAR));
    }
    private static Integer getMaxCountOnField(EntityCharacteristicConfig entityCharacteristicConfig,EntityType entityType) {
        return entityCharacteristicConfig
                .getEntityMapConfig()
                .get(entityType)
                .getMaxCountOnField();
    }
}