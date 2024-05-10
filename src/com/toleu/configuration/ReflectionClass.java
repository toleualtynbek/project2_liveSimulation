package com.toleu.configuration;

import com.toleu.models.abstracts.Entity;
import com.toleu.models.enums.EntityType;

import java.lang.reflect.InvocationTargetException;

public class ReflectionClass {
    public Entity createEntityClass(Entity entity) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Entity entityClass;
        entityClass = entity
                .getClass()
                .getConstructor()
                .newInstance();
        return entityClass;
    }

    public Entity createEntityTypeClass(EntityType entityType) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Entity entityTypeClass;
        entityTypeClass = (Entity) entityType
                .getClazz()
                .getConstructor()
                .newInstance();
        return entityTypeClass;
    }
}
