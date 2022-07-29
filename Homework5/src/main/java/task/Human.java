package task;

public class Human {
    private String name;
    private String surname;
    private int year;
    private Human mother;
    private Human father;
    private int iq;
    private Pet pet;
    private String[][] schedule;
    private Family family;

    public Human(String name, String surname, int year, Human mother, Human father, int iq, Pet pet, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
        this.iq = iq;
        this.pet = pet;
        this.schedule = schedule;
    }



    //overriding toString
    @Override
    public String toString() {
        return "Human{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", year=" + year +
                ", mother=" + mother.name + " " + mother.surname +
                ", father=" + father.name + " " + father.surname +
                ", iq=" + iq +
                ", pet=" + pet +
                '}';
    }

    public Human() {
    }

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    public void greetPet() {
        System.out.println("Hello," + pet.getnickName());
    }

    public void describePet() {
        String slyLevel = "";
        if (pet.getTrickLevel() >= 50) {
            slyLevel = "he is very sly";
        } else {
            slyLevel = "almost not sly";
        }
        System.out.println("I have a " + pet.getSpecies() + ", he is " + pet.getAge() + " years old, " + slyLevel);
    }

    public void feedPet(boolean feedTime) {
        if (feedTime) {
            System.out.println("Hm... I will feed " + pet.getnickName());
        } else {
            System.out.println("I think " + pet.getnickName() + " is not hungry.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
