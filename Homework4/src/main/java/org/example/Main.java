package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {

    static class Pet {
        String species;
        String nickName;
        int age;
        int trickLevel;
        String[] habits;


        public Pet(String species, String nickName, int age, int trickLevel, String[] habits) {
            this.species = species;
            this.nickName = nickName;
            this.age = age;
            this.trickLevel = trickLevel;
            this.habits = habits;
        }

        // empty constructor
        public Pet() {

        }

        // constructor with species and nickname
        public Pet(String species, String nickName) {
            this.species = species;
            this.nickName = nickName;
        }

        public void eat() {
            System.out.println("I am eating.");
        }

        public void respond() {
            System.out.println("Hello, owner. I am " + this.nickName + ". I miss you!");
        }

        public void foul() {
            System.out.println("I need to cover it up");
        }

        //overriding toString
        @Override
        public String toString() {
            return this.species + "{" + "nickName='" + nickName + '\'' + ", age=" + age + ", trickLevel=" + trickLevel + ", habits=" + Arrays.toString(habits) +'}';
        }

        static class Human {
            String name;
            String surname;
            int year;
            Human mother;
            Human father;
            int iq;
            Pet pet;
            String[][] schedule;

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
                System.out.println("Hello," + pet.nickName);
            }

            public void describePet() {
                String slyLevel = "";
                if (pet.trickLevel >= 50) {
                    slyLevel = "he is very sly";
                } else {
                    slyLevel = "almost not sly";
                }
                System.out.println("I have a " + pet.species + ", he is " + pet.age + " years old, " + slyLevel);
            }

            public void feedPet(boolean feedTime) {
                if (feedTime) {
                    System.out.println("Hm... I will feed " + pet.nickName);
                } else {
                    System.out.println("I think " + pet.nickName + " is not hungry.");
                }
            }
        }

        public static void main(String[] args) {
            Pet pet = new Pet();
            pet.species = "dog";
            pet.nickName = "Rock";
            pet.age = 5;
            pet.trickLevel = 75;
            pet.habits = new String[]{"eat", "drink", "sleep"};

            Human father = new Human("Vito", "Karleone" );
            Human mother = new Human("Jane", "Karleone");

            Human child = new Human("Michel", "Karleone", 1996, mother, father,88, pet, new String[][]{{"monday, go to gym"}}
            );


            child.greetPet();
            child.describePet();
            pet.respond();



            Random random = new Random();
            int generatedNumber = random.nextInt(101);
            boolean feedTime;

            feedTime = pet.trickLevel >= generatedNumber;
            child.feedPet(feedTime);


            pet.eat();
            System.out.println(child);
        }
    }

}