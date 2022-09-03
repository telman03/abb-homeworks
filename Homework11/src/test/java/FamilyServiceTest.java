import org.example.DAO.Implementation.FamilyCollectionDao;
import org.example.Family;
import org.example.Abstracts.*;
import org.example.Human;
import org.example.Humans.*;
import org.example.DAO.*;
import org.example.Pets.*;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FamilyServiceTest {
    private FamilyService service;
    private Man father;
    private Woman mother;
    private Family family;

    @BeforeEach
    void setUp() throws ParseException{
        FamilyDao dao = new FamilyCollectionDao();
        service = new FamilyService(dao);

        father = new Man("Vito", "Karleone", "1/12/1973", 88);
        mother = new Woman("Jane", "Karleone", "23/2/1975", 96);
    }
    @Test
    void creatingNewFamilyTest(){
        family = service.createNewFamily(mother, father);
        assertEquals(1, service.count());
    }
    @Test
    void deletingFamilyTest() {
        family = service.createNewFamily(mother, father);
        service.deleteFamilyByIndex(0);
        assertEquals(0, service.count());
    }

    @Test
    void bornChildTest() throws ParseException {
        family = service.createNewFamily(mother, father);
        service.bornChild(family);
        assertEquals(1, service.getFamilyById(0).getChildren().size());
    }

    void deleteChildOlderThan() throws ParseException {
        Human child = new Man("Child", "Adopt", "12/05/2010", 99);
        family = service.createNewFamily(mother, father);
        service.adoptChild(child, family);
        service.deleteAllChildrenOlderThan(10);
        assertEquals(0, service.getFamilyById(0).getChildren().size());
    }

    @Test
    void getFamiliesLessThanFourTest() throws ParseException {
        family = service.createNewFamily(mother, father);
        service.bornChild(family);
        assertEquals(1, service.getFamiliesLessThan(4).size());
    }

    @Test
    void getFamiliesBiggerThanTwoTest() throws ParseException {
        family = service.createNewFamily(mother, father);
        service.bornChild(family);
        assertEquals(1, service.getFamiliesBiggerThan(2).size());
    }

    @Test
    void addingPetToFamilyTest() {
        Set<String> habits = new HashSet<>();
        habits.add("eating");
        habits.add("sleeping");
        Pet dogMax = new Dog("Rock", 2, 45, habits);
        family = service.createNewFamily(mother, father);
        service.addPet(family, dogMax);
        assertEquals(1, service.getPets(family).size());
    }

    @Test
    void countingFamiliesTest() {
        family = service.createNewFamily(mother, father);
        assertEquals(1, service.count());
    }

    @Test
    void countingFamiliesWithSameMembers() {
        Family family1 = service.createNewFamily(mother, father);
        family = service.createNewFamily(mother, father);
        assertEquals(1, service.count());
    }


}
