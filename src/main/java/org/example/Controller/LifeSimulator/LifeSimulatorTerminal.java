package org.example.Controller.LifeSimulator;

import lombok.AllArgsConstructor;
import org.example.Controller.Statistic.IslandStatistics;
import org.example.Model.Island.DeadIsland;
import org.example.Repository.Config.AnimalConfig;
import org.example.Repository.Config.FoodConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
@AllArgsConstructor
public class LifeSimulatorTerminal extends Thread{

    private final DeadIsland deadIsland;
    private AnimalConfig animalConfig;
    private FoodConfig foodConfig;
    private final AtomicBoolean running = new AtomicBoolean(true);

    @Override
    public void run() {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            while(running.get()) {
                executorService.execute(new LifeSimulator(deadIsland,animalConfig,foodConfig));
            }
        }catch (Exception e){
            System.out.println("Что то пошло не так:" + e.getMessage());
        }finally {
            executorService.shutdownNow();
            IslandStatistics islandStatistics = new IslandStatistics();
            islandStatistics.stat(deadIsland);
        }

    }
    public void isRunning(boolean b) {
        running.set(b);
    }
}
