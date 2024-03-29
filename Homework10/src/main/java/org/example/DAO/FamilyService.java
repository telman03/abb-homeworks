package org.example.DAO;

import org.example.Family;
import org.example.Human;
import org.example.Abstracts.Pet;
import org.example.Humans.Man;
import org.example.Humans.Woman;

import java.text.ParseException;
import java.util.*;

public class FamilyService {
    private final FamilyDao dao;

    public FamilyService(FamilyDao dao) {
        this.dao = dao;
    }

    public List<Family> getAllFamilies() {
        return dao.getAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return getAllFamilies().stream()
                .filter(x -> x.countFamily() > count)
                .toList();
    }

    public int countFamiliesWithMemberNumber(int number) {
        int[] count = {0};
        getAllFamilies().forEach(x -> {
            if (x.countFamily() == number) {
                count[0]++;
            }
        });
        return count[0];
    }

    public List<Family> getFamiliesLessThan(int count) {
        return getAllFamilies().stream()
                .filter(x -> x.countFamily() < count)
                .toList();
    }

    public void displayAllFamilies() {
        int[] count = {1};
        getAllFamilies().stream()
                .map(x -> (count[0]++) + "." + x)
                .forEach(System.out::println);
    }

    public Family createNewFamily(Woman mother, Man father) {
        Family family = new Family(mother, father);
        dao.saveFamily(family);
        return family;
    }

    public void deleteFamilyByIndex(int index) {
        if (dao.deleteFamily(index)) System.out.println("Deleted");
        else System.out.println("Family not exist");
    }


    public Family bornChild(Family family) throws ParseException {
        Random ry = new Random();
        int y = ry.nextInt(20) + 1;
        Human child = genderSetter();
        family.addChild(child);
        child.setFamily(family);
        child.setName(randomName(child));
        child.setSurname(family.getFather().getSurname());
        if (family.getChildren().size() == 1 && family.getFather().getSurname().equals("Rock")) {
            child.setBirthDate("2/02/1999");
        } else {
            if (y >= 10) {
                child.setBirthDate("1/02/20" + y);
            } else {
                child.setBirthDate("1/01/200" + y);
            }
        }
        int averageIq = (family.getFather().getIq() + family.getMother().getIq()) / 2;
        child.setIq(averageIq);
        dao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Human child, Family family) {
        family.addChild(child);
        child.setFamily(family);
        dao.saveFamily(family);
        return family;
    }

    //implemented for define gender of child
    private Human genderSetter() {
        Random random = new Random();
        List<Human> gender = new ArrayList<>();
        gender.add(new Man());
        gender.add(new Woman());
        int i = random.nextInt(2);
        return gender.get(i);
    }

    //implemented for generate random name belong to gender
    private String randomName(Human child) {
        List<String> nameMan = List.of("Braydon", "Davon", "Bill", "Cristiano", "John", "Ben", "Tom", "Tim", "Alex", "Max");
        List<String> nameWoman = List.of("Mariam", "Lisa", "Alice", "Emily", "Emma", "Sabina", "Leyla", "Isabella", "Orla", "Beatrice");
        Random rd = new Random();
        int i = rd.nextInt(10);
        if (child instanceof Man) return nameMan.get(i);
        else return nameWoman.get(i);
    }

    public void deleteAllChildrenOlderThan(int age) {
        getAllFamilies().forEach(x -> {
            List<Human> list = x.getChildren();
            Iterator<Human> it = list.iterator();
            while (it.hasNext()) {
                int itAge = it.next().getAge();
                if (itAge > age) it.remove();
            }
            dao.saveFamily(x);
        });

    }

    public int count() {
        return getAllFamilies().size();
    }

    public Family getFamilyById(int id) {
        return dao.getFamilyByIndex(id);
    }

    public List<Pet> getPets(Family family) {
        List<Pet> pets = new ArrayList<>();
        getAllFamilies().forEach(x -> {
            if (x.equals(family)) {
                pets.addAll(family.getPet());
            }
        });
        return pets;
    }

    public void addPet(Family f, Pet pet) {
        getAllFamilies().forEach(x -> {
            f.setPet(pet);
            dao.saveFamily(x);
        });
    }


}
