package org.example.Service.Island;

import lombok.AllArgsConstructor;
import org.example.Model.Island.Cell;
import org.example.Model.Island.DeadIsland;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


@AllArgsConstructor
public class IslandCreatorService {
    private final int countXCell;
    private final int countYCell;

    public DeadIsland createIsland() {
       return new DeadIsland(createCell());
    }
    private Cell[][] createCell(){

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Cell[][] cells = new Cell[countXCell][countYCell];

        for (int i = 0; i < cells.length; i++) {
            int finalI = i;
            executorService.submit(() -> {
                for (int j = 0; j < cells[finalI].length; j++) {
                    cells[finalI][j] = new Cell(finalI, j);
                }
            });
        }
        executorService.shutdown();
        try {
            if(!executorService.awaitTermination(1, TimeUnit.MINUTES)){
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }


        return cells;
    }

}
