package task;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Pet pet = new Pet();
        pet.setSpecies("dog");
        pet.setNickName("Rock");
        pet.setAge(5);
        pet.setTrickLevel(75);
        pet.setHabits(new String[]{"eat", "drink", "sleep"});

        Human father = new Human("Vito", "Karleone" );
        Human mother = new Human("Jane", "Karleone");

        Human child = new Human("Michel", "Karleone", 1996, mother, father,88, pet, new String[][]{{"monday, go to gym"}}
        );


        }
    }
