package org.example.Controller.LifeSimulator;

import org.example.Model.Creature.Creature;
import org.example.Repository.Config.AnimalConfig;
import org.example.Repository.Config.FoodConfig;
import org.example.Service.LifeSimulatorServece.EatingSimulate.Eating;
import org.example.Service.LifeSimulatorServece.MoveSimulate.Movement;
import org.example.Service.LifeSimulatorServece.ReproductionSimulate.Reproduction;
import org.example.Model.Island.Cell;
import org.example.Model.Island.DeadIsland;
import org.example.Service.Random.Randomaizer;

public class LifeSimulator extends Thread{

    private final DeadIsland deadIsland;
    private final Cell cell;
    private final Creature creature;
    private final Randomaizer random;
    private final AnimalConfig animalConfig;
    private final FoodConfig foodConfig;

    public LifeSimulator(DeadIsland deadIsland,AnimalConfig animalConfig, FoodConfig foodConfig) {
        this.deadIsland = deadIsland;
        this.cell = deadIsland.getRandomCell();
        this.random = new Randomaizer();
        this.creature = getCreature();
        this.animalConfig = animalConfig;
        this.foodConfig = foodConfig;
    }

    @Override
    public void run() {
        switch (random.randInt(3)){
            case 0 -> {
                MoveHelper();
            }
            case 1 ->{
                EatingHelper();
            }
            case 2 -> {
                sexHelper();
            }
        }
    }
    private void  MoveHelper (){
        Movement movement = new Movement(deadIsland,creature,cell);
        movement.move(animalConfig);
    }
    private void EatingHelper (){
        Eating eating = new Eating(cell,creature,foodConfig,random);
        eating.eatSimulate();
    }
    private void sexHelper(){
        Reproduction reproduction = new Reproduction(creature,cell,animalConfig);
        reproduction.sekasService();
    }
    private Creature getCreature(){
        Creature rezult = cell.getCreatureList().get(random.randInt(cell.getCreatureList().size()));
        if(rezult == null){
            rezult = getCreature();
        }
        return rezult;
    }

}
