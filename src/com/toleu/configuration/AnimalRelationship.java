package com.toleu.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toleu.models.abstracts.Animal;
import com.toleu.models.abstracts.Entity;

import java.util.Map;

public class AnimalRelationship {
    private Map<Map<Entity,Entity>,Long> possibilityOfEating;
    // ((wolf,mouse)=80)
    // ((mouse,wolf)=0)
    // ((wolf,grass)=0)


    public AnimalRelationship(ObjectMapper objectMapper, String pathToJson) {
        //TODO fill our class
    }
}
