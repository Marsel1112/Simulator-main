package org.example.Model.Island;

import lombok.Getter;
import org.example.Service.Random.Randomaizer;

@Getter

public class DeadIsland {
    private Cell[][] cells;
    private Randomaizer random;
    public DeadIsland(Cell[][] cells) {
        this.cells = cells;
        random = new Randomaizer();
    }
    public synchronized Cell getCell(int row, int col){
        return cells[row][col];
    }
    public synchronized Cell getRandomCell(){
        return getCell(random.randInt(cells.length),random.randInt(cells[1].length));
    }
}
