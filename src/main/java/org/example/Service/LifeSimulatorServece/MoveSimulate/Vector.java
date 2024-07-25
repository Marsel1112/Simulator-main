package org.example.Service.LifeSimulatorServece.MoveSimulate;

import lombok.AllArgsConstructor;
import org.example.Model.Island.Cell;
import org.example.Model.Island.DeadIsland;
import org.example.Service.Random.Randomaizer;

@AllArgsConstructor
public class Vector {
    private  DeadIsland deadIsland;
    private Cell cell;
    private int speed;

    public Cell getVector(){
        int x = cell.getRows();
        int y = cell.getCols();

        Cell newCell = cell;

        switch (new Randomaizer().randInt(3)){
            case 0 : x = x - speed; break;
            case 1 : y = y + speed; break;
            case 2 : x = x + speed; break;
            case 3 : y = y - speed; break;
        }

        try {
            newCell = deadIsland.getCell(x,y);
        }catch (ArrayIndexOutOfBoundsException e){
            newCell = getVector();
        }

        return newCell;
    }
}
