package org.example;

public class Main {
    String species;
    String nickname;
    int age;
    int trickLevel;
    String[] habits = {};

    // Constructor Declaration of Class
    public Main(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
    }


    // gets nickname
    public String getNickname(){
        return nickname;
    }

    public String getEat(){
        return "I am eating";
    }
    public String getRespond() {
        return ("Hello, owner. I`am -" + this.getNickname() + ".I miss you!");
    }
    public String getFoul(){
        return "I need to cover it up";
    }




    public static void main(String[] args) {

    }


}
