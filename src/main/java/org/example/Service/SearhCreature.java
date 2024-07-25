package org.example.Service;


import org.example.Model.Creature.AnimalType;
import org.example.Model.Creature.Creature;

public class SearhCreature {
    public AnimalType searhCreature(Creature creature){
        return AnimalType.valueOf(creature.getClass().getSimpleName().toUpperCase());
    }
}
