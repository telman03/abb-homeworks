package org.example.Pets;


import org.example.Enums.Species;
import org.example.Pet;

public class Dog extends Pet implements Interfaces.Foul {

    public Dog() {
        super.setSpecies(Species.DOG);
    }

    public Dog(String nickName, int age, int trickLevel, String[] habits) {
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