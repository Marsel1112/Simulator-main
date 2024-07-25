package org.example.Repository.Config;


import org.example.Model.Creature.AnimalType;

import java.util.HashMap;

public class AnimalConfig {
    private HashMap<AnimalType, HashMap<String, Integer>> config;

    public AnimalConfig(HashMap<AnimalType, HashMap<String, Integer>> config) {
        this.config = config;
    }

    public synchronized int getInfo(String text, String param) {
        return config.get(AnimalType.valueOf(text.toUpperCase())).get(param);
    }
}
