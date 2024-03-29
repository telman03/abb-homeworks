package org.example.DAO;

import org.example.Family;
import org.example.Human;
import org.example.Humans.Man;
import org.example.Humans.Woman;
import org.example.Pet;

import java.time.LocalDate;
import java.util.*;

public class FamilyService {
    private final FamilyDao dao ;

    public FamilyService(FamilyDao dao) {
        this.dao = dao;
    }

    public List<Family> getAllFamilies() {
        return dao.getAllFamilies();
    }

    public void displayAllFamilies() {
        int[] count = {1};
        getAllFamilies().stream()
                .map(x -> (count[0]++) + "." + x)
                .forEach(System.out::println);
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return getAllFamilies().stream()
                .filter(x -> x.countFamily() > count)
                .toList();
    }

    public List<Family> getFamiliesLessThan(int count) {
        return getAllFamilies().stream()
                .filter(x -> x.countFamily() < count)
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

    public Family createNewFamily(Woman mother, Man father) {
        Family family = new Family(mother, father);
        dao.saveFamily(family);
        return family;
    }

    public void deleteFamilyByIndex(int index) {
        if (dao.deleteFamily(index)) System.out.println("Deleted");
        else System.out.println("Family not exist");
    }


    public Family bornChild(Family family) {
        Random rnd = new Random();
        int y = rnd.nextInt(10) + 1;
        Human child = genderSetter();
        family.addChild(child);
        child.setFamily(family);
        child.setName(randomName(child));
        child.setSurname(family.getFather().getSurname());
        if (family.getChildren().size() == 1) {
            child.setYear(2002);
        } else {
            child.setYear(2002 + y);
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
        List<String> nameMan = List.of("Barny", "Bill", "Jeff", "Messi", "Neymar", "Ben", "Tom", "Tim", "Alex", "Max");
        List<String> nameWoman = List.of("Adaline", "Monica", "Alice", "Emmy", "Fiona", "Cindy", "Elena", "Gal", "Natalie", "Scarlet");
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
                int itAge = LocalDate.now().getYear() - it.next().getYear();
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
                pets.addAll((Collection<? extends Pet>) family.getPet());
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