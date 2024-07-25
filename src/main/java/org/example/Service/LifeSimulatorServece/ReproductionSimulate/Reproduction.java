package org.example.Service.LifeSimulatorServece.ReproductionSimulate;


import lombok.AllArgsConstructor;
import org.example.Model.Creature.Creature;
import org.example.Model.Island.Cell;
import org.example.Factory.CreatureFactory;
import org.example.Service.SearhCreature;
import org.example.Repository.Config.AnimalConfig;

@AllArgsConstructor
public class Reproduction {
    private Creature creature;
    private Cell cell;
    private AnimalConfig animalConfig;

    public void sekasService(){
        SearchSexPartner sexPartner = new SearchSexPartner(cell,creature,animalConfig);
        CreatureFactory creatureFactory = new CreatureFactory();
        SearhCreature searhCreature = new SearhCreature();
        if(sexPartner.opportunityToSex()){
            cell.getCreatureList().add(creatureFactory.createCreature(searhCreature.searhCreature(creature)));
        }
    }
}
