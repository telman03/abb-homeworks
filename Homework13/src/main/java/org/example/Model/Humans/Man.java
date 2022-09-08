package org.example.Model.Humans;

import org.example.Model.Family;
import org.example.Model.Human;
import org.example.Model.Enums.DayOfWeek;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Map;

public final class Man extends Human implements Serializable {
    private static final long serialVersionID = 1L;
    public Man() {
        super.setSchedule(super.getSchedule());
    }

    public Man(String name, String surname, String birthDate, int iq, Map<DayOfWeek, String> schedule, Family family) throws ParseException {
        super(name, surname, birthDate, iq, schedule, family);
    }

    public Man(String name, String surname, String  birthDate, int iq) throws ParseException {
        super(name, surname, birthDate, iq);
    }

    @Override
    public void greetPet() {
        System.out.println("Hello from Mr." + this.getName());
    }

    public void playingFootball() {
        System.out.println("I will play football with my friends");
    }
}
