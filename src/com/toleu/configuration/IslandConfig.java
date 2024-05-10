package com.toleu.configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class IslandConfig {
    private int width;
    private int height;
    private int daysOfLife;

    public IslandConfig(String pathToPropertiesFile) {
        try(BufferedReader br = new BufferedReader(new FileReader(pathToPropertiesFile))){
            Properties properties = new Properties();
            properties.load(br);
            this.daysOfLife = Integer.parseInt(properties.getProperty("island.daysOfLife"));
            this.height = Integer.parseInt(properties.getProperty("island.height"));
            this.width = Integer.parseInt(properties.getProperty("island.width"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setDaysOfLife(int daysOfLife) {
        this.daysOfLife = daysOfLife;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDaysOfLife() {
        return daysOfLife;
    }
}
