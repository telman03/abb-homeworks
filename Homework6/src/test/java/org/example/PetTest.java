package org.example;


import org.junit.jupiter.api.Test;
import task.Pet;
import task.Species;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {
    private final Pet pet = new Pet(Species.DOG, "Rock");

    @Test
    void testEquality() {
        Pet pet1 = new Pet(Species.DOG, "Rock");
        assertEquals(pet, pet1);
    }

    @Test
    void testNonEquality() {
        Pet pet1 = new Pet(Species.DOG, "Tom");
        assertNotEquals(pet, pet1);
    }

}
