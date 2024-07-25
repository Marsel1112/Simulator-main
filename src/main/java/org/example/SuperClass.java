package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.Controller.Statistic.IslandStatistics;
import org.example.Model.Creature.AnimalType;
import org.example.Model.Creature.Animals.Predator.Anaconda;
import org.example.Service.Island.CreateLiveCell;
import org.example.Controller.LifeSimulator.LifeSimulatorTerminal;
import org.example.Model.Island.DeadIsland;
import org.example.Service.Island.IslandCreatorService;
import org.example.Repository.Config.AnimalConfig;
import org.example.Repository.Config.FoodConfig;
import org.example.Service.ReadFile.JsonParser;
import org.example.Service.SearhCreature;

import java.io.IOException;

@NoArgsConstructor
public class SuperClass {
    private final int[] ISLAND_CONFIG = new int[]{10, 10};
    private final long TIME_RETURN_STATISTICS_MILLIS = 10000;

    @Getter
    private AnimalConfig animalConfig;
    @Getter
    private FoodConfig foodConfig;
    @Getter
    private DeadIsland deadIsland;

    public void go() {

        System.out.println(readConfig(new JsonParser()));

        System.out.println(insertLive());
        goToLife();

    }
    private String readConfig(JsonParser parser){
        try{
            animalConfig = new AnimalConfig(parser.readAnimalConfig());
            foodConfig = new FoodConfig(parser.readEatConfig());
        } catch (IOException e) {
            return "Что то с файлами конфигруции" + e.getMessage();
        }
        return "Файлы успешно считаны";
    }
    private String insertLive(){
        deadIsland = new IslandCreatorService(ISLAND_CONFIG[0], ISLAND_CONFIG[1]).createIsland();
        CreateLiveCell cell = new CreateLiveCell();
        String text =  cell.insertLiveCell(animalConfig,deadIsland);

        return text;
    }
    private void goToLife(){
        while (true) {
            try {
                LifeSimulatorTerminal simulatorTerminal = new LifeSimulatorTerminal(deadIsland,animalConfig,foodConfig);
                simulatorTerminal.start();
                Thread.sleep(TIME_RETURN_STATISTICS_MILLIS);
                simulatorTerminal.isRunning(false);
                simulatorTerminal.join();
            } catch (InterruptedException e) {
                System.out.println("Что то пошло не так"+ e.getMessage());
            }
        }


    }
}



