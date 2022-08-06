package task;

public class Main {
    public static void main(String[] args) {

        Pet dog = new Pet(Species.DOG, "Rock", 5, 77, new String[]{"eating", "drinking"});
        Human father = new Human("Vito", "Karleone", 1973 );
        Human mother = new Human("Jane", "Karleone", 1975);

        Family michaelsFamily = new Family(mother, father);

        Human child = new Human("Micheal", "Karleone", 1999, 88,
                new String[][]{{DayofWeek.MONDAY.name(), "go to gym"}}, michaelsFamily);

        michaelsFamily.addChild(child);
        michaelsFamily.setPet(dog);

        System.out.println(michaelsFamily);
    }




}