package org.example;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int temp = 0;
        int upperbound = 100;
        Random rnd = new Random();
        int random_number = rnd.nextInt(upperbound);
        System.out.println("Please enter your name:");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Let the game begin!");

        while (true) {
            int[] arr = new int[100];
            int[] numbers = new int[100];
            int counter = 0;
            boolean flag = false;
            int j = 0;

            for (int i = 0; i < arr.length; i++) {
                arr[i] = random_number;

                for (j = 0; j < numbers.length; j++) {
                    System.out.println("Please enter number: ");
                    Scanner num = new Scanner(System.in);

                    if (num.hasNextInt()) {
                        int number1 = num.nextInt();
                        counter++;
                        numbers[j] = number1;

                        if (number1 < arr[i]) {
                            System.out.println("Your number is too small. Please, try again.");
                        } else if (number1 > arr[i]) {
                            System.out.println("Your umber is too big. Please, try again.");
                        } else {
                            System.out.println("Congratulations " + name + "\n");
                            flag = true;
                        }

                        if(flag) {
                            for (i=0;i<counter-1;++i) {
                                for (j = 0; j < counter - i - 1; ++j) {
                                    if (numbers[j] < numbers[j + 1]) {
                                        temp = numbers[j];
                                        numbers[j] = numbers[j + 1];
                                        numbers[j + 1] = temp;
                                    }
                                }
                            }
                            for (j = 0; j < counter; j++) {
                                System.out.print(numbers[j] + " ");
                            }
                            return;
                        }
                    } else {
                        System.out.println("Your input isn't a number: ");
                    }
                }
            }
        }
    }
}