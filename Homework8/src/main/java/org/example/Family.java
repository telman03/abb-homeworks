package org.example;

import org.example.Humans.Woman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Pet pet;

    public Family(Human mother, Woman father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.pet = getPet();
        father.setFamily(this);
        mother.setFamily(this);
    }

    public void addChild(Human child) {
        if (child != null) {
            Human[] children = new Human[getChildren().size() + 1];
            for (int i = 0; i < getChildren().size(); i++) {
                children[i] = getChildren().get(i);
            }
            children[children.length - 1] = child;
            setChildren(children);
            child.setFamily(this);
        } else {
            getChildren();
        }
    }

    public void deleteChild(int index) {
        if (index > getChildren().size() - 1) {
            getChildren();
        } else {
            Human[] children = new Human[getChildren().size() - 1];
            if (children.length == 0) {
                children = new Human[0];
            } else {
                for (int i = 0, j = 0; i < getChildren().size(); i++) {
                    if (i == index) continue;
                    children[j++] = getChildren().get(i);
                }
            }
            setChildren(children);
        }
    }

    public int countFamily() {
        return 2 + getChildren().size();
    }

    //Advanced complexity implementation -- deleting child
    public void deleteChild(Human child) {
        if (child != null) {
            for (int i = 0; i < getChildren().size(); i++) {
                if (child.equals(getChildren().get(i))) {
                    Human[] children = new Human[getChildren().size() - 1];
                    for (int k = 0, j = 0; k < getChildren().size(); k++) {
                        if (getChildren().get(k).getName().equals(child.getName())) continue;
                        children[j++] = getChildren().get(k);
                    }
                    setChildren(children);
                } else {
                    getChildren();
                }
            }
        } else {
            getChildren();
        }
    }

    public void describePet() {
        String slyLevel = "";
        if (getPet().getTrickLevel() >= 50) {
            slyLevel = "he is very sly";
        } else {
            slyLevel = "almost not sly";
        }
        System.out.println("I have a " + getPet().getSpecies() + ", he is " + getPet().getAge() + " years old, " + slyLevel);
    }

    public void greetPet() {
        System.out.println("Hello," + getPet().getNickName());
    }

    public void feedPet(boolean feedTime) {
        if (feedTime) {
            System.out.println("Hm... I will feed " + getPet().getNickName());
        } else {
            System.out.println("I think " + getPet().getNickName() + " is not hungry.");
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

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = List.of(children);
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        if (getPet() == null && getChildren().size() == 0) {
            return "Family{" +
                    "mother=" + mother.getName() + " " + mother.getSurname() +
                    ", father=" + father.getName() + " " + father.getSurname() +
                    '}';
        } else if (getPet() != null && getChildren().size() == 0) {
            return "Family{" +
                    "mother=" + mother.getName() + " " + mother.getSurname() +
                    ", father=" + father.getName() + " " + father.getSurname() +
                    ",\n pet=" + pet +
                    '}';
        } else if (getPet() == null && getChildren().size() != 0) {
            return "Family{" +
                    "mother=" + mother.getName() + " " + mother.getSurname() +
                    ", father=" + father.getName() + " " + father.getSurname() +
                    ",\n children=" + Arrays.toString(new List[]{children}) +
                    '}';
        }
        return "Family{" +
                "mother=" + mother.getName() + " " + mother.getSurname() +
                ", father=" + father.getName() + " " + father.getSurname() +
                ",\n children=" + Arrays.toString(new List[]{children}) +
                ",\n pet=" + pet +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Family)) return false;
        if (obj == this) return true;

        Family family = (Family) obj;
        return mother.equals(family.mother) && father.equals(family.father) &&
                children.equals(family.getChildren());
    }

    @Override
    protected void finalize() {
        System.out.println(this + " object collected by Garbage Collector");
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMother(), getFather(), getChildren());
    }
}