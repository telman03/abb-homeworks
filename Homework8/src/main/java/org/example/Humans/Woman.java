package org.example.Humans;

import org.example.Enums.DayOfWeek;
import org.example.Family;
import org.example.Human;
import org.example.Interfaces.HumanCreator;

import java.util.Map;

public final class Woman extends Human implements HumanCreator {
    public Woman() {
        super.setSchedule(super.getSchedule());
    }

    public Woman(String name, String surname, int year, int iq, Map<DayOfWeek, String> schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    public Woman(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
        super.setSchedule(super.getSchedule());
    }

    @Override
    public void greetPet() {
        System.out.println("Hello from Ms." + this.getSurname());
    }

    public void cookingCake() {
        System.out.println("I'm cooking cake for my guests");
    }
}