package com.toleu.configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AnimalConfig {
    private int percentsToRemove;

    public AnimalConfig(String pathToPropertiesFile) {
        try(BufferedReader br = new BufferedReader(new FileReader(pathToPropertiesFile))){
            Properties properties = new Properties();
            properties.load(br);
            this.percentsToRemove = Integer.parseInt(properties.getProperty("animals.percentsToRemove"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public int getPercentsToRemove() {
        return percentsToRemove;
    }
}
