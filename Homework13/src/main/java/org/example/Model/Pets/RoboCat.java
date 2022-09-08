package org.example.Model.Pets;

import org.example.Abstracts.Pet;
import org.example.Interfaces.Foul;
import org.example.Model.Enums.Species;

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
