package org.example;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nLet the game begin! \n");
        System.out.print("What is your name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();


        int upperbound = 100;
        Random rnd = new Random();
        int random_number = rnd.nextInt(upperbound);
        Scanner in = new Scanner(System.in);
        System.out.println(random_number);

        int user_input = 0;
        while (user_input != random_number) {
            System.out.print("Guess number the in my mind: ");
            user_input = in.nextInt();


            if (user_input == random_number) {
                System.out.printf("Congratulations, %s ! \n", name);

            } else if (user_input < random_number) {
                System.out.println("Your number is too small. Please, try again.");
            } else if (user_input > random_number) {
                System.out.println("Your number is too big. Please, try again.");
            }
        }
    }
}