package org.example;

import org.junit.jupiter.api.Test;
import task.Family;
import task.Human;
import task.Pet;
import task.Species;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    Pet dog = new Pet(Species.DOG, "Max", 2, 45, new String[]{"drinking", "playing with bone"});
    Human mother = new Human("Jane", "Karleone", 1975);
    Human father = new Human("Vito", "Karleone", 1973);
    Family michaelsFamily = new Family(mother, father);
    Human child1 = new Human("Micheal", "Karleone", 1999, 92,
            new String[][]{{DayOfWeek.MONDAY.name(), "go to gym"}}, michaelsFamily
    );

    Human[] setChild() {
        michaelsFamily.addChild(child1);
        return michaelsFamily.getChildren();
    }


    @Test
    void testEqualityWithoutChild() {
        Human mother = new Human("Jane", "Karleone", 1975);
        Human father = new Human("Vito", "Karleone", 1973);
        Family testFamily = new Family(mother, father);
        assertEquals(michaelsFamily, testFamily);

    }

    @Test
    void testNonEqualityWithoutChild() {
        Human mother = new Human("Jane", "Lesley", 1977);
        Human father = new Human("John", "Lesley", 1973);
        Family testFamily = new Family(mother, father);
        assertNotEquals(michaelsFamily, testFamily);
    }


    @Test
    void testCountOfFamilyMembers() {
        setChild();
        assertEquals(3, michaelsFamily.countFamily());
    }

    @Test
    void testDeletingChildByIndex() {
        setChild();
        michaelsFamily.deleteChild(0);
        assertEquals(0, this.michaelsFamily.getChildren().length);
    }

    @Test
    void deletingChildByFalseIndex() {
        setChild();
        michaelsFamily.deleteChild(2);
        assertEquals(1, this.michaelsFamily.getChildren().length);
    }

    @Test
    void deletingChildByReference() {
        setChild();
        michaelsFamily.deleteChild(this.child1);
        assertEquals(0,this.michaelsFamily.getChildren().length);
    }

    @Test
    void deletingChildByFalseReference() {
        setChild();
        Human child2 = new Human("Sony", "Karleone", 1990, 90,
                new String[][]{{DayOfWeek.MONDAY.name(), "go to course"}}, michaelsFamily
        );
        michaelsFamily.deleteChild(child2);
        assertEquals(1, this.michaelsFamily.getChildren().length);
    }

}