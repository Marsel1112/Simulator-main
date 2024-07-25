package org.example.Service.LifeSimulatorServece.EatingSimulate;

import lombok.AllArgsConstructor;
import org.example.Model.Creature.Creature;
import org.example.Repository.Config.FoodConfig;
import org.example.Model.Island.Cell;
import org.example.Service.Random.Randomaizer;
import org.example.Service.SearhCreature;
@AllArgsConstructor
public class Eating {

    private Cell cell;
    private Creature creature;
    private FoodConfig foodConfig;
    private Randomaizer randomaizer;

    public void eatSimulate(){
        SearhCreature searhCreature = new SearhCreature();
        try {
            SearchForVictim searchForVictim = new SearchForVictim(cell,creature);
        if(randomaizer.randInt(100)+1 <= foodConfig.getProbability(searhCreature.searhCreature(creature),searhCreature.searhCreature(searchForVictim.getVictim()))){
             cell.getCreatureList().remove(searchForVictim.getVictim());
            //System.out.println("СЪЕЛИ"+ searchForVictim.getVictim().getClass().getSimpleName()); //Тест на роботоспособность
        }
        else{
             cell.getCreatureList().remove(creature);
            //System.out.println("СЪЕЛИ"+ creature.getClass().getSimpleName());//Тест на роботоспособность
        }
        }catch (NullPointerException e){
            cell.getCreatureList().remove(creature);
            //System.out.println("СЪЕЛИ"+ creature.getClass().getSimpleName());//Тест на роботоспособность
        }
    }
}
