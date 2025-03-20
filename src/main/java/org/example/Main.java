package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the average arrival rate for this system: ");
            while (!scanner.hasNextFloat()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            float lambda = scanner.nextFloat();

            System.out.println("Enter the average service time for this system: ");
            while (!scanner.hasNextFloat()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            float avgServiceTime = scanner.nextFloat();

            System.out.println("Which scheduler do you want to use: First-Come-First-Serve(0) or Shortest-Job-First(1)? ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter 0 or 1.");
                scanner.next();
            }
            int scheduler = scanner.nextInt();

            System.out.println("lambda: " + lambda + " avgServiceTime: " + avgServiceTime + " scheduler: " + scheduler);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numbers.");
        }
    }
}