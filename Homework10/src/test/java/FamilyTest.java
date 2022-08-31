import org.example.Family;
import org.example.Human;
import org.example.Humans.Man;
import org.example.Humans.Woman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FamilyTest {
    private Family rocksFamily;
    private Human child1;
    private Woman mother;
    private Man father;

    @BeforeEach
    void set() throws ParseException {
        Man father = new Man("Vito", "Karleone", "1/12/1973", 88);

        Woman mother = new Woman("Jane", "Karleone", "23/2/1975", 96);
        rocksFamily = new Family(mother, father);
    }

    List<Human> setChild() throws ParseException {
        child1 = mother.bornChild(rocksFamily, father);
        return rocksFamily.getChildren();
    }


    @Test
    void testEqualityWithoutChild() throws ParseException {
        Woman mother = new Woman("Jane", "Karleone", "23/2/1975", 96);
        Man father = new Man("Vito", "Karleone", "1/12/1973", 88);
        Family testFamily = new Family(mother, father);
        assertEquals(rocksFamily, testFamily);

    }

    @Test
    void testNonEqualityWithoutChild() throws ParseException {
        Woman mother = new Woman("Jane", "Billy", "12/05/1977", 94);
        Man father = new Man("John", "Billy", "12/05/1973", 99);
        Family testFamily = new Family(mother, father);
        assertNotEquals(rocksFamily, testFamily);
    }

    @Test
    void testEqualityWithChild() throws ParseException {
        Woman mother = new Woman("Jane", "Karleone", "23/2/1975", 96);
        Man father = new Man("Vito", "Karleone", "1/12/1973", 88);

        Family testFamily = new Family(mother, father);
        testFamily.addChild(child1);
        assertEquals(rocksFamily, testFamily);
    }

    @Test
    void testNonEqualityWithChild() throws ParseException {
        Woman mother = new Woman("Jane", "Karleone", "23/2/1975", 96);
        Man father = new Man("Vito", "Karleone", "1/12/1973", 88);

        Family testFamily = new Family(mother, father);
        mother.bornChild(testFamily, father);
        assertNotEquals(rocksFamily, testFamily);
    }

    @Test
    void testCountOfFamilyMembers() throws ParseException {
        setChild();
        assertEquals(2, rocksFamily.countFamily());
    }

    @Test
    void testDeletingChildByIndex() throws ParseException {
        setChild();
        rocksFamily.deleteChildByIndex(0);
        assertEquals(0, this.rocksFamily.getChildren().size());
    }

    @Test
    void deletingChildByFalseIndex() throws ParseException {
        setChild();
        rocksFamily.deleteChildByIndex(2);
        assertEquals(1, this.rocksFamily.getChildren().size());
    }

    @Test
    void deletingChildByReference() throws ParseException {
        setChild();
        rocksFamily.deleteChildByReference(this.child1);
        assertEquals(0, this.rocksFamily.getChildren().size());
    }

    @Test
    void deletingChildByFalseReference() throws ParseException {
        setChild();
        Human child2 = new Human("Name", "Surname", "12/05/2002", 98);
        rocksFamily.deleteChildByReference(child2);
        assertEquals(1, this.rocksFamily.getChildren().size());
    }

    @Test
    void testBornChild() throws ParseException {
        setChild();
        assertEquals(1, rocksFamily.getChildren().size());
    }
}