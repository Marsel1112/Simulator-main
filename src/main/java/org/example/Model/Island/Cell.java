package org.example.Model.Island;

import lombok.Getter;
import org.example.Service.SearhCreature;
import org.example.Model.Creature.AnimalType;
import org.example.Model.Creature.Creature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Getter
public class Cell {
    private final int rows;
    private final int cols;
    private final List<Creature> creatureList;

    public Cell(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        creatureList =  new ArrayList<>();
    }

    public void insertCountInMap(HashMap<AnimalType,Integer> maps){
        for(Creature creature: creatureList){
            String name = "";
            try {
                name = creature.getClass().getSimpleName().toUpperCase();
            }catch (NullPointerException e){
                return;
            }
            if(maps.containsKey(AnimalType.valueOf(name))){
                maps.merge(AnimalType.valueOf(name),1,Integer::sum);

            }
        }
    }


}
