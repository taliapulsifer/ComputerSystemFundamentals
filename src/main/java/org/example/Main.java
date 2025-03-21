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
            int schedulerChoice = scanner.nextInt();
            System.out.println("lambda: " + lambda + " avgServiceTime: " + avgServiceTime + " scheduler: " + schedulerChoice);

            Scheduler scheduler;
            if(schedulerChoice == 0){
                //FCFS
                scheduler = new FCFS();
            }
            else if( schedulerChoice == 1){
                //SJF
                scheduler = new SJF();
            } else {
                throw new IllegalArgumentException("Invalid scheduler choice. Please enter 0 or 1.");
            }

            Simulator simulator = new Simulator(scheduler);

            generateInitialProcesses(simulator, scheduler, lambda);

            simulator.runSimulation();

            printResults(scheduler);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numbers.");
        }
    }

    private static void generateInitialProcesses(Simulator simulator, Scheduler scheduler, float lambda){

    }

    private static void printResults(Scheduler scheduler){
        System.out.println("Completed Processes: " + scheduler.getCompletedProcesses());
    }
}