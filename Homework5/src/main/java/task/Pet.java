package task;

import java.util.Arrays;
import java.util.Scanner;

public class Pet {
    private String species;
    private String nickName;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Pet(String species, String nickName, int age, int trickLevel, String[] habits) {
        this.setSpecies(species);
        this.setNickName(nickName);
        this.setAge(age);
        if (trickLevel < 1 || trickLevel > 100) {
            System.out.println("Trick-level must be between 1-100");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Redefine trick level in 1-100 please: ");
            trickLevel = scanner.nextInt();
            this.setTrickLevel(trickLevel);
        } else {
            this.setTrickLevel(trickLevel);
        }
        this.setHabits(habits);
    }

    public Pet() {
    }

    public Pet(String species, String nickName) {
        this.species = species;
        this.nickName = nickName;
    }

    public void eat() {
        System.out.println("I am eating.");
    }

    public void respond() {
        System.out.println("Hello, owner. I am " + this.getnickName() + ". I miss you!");
    }

    public void foul() {
        System.out.println("I need to cover it up");
    }

    @Override
    public String toString() {
        return this.getSpecies() + "{" +
                "nickName='" + getnickName() + '\'' +
                ", age=" + getAge() +
                ", trickLevel=" + getTrickLevel() +
                ", habits=" + Arrays.toString(getHabits()) +
                '}';
    }

    @Override
    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (!(x instanceof Pet)) return false;

        Pet pet = (Pet) x;
        return this.nickName.equals(pet.nickName) && this.species.equals(pet.species) && this.age == pet.age && this.trickLevel == pet.trickLevel;
    }


    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getnickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }
}
