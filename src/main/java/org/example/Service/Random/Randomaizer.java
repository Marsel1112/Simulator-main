package org.example.Service.Random;

import java.util.Random;

public class Randomaizer {
    public Random random;

    public Randomaizer() {
        this.random = new Random();
    }

    public int randInt(int count) {
        if(count == 0)
            return 0;

        return random.nextInt(count);
    }
}
