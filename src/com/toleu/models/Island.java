package com.toleu.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toleu.configuration.EntityCharacteristicConfig;
import com.toleu.models.abstracts.Animal;
import com.toleu.models.abstracts.Entity;
import com.toleu.models.enums.EntityType;
import com.toleu.models.island.Field;
import com.toleu.models.plants.Grass;
import com.toleu.models.plants.Plant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.toleu.consts.Consts.PATH_TO_ENTITY_CHARACTERISTICS;

public class Island implements IslandAction {
    private final Map<Field, List<Entity>> island;
    ObjectMapper objectMapper = new ObjectMapper();
    EntityCharacteristicConfig entityCharacteristicConfig = new EntityCharacteristicConfig(objectMapper, PATH_TO_ENTITY_CHARACTERISTICS);

    public Island(Map<Field, List<Entity>> island) {
        this.island = island;
    }

    public Map<Field, List<Entity>> getIsland() {
        return island;
    }
    @Override
    public void removeDeathAnimal() {
        for (Map.Entry<Field, List<Entity>> fieldListEntry : island.entrySet()) {
            var allAnimals = fieldListEntry.getValue();
            for(Entity entity : allAnimals) {
                if(entity instanceof Animal animal) {
                    var healthPercent = animal.getHealthPercent();
                    if (healthPercent <= 0){
                        allAnimals.remove(entity);
                    }
                }
            }
        }
    }

    @Override
    public void refillPlants(int maxCountOfPlantInOneFields){
        for(var value : island.entrySet()) {
            var totalCountOfPlants = island
                    .values()
                    .stream()
                    .filter(entity -> entity instanceof Plant).count();
            if (totalCountOfPlants < maxCountOfPlantInOneFields) {
                List<Plant> plants = new ArrayList<>();
                for (int i = 0; i < maxCountOfPlantInOneFields - totalCountOfPlants; i++) {

                    Plant plant = new Grass(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.GRASS));
                    plants.add(plant);
                }
                island.put(value.getKey(), List.of((Entity) plants));
            }
        }
    }
}
