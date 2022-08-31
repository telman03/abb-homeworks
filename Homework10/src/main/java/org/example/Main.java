package org.example;

import org.example.Abstracts.Pet;
import org.example.DAO.FamilyDao;
import org.example.DAO.FamilyService;
import org.example.DAO.FamilyController;
import org.example.Humans.Man;
import org.example.Humans.Woman;
import org.example.Pets.Dog;
import org.example.DAO.Implementation.FamilyCollectionDao;

import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {

        FamilyController controller = config();

        Set<String> habits = new HashSet<>();
        habits.add("eating");
        habits.add("sleeping");

        Pet dogRock= new Dog("Rock", 3, 45, habits);

        Man fatherJohn = new Man("Vito", "Karleone", "1/12/1973", 88);

        Woman motherJane = new Woman("Jane", "Karleone", "23/2/1975", 96);


        Man father = new Man("Father", "Father","10/12/1983" , 99);
        Woman mother = new Woman("Mother", "Mother", "15/02/1993", 98);


        Family rocksFamily = controller.createNewFamily(motherJane, fatherJohn);

        controller.addPet(rocksFamily, dogRock);
        controller.bornChild(rocksFamily);
        controller.bornChild(rocksFamily);



        System.out.println("\nCount families with 5 member: " + controller.countFamiliesWithMemberNumber(12));

        System.out.println("\nBigger than 3");
        controller.getFamiliesBiggerThan(3).forEach(System.out::println);

        System.out.println("\nLess than 3");
        controller.getFamiliesLessThan(4).forEach(System.out::println);

        System.out.println("\nPets of maxwell family");
        controller.getPets(rocksFamily).forEach(System.out::println);

        System.out.println("\nDeleting children older than 15");
        controller.deleteAllChildrenOlderThan(15);

        System.out.println("\nGet family by id :\n" + controller.getFamilyById(0));

        System.out.println("Describing age of father John");
        fatherJohn.describeAge();


        System.out.println("\nDelete family by index");
        controller.deleteFamilyByIndex(1);

        System.out.println("\nDisplaying all families from database");
        controller.displayAllFamilies();
        System.out.println(controller.count());
    }




    private static FamilyController config() {
        FamilyDao dao = new FamilyCollectionDao();
        FamilyService service = new FamilyService(dao);
        return new FamilyController(service);
    }
}
