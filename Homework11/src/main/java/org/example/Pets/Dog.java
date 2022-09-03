package org.example.Pets;

import org.example.Abstracts.Pet;
import org.example.Enums.Species;
import org.example.Interfaces.Foul;

import java.util.Set;

public class Dog extends Pet implements Foul {

    public Dog() {
        super.setSpecies(Species.DOG);
    }

    public Dog(String nickName, int age, int trickLevel, Set<String> habits) {
        super(nickName, age, trickLevel, habits);
        super.setSpecies(Species.DOG);
    }

    @Override
    public void foul() {
        System.out.println(this.getNickName() + " fouled");
    }

    @Override
    public void respond() {
        System.out.println(this.getNickName() + " greeting owner");
    }
}
