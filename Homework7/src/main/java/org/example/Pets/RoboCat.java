package org.example.Pets;

import org.example.Enums.Species;
import org.example.Pet;

public class RoboCat extends Pet implements Interfaces.Foul {

    public RoboCat() {
        super.setSpecies(Species.ROBOCAT);
    }

    public RoboCat(String nickName, int age, int trickLevel, String[] habits) {
        super(nickName, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println(this.getNickName() + " greeting owner");
    }

    @Override
    public void foul() {
        System.out.println(this.getNickName() + " fouled");
    }
}