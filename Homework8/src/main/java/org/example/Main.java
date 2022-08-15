package org.example;

import org.example.Humans.Man;
import org.example.Humans.Woman;
import org.example.Pets.Dog;

import java.util.HashSet;
import java.util.Set;


public class Main {

    public static void main(String[] args) {

        Set<String> habits = new HashSet<>();
        habits.add("playing with bone");
        habits.add("sleeping");

        Pet dogRock= new Dog("Rock", 3, 45, habits);
        dogRock.respond();

        Man fatherJohn = new Man("Vito", "Karleone", 1973, 88);

        Woman motherJane = new Woman("Jane", "Karleone", 1975, 96);

        Family rocksFamily = new Family(fatherJohn, motherJane);

        rocksFamily.setPet(dogRock);


        System.out.println(rocksFamily);


    }
}