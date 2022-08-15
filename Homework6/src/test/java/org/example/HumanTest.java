package org.example;


import org.junit.jupiter.api.Test;
import task.Human;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    private final Human human = new Human("Micheal", "Karleone", 1999);

    @Test
    void testEquality() {
        Human human1 = new Human("Micheal", "Karleone", 1999);
        assertEquals(human, human1);
    }

    @Test
    void testNonEquality() {
        Human human1 = new Human("Jane", "Karleone", 1975);
        assertNotEquals(human, human1);
    }

}
