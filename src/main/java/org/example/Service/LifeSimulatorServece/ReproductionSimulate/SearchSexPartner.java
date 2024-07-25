package org.example.Service.LifeSimulatorServece.ReproductionSimulate;

import lombok.AllArgsConstructor;
import org.example.Service.SearhCreature;
import org.example.Model.Creature.Creature;
import org.example.Model.Island.Cell;
import org.example.Repository.Config.AnimalConfig;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
@AllArgsConstructor
public class SearchSexPartner {
    private Cell cell;
    private Creature creature;
    private AnimalConfig animalConfig;

    public boolean opportunityToSex(){

        int count = countCreatures();
        int maxCount = maxCountCreatures();

        return count > 1 && count < maxCount;
    }
    private int countCreatures(){
        int count = 0;
        Iterator<Creature> iterator = cell.getCreatureList().iterator();
        while(iterator.hasNext()){
            Creature creatureIterator;
            try {
                creatureIterator = iterator.next();
            }catch (ConcurrentModificationException e){
                break;
            }
            if(creatureIterator  != null && creatureIterator.getClass().getSimpleName().equals(creature.getClass().getSimpleName())) {
                count++;
            }
        }
        return count;

    }
    private int maxCountCreatures(){
        SearhCreature searhCreature = new SearhCreature();
        return animalConfig.getInfo(creature.getClass().getSimpleName(),"count");
    }


}
