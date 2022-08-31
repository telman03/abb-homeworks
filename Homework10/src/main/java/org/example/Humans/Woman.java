package org.example.Humans;

import org.example.Family;
import org.example.Human;
import org.example.Enums.DayOfWeek;
import org.example.Interfaces.HumanCreator;

import java.text.ParseException;
import java.util.Map;

public final class Woman extends Human implements HumanCreator {
    public Woman() {
        super.setSchedule(super.getSchedule());
    }

    public Woman(String name, String surname, String birthDate, int iq, Map<DayOfWeek, String> schedule, Family family) throws ParseException {
        super(name, surname, birthDate, iq, schedule, family);
    }

    public Woman(String name, String surname, String birthDate, int iq) throws ParseException {
        super(name, surname, birthDate, iq);
        super.setSchedule(super.getSchedule());
    }

    @Override
    public void greetPet() {
        System.out.println("Hello from Ms." + this.getSurname());
    }

    public void cookingCake() {
        System.out.println("I'm cooking cake for my guests");
    }


    @Override
    public Human bornChild(Family family, Human father) throws ParseException {
        return null;
    }
}
