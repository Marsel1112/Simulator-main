package org.example.Factory;


import org.example.Model.Creature.*;
import org.example.Model.Creature.Animals.Herbivorous.*;
import org.example.Model.Creature.Animals.Plant.Plant;
import org.example.Model.Creature.Animals.Predator.*;

public class CreatureFactory {
    public Creature createCreature(AnimalType animalType) {
        return switch (animalType) {
            case ANACONDA ->    new Anaconda();
            case BEAR ->        new Bear();
            case BOAR ->        new Boar();
            case BUFFALO ->     new Buffalo();
            case CATERPILLAR -> new Caterpillar();
            case DEER ->        new Deer();
            case DUCK ->        new Duck();
            case EAGLE ->       new Eagle();
            case FOX ->         new Fox();
            case HORSE ->       new Horse();
            case GOAT ->        new Goat();
            case MOUSE ->       new Mouse();
            case WOLF ->        new Wolf();
            case PLANT ->       new Plant();
            case RABBIT ->      new Rabbit();
            case SHEEP ->       new Sheep();
            default -> throw    new IllegalArgumentException("Invalid animal type: " + animalType);
        };
    }
}
