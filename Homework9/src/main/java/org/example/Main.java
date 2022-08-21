package org.example;

import org.example.DAO.FamilyController;
import org.example.DAO.FamilyDao;
import org.example.DAO.FamilyService;
import org.example.DAO.Implementation.CollectionFamilyDao;
import org.example.Humans.Man;
import org.example.Humans.Woman;
import org.example.Pets.Dog;

import java.util.HashSet;
import java.util.Set;


public class Main {

    public static void main(String[] args) {
        FamilyController controller = config();


        Set<String> habits = new HashSet<>();
        habits.add("playing with bone");
        habits.add("sleeping");

        Pet dogRock= new Dog("Rock", 3, 45, habits);
        dogRock.respond();

        Man fatherJohn = new Man("Vito", "Karleone", 1973, 88);

        Woman motherJane = new Woman("Jane", "Karleone", 1975, 96);

        Family rocksFamily = new Family(fatherJohn, motherJane);

        rocksFamily.setPet(dogRock);



        controller.addPet(rocksFamily, dogRock);
        controller.bornChild(rocksFamily);
        controller.bornChild(rocksFamily);
        controller.bornChild(rocksFamily);


    }
    private static FamilyController config() {
        FamilyDao dao = new CollectionFamilyDao();
        FamilyService service = new FamilyService(dao);
        return new FamilyController(service);
    }
}