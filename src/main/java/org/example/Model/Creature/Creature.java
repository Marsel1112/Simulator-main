package org.example.Model.Creature;


public abstract class Creature{
    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }
}
