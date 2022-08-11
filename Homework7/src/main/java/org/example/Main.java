package org.example;

import org.example.Humans.Man;
import org.example.Humans.Woman;
import org.example.Pets.Dog;
import org.example.Pets.Dog;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        Pet dogRock= new Dog("Max", 2, 45, new String[]{"eating", "playing with bone"});
        dogRock.respond();

        Man fatherJohn = new Man("Vito", "Karleone", 1973, 88);

        Woman motherJane = new Woman("Jane", "Karleone", 1975, 96);

        Family rocksFamily = new Family(fatherJohn, motherJane);

        rocksFamily.setPet(dogRock);


        System.out.println(rocksFamily);


    }
}