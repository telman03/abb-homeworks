package org.example.Model.Pets;

import org.example.Abstracts.Pet;
import org.example.Model.Enums.Species;

import java.util.Set;

public class Fish extends Pet {

    public Fish() {
        super.setSpecies(Species.FISH);
    }
    public Fish(String nickName, int age, int trickLevel, Set<String> habits) {
        super(nickName, age, trickLevel, habits);
        super.setSpecies(Species.FISH);
    }

    @Override
    public void respond() {
        System.out.println(this.getNickName()+" just looking");
    }
}
