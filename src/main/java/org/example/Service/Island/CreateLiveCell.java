package org.example.Service.Island;

import org.example.Model.Creature.AnimalType;
import org.example.Repository.Config.AnimalConfig;
import org.example.Model.Island.Cell;
import org.example.Model.Island.DeadIsland;
import org.example.Factory.CreatureFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CreateLiveCell {

    public String insertLiveCell(AnimalConfig animalConfig, DeadIsland deadIsland) {
        if (deadIsland.getCells() == null || deadIsland.getCells().length == 0) {
            return "Ячейки не инициализированы или пусты.";
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < deadIsland.getCells().length; i++) {

            int finalI = i;

            executorService.submit(() -> {
                int count = deadIsland.getCells()[finalI].length;
                for (int j = 0; j < count ; j++) {
                    for (AnimalType animalType : AnimalType.values()) {

                        generateRandomCreatureCell( deadIsland.getCell(finalI, j), animalType, animalConfig.getInfo(animalType.toString(), "count") );

                    }
                }
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            return "Что-то пошло не так: " + e.getMessage();
        }
        return "Создание жизни в ячейках завершено!!!";
    }

    private void generateRandomCreatureCell(Cell cell, AnimalType animalType, int count) {
        CreatureFactory creatureFactory = new CreatureFactory();
        for (int i = 0; i < count; i++) {
            try {
                cell.getCreatureList().add(creatureFactory.createCreature(animalType));
            } catch (Exception e) {
                System.err.println("Ошибка при создании сущности: " + e.getMessage());
            }
        }
    }
}