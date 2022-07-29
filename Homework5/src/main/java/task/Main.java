package task;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Human father = new Human("Vito", "Karleone" );
        Human mother = new Human("Jane", "Karleone");


        Pet pet = new Pet("dog", "Roxy", 3, 80, new String[]{"eat", "drink"});

        Family roxyFamily = new Family(father, mother);


        Human child1 = new Human("Frederico", "Karleone", 1976,mother, father,  68 , pet, new String[][]{{"monday, go to gym"}}, roxyFamily);

        Human child2 = new Human("Santino", "Karleone", 1975, mother, father,  77 , pet, new String[][]{{"monday, go to gym"}}, roxyFamily);

        Human child3 = new Human("Micheal", "Karleone", 1977, mother, father,88, pet, new String[][]{{"monday, go to gym"}}, roxyFamily);


        //set the pet
        roxyFamily.setPet(pet);

        //adding child1, child2 and child3
        roxyFamily.addChild(child1);
        roxyFamily.addChild(child2);
        roxyFamily.addChild(child3);


        }
    }
