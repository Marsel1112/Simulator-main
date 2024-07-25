package org.example.Repository.Config;

import lombok.AllArgsConstructor;
import org.example.Model.Creature.AnimalType;

import java.util.HashMap;
@AllArgsConstructor
public class FoodConfig {
    private  HashMap<AnimalType,HashMap<AnimalType,Integer>> config;

    public int getProbability(AnimalType predator,AnimalType victim){
        return config.get(predator.toString()).get(victim.toString());
    }
}
