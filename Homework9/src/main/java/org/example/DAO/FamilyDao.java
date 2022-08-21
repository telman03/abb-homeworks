package org.example.DAO;

import org.example.Family;

import java.util.List;

public interface FamilyDao {

    List<Family> getAllFamilies();

    Family getFamilyByIndex(int index);

    boolean deleteFamily(int index);

    void saveFamily(Family f);
}