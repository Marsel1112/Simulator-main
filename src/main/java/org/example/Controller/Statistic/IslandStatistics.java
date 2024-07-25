package org.example.Controller.Statistic;

import lombok.AllArgsConstructor;
import org.example.Model.Creature.AnimalType;
import org.example.Model.Island.DeadIsland;

import java.util.*;
@AllArgsConstructor
public class IslandStatistics {

    public void stat(DeadIsland deadIsland) {

        HashMap<AnimalType, Integer> animalTypeMap = new HashMap<AnimalType, Integer>();

        for(AnimalType animalType:AnimalType.values()){
            animalTypeMap.put(animalType,0);
        }

        for (int i = 0; i < deadIsland.getCells().length; i++) {
            for (int j = 0; j < deadIsland.getCells()[i].length; j++) {
                deadIsland.getCell(i,j).insertCountInMap(animalTypeMap);
            }
        }
        System.out.println("Количество животных на острове!!!");
        for(var s: animalTypeMap.entrySet()){
            System.out.println(s.getKey()+"  "+s.getValue());
        }
        System.out.println();

    }
}
