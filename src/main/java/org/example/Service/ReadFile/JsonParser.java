package org.example.Service.ReadFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Model.Creature.AnimalType;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class JsonParser{
    private final ObjectMapper mapper   = new ObjectMapper();

    private final File FILE_ANIMAL_CONFIG = new File("src/main/resources/animalConfig.json");
    private final File FILE_EATING_CONFIG = new File("src/main/resources/EatingConfig.json");

    private final TypeReference<HashMap<AnimalType, HashMap<String, Integer>>> patternAnimalConfig = new TypeReference<HashMap<AnimalType, HashMap<String, Integer>>>(){};
    private final TypeReference<HashMap<AnimalType, HashMap<AnimalType, Integer>>> patternEatingConfig =new TypeReference<HashMap<AnimalType, HashMap<AnimalType, Integer>>>(){};

    public HashMap<AnimalType, HashMap<String, Integer>> readAnimalConfig() throws IOException {
        return mapper.readValue(FILE_ANIMAL_CONFIG, patternAnimalConfig);
    }

    public HashMap<AnimalType, HashMap<AnimalType, Integer>> readEatConfig() throws IOException {
        return mapper.readValue(FILE_EATING_CONFIG, patternEatingConfig);
    }

}
