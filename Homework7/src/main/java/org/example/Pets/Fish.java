package org.example.Pets;

import org.example.Enums.Species;
import org.example.Pet;
public class Fish extends Pet {

    public Fish() {
        super.setSpecies(Species.FISH);
    }
    public Fish(String nickName, int age, int trickLevel, String[] habits) {
        super(nickName, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println(this.getNickName()+" just looking");
    }

    @Override
    public void foul() {

    }
}