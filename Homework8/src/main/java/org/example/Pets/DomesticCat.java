package org.example.Pets;

import org.example.Enums.Species;
import org.example.Interfaces.Foul;
import org.example.Pet;

import java.util.Set;

public class DomesticCat extends Pet implements Foul {

    public DomesticCat() {
        super.setSpecies(Species.DOMESTICCAT);
    }

    public DomesticCat(String nickName, int age, int trickLevel, Set<String> habits) {
        super(nickName, age, trickLevel, habits);
        super.setSpecies(Species.DOMESTICCAT);
    }


    @Override
    public void respond() {
        System.out.println(this.getNickName() + " responded");
    }

    @Override
    public void foul() {
        System.out.println(this.getNickName() + " fouled");
    }
}