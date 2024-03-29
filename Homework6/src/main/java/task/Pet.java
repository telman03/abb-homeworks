package task;


import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Pet {
    private Species species;
    private String nickName;
    private int age;
    private int trickLevel;
    private String[] habits;


    //overriding toString
    @Override
    public String toString() {
        return this.getSpecies().name() + getSpecies().toString() + "{" +
                "nickName='" + getNickName() + '\'' +
                ", age=" + getAge() +
                ", trickLevel=" + getTrickLevel() +
                ", habits=" + Arrays.toString(getHabits()) +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Pet)) return false;

        Pet pet = (Pet) obj;
        return this.nickName.equals(pet.nickName) &&
                this.species.equals(pet.species) &&
                this.age == pet.age &&
                this.trickLevel == pet.trickLevel;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.nickName + " object collected by Garbage Collector");
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(species, nickName, age, trickLevel);
        result = 31 * result + Arrays.hashCode(habits);
        return result;
    }

    //empty constructor
    public Pet() {

    }

    // constructor with species and nickname
    public Pet(Species species, String nickName) {
        this.setSpecies(species);
        this.setNickName(nickName);
    }

    // constructor with all fields
    public Pet(Species species, String nickName, int age, int trickLevel, String[] habits) {
        this.setSpecies(species);
        this.setNickName(nickName);
        this.setAge(age);
        if (trickLevel < 1 || trickLevel > 100) {
            System.out.println("Trick level must be between 1-100");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Redefine trick level in 1-100 please: ");
            trickLevel = scanner.nextInt();
            this.setTrickLevel(trickLevel);
        } else {
            this.setTrickLevel(trickLevel);
        }
        this.setHabits(habits);
    }

    public void eat() {
        System.out.println("I am eating.");
    }

    public void respond() {
        System.out.println("Hello, owner. I am " + this.getNickName() + ". I miss you!");
    }

    public void foul() {
        System.out.println("I need to cover it up");
    }

    public Species getSpecies() {
        return Species.valueOf(species.name());
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickName() {
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
