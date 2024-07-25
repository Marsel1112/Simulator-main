package org.example.Service.LifeSimulatorServece.EatingSimulate;

import lombok.Getter;

import org.example.Model.Creature.Creature;
import org.example.Model.Island.Cell;
import org.example.Service.Random.Randomaizer;

@Getter
public class SearchForVictim {
    private final Creature victim;

    public SearchForVictim(Cell cell,Creature predator ) throws NullPointerException{
        victim = searching(cell,predator);
    }

    private Creature searching(Cell cell, Creature creature) {
        if (cell.getCreatureList().size() > 1)
            throw new NullPointerException();

        Creature victim;

        Randomaizer random = new Randomaizer();

        if((victim = cell.getCreatureList().get(random.randInt(cell.getCreatureList().size()))).equals(creature)){
            victim = searching(cell,creature);
        }
        return victim;
    }
}
