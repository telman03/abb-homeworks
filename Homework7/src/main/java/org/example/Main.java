package org.example;

import org.example.Humans.Man;
import org.example.Humans.Woman;
import Pets.Dog;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.text.StyleConstants.Family;

public class Main {

    public static void main(String[] args) {

        Pet dogMax = new Dog("Max", 2, 45, new String[]{"eating", "playing with bone"});
        dogMax.respond();

        Man fatherJohn = new Man("John", "Maxwell", 1973, 98);

        Woman motherJane = new Woman("Jane", "Maxwell", 1977, 96);

        Family maxwellFamily = new Family(motherJane, fatherJohn);

        maxwellFamily.setPet(dogMax);

        //advanced complexity implemented
        motherJane.bornChild(maxwellFamily, fatherJohn);

        System.out.println(maxwellFamily);


    }
}