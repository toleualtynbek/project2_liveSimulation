package com.toleu.models;

import com.toleu.models.abstracts.Entity;
import com.toleu.models.island.Field;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Island {
    private Map<Field, List<Entity>> island;

    public Island(Map<Field, List<Entity>> island) {
        this.island = island;
    }

    public Map<Field, List<Entity>> getIsland() {
        return island;
    }
}
