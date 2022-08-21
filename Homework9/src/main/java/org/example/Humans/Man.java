package org.example.Humans;

import org.example.Enums.DayOfWeek;
import org.example.Family;
import org.example.Human;

import java.util.Map;


public final class Man extends Human {
    public Man() {
        super.setSchedule(super.getSchedule());
    }

    public Man(String name, String surname, int year, int iq, Map<DayOfWeek, String> schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    public Man(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }
    @Override
    public void greetPet() {
        System.out.println("Hello from Mr." + this.getName());
    }

    public void playingFootball() {
        System.out.println("I will play football with my friends");
    }
}