package org.example.Pets;

import org.example.Enums.Species;
import org.example.Pet;

public class DomesticCat extends Pet implements Interfaces.Foul {

    public DomesticCat() {
        super.setSpecies(Species.DOMESTICCAT);
    }

    public DomesticCat(String nickName, int age, int trickLevel, String[] habits) {
        super(nickName, age, trickLevel, habits);
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