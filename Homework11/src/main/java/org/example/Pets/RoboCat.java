package org.example.Pets;

import org.example.Abstracts.Pet;
import org.example.Enums.Species;
import org.example.Interfaces.Foul;

import java.util.Set;

public class RoboCat extends Pet implements Foul {

    public RoboCat() {
        super.setSpecies(Species.ROBOCAT);
    }

    public RoboCat(String nickName, int age, int trickLevel, Set<String> habits) {
        super(nickName, age, trickLevel, habits);
        super.setSpecies(Species.ROBOCAT);
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
