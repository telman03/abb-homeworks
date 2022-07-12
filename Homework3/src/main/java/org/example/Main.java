package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] schedule = new String[7][2];

        schedule[0][0] = "Sunday";
        schedule[0][1] = "do home work";
        schedule[1][0] = "Monday";
        schedule[1][1] = "go to courses; watch a film";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "go to courses; watch a film";

        while (true){
            System.out.println("Enter the day of a week: ");
            Scanner sc = new Scanner(System.in);
            String week_day = sc.nextLine().trim().toLowerCase();

            switch (week_day){
                case "sunday":
                    System.out.println(schedule[0][1]);
                    break;
                case "monday":
                    System.out.println(schedule[1][1]);
                    break;
                case "tuesday":
                    System.out.println(schedule[2][1]);
                    break;


                case "change sunday":
                    System.out.println("Enter new task for Sunday: ");
                    Scanner sc2 = new Scanner(System.in);
                    String new_task01 = sc2.nextLine();
                    schedule[0][1] = new_task01;
                    break;

                case "change monday":
                    System.out.println("Enter new task for Monday: ");
                    Scanner sc3 = new Scanner(System.in);
                    String new_task02 = sc3.nextLine();
                    schedule[1][1] = new_task02;
                    break;

                case "change tuesday":
                    System.out.println("Enter new task for Monday: ");
                    Scanner sc4 = new Scanner(System.in);
                    String new_task03 = sc4.nextLine();
                    schedule[2][1] = new_task03;
                    break;

                case "exit":
                    return;
                default:
                    System.out.println("Sorry, I don't understand you, please try again.");


            }
        }


    }
}