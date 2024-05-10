package com.toleu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toleu.configuration.PossibilityOfEatingConfig;
import com.toleu.configuration.EntityCharacteristicConfig;
import com.toleu.configuration.IslandConfig;
import com.toleu.models.Island;
import com.toleu.models.abstracts.Animal;
import com.toleu.models.abstracts.Entity;
import com.toleu.models.enums.EntityType;
import com.toleu.configuration.FieldConfig;
import com.toleu.models.plants.Grass;
import com.toleu.models.predators.Wolf;
import com.toleu.sevice.MoveService;
import com.toleu.sevice.impl.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.IntStream;

import static com.toleu.consts.Consts.*;

public class main {


    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Random r = new Random();
        ObjectMapper objectMapper = new ObjectMapper();

        EntityCharacteristicConfig entityCharacteristicConfig = new EntityCharacteristicConfig(objectMapper, PATH_TO_ENTITY_CHARACTERISTICS);
        PossibilityOfEatingConfig possibilityOfEatingConfig = new PossibilityOfEatingConfig(objectMapper, PATH_TO_POSIBILITY_OF_EATING);
        ChooseDirectionServiceImpl chooseDirectionService = new ChooseDirectionServiceImpl(r);

        Island island = getIsland(objectMapper, entityCharacteristicConfig);

        MoveServiceImpl moveServiceImp = new MoveServiceImpl(island, entityCharacteristicConfig, chooseDirectionService);
        island = moveServiceImp.getIsland();

    }

    private static Island getIsland(ObjectMapper objectMapper, EntityCharacteristicConfig entityCharacteristicConfig) {

        IslandConfig islandConfig = new IslandConfig(PATH_TO_SETTINGS);
        CreateService createService = new CreateService();

        // stage to change default settings
        // updateSettings(islandConfig, AnimalRelationship possibilityOfEatingConfig, EntityCharacteristicConfig entityCharacteristicConfig);

        Island island = createService.createIsland(islandConfig);
        CreateService createEntity = new CreateService(entityCharacteristicConfig,island);
        return island;
    }


   /* private static void updateSettings(IslandConfig islandConfig, AnimalRelationship animalRelationship, EntityCharacteristicConfig entityCharacteristicConfig) {
        System.out.println("Поменять характерстики");
        islandConfig.setWidth(100);
    }*/


}
