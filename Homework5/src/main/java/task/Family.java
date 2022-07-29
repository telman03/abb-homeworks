package task;

import java.util.Arrays;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Family(Human mother, Human father, Human[] children, Pet pet) {
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.pet = pet;
        father.setFamily(this);
        mother.setFamily(this);
    }


    @Override
    public String toString() {
        if (getPet() == null && getChildren().length == 0) {
            return "Family{" + "mother=" + mother.getName() + " " + mother.getSurname() + ", father=" + father.getName() + " " + father.getSurname() + '}';
        } else if (getPet() != null && getChildren().length == 0) {
            return "Family{" + "mother=" + mother.getName() + " " + mother.getSurname() + ", father=" + father.getName() + " " + father.getSurname() + ", pet=" + pet + '}';
        } else if (getPet() == null && getChildren().length != 0) {
            return "Family{" + "mother=" + mother.getName() + " " + mother.getSurname() + ", father=" + father.getName() + " " + father.getSurname() + ", children=" + Arrays.toString(children) + '}';
        }
        return "Family{" + "mother=" + mother.getName() + " " + mother.getSurname() + ", father=" + father.getName() + " " + father.getSurname() + ", children=" + Arrays.toString(children) + ", pet=" + pet + '}';
    }

    @Override
    public boolean equals(Object x) {
        if (x == null) return false;
        if (!(x instanceof Family family)) return false;
        if (x == this) return true;

        return mother.equals(family.mother) && father.equals(family.father);
    }


    /** Add Child */
    public void addChild(Human child) {
        Human[] children = new Human[getChildren().length + 1];
        for (int i = 0; i < getChildren().length; i++) {
            children[i] = getChildren()[i];
        }
        children[children.length - 1] = child;
        setChildren(children);
        child.setFamily(this);
    }


    /** Count Family */
    public int countFamily() {
        return 2 + getChildren().length;
    }

    /** Describe Pet */
    public void describePet() {
        String slyLevel = "";
        if (getPet().getTrickLevel() >= 50) {
            slyLevel = "he is very sly";
        } else {
            slyLevel = "almost not sly";
        }
        System.out.println("I have a " + getPet().getSpecies() + ", he is " + getPet().getAge() + " years old, " + slyLevel);
    }

    /** Greet Pet */
    public void greetPet() {
        System.out.println("Hello," + getPet().getnickName());
    }

    /** Feed Pet */
    public void feedPet(boolean feedTime) {
        if (feedTime) {
            System.out.println("Hm... I will feed " + getPet().getnickName());
        } else {
            System.out.println("I think " + getPet().getnickName() + " is not hungry.");
        }
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
