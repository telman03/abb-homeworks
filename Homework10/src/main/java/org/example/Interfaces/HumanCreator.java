package org.example.Interfaces;

import org.example.Family;
import org.example.Human;

import java.text.ParseException;

public interface HumanCreator {
    Human bornChild(Family family, Human father) throws ParseException;
}
