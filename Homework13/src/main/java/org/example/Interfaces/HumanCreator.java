package org.example.Interfaces;

import org.example.Model.Family;
import org.example.Model.Human;

import java.text.ParseException;

public interface HumanCreator {
    Human bornChild(Family family, Human father) throws ParseException;
}
