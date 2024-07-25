package org.example.Service.LifeSimulatorServece.MoveSimulate;

import lombok.AllArgsConstructor;
import org.example.Model.Creature.Creature;
import org.example.Model.Island.Cell;
import org.example.Model.Island.DeadIsland;
import org.example.Repository.Config.AnimalConfig;
import org.example.Service.Random.Randomaizer;
import org.example.Service.SearhCreature;

@AllArgsConstructor
public class Movement {
    private DeadIsland deadIsland;
    private Creature creature;
    private Cell cell;

    public void move(AnimalConfig animalConfig){
        int speed = getSpeed(animalConfig);

        if(speed == 0)
            return;

        cell.getCreatureList().remove(creature);
        getNewCell(speed).getCreatureList().add(creature);
    }
    private int getSpeed(AnimalConfig animalConfig){
        Randomaizer randomaizer = new Randomaizer();
        SearhCreature searhCreature = new SearhCreature();

        String name = "";
        int speed = 0;
        try {
            speed = randomaizer.randInt(animalConfig.getInfo(creature.getClass().getSimpleName(),"speed"));
        }catch (NullPointerException e){
            return 0;
        }

        return speed;
    }
    private Cell getNewCell(int speed){
        Vector vector = new Vector(deadIsland,cell,speed);
        return vector.getVector();
    }

}
