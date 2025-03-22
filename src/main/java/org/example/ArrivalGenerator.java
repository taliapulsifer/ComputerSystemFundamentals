package org.example;

import java.util.Random;

public class ArrivalGenerator implements Runnable{
    private Scheduler scheduler;
    private Simulator simulator;
    private float lambda;
    private float avgServiceTime;   
    private int maxProcesses;
    private int processIDCounter = 0;

    public ArrivalGenerator(Simulator simulator, Scheduler scheduler, float lambda, float avgServiceTime, int maxProcesses){
        this.simulator = simulator;
        this.scheduler = scheduler;
        this.lambda = lambda;
        this.avgServiceTime = avgServiceTime;
        this.maxProcesses = maxProcesses;
    }

    @Override
    public void run() {
        float currentTime = 0.0f;
        Random random = new Random();
        while (processIDCounter < maxProcesses) {
           float arrivalTime = (float) (-Math.log(1.0 - random.nextDouble()) / lambda);
            currentTime += arrivalTime;

            float serviceTime = (float) (-Math.log(1.0 - random.nextDouble()) * avgServiceTime);

            Process newProcess = generateNewProcess(currentTime, serviceTime, processIDCounter++);
            Event event = new Event(Event.EventType.ARRIVAL, currentTime, newProcess);
            simulator.scheduleEvent(event);

            try {
                Thread.sleep((long) (arrivalTime * 1000)); // Simulate the time until the next arrival
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore the interrupted status
                System.out.println("ArrivalGenerator interrupted: " + e.getMessage());
                return;
            }
        }
    }

    private Process generateNewProcess(float arrivalTime, float avgServiceTime, int processID) {
        float processServiceTime = (float) (-Math.log(1.0 - new Random().nextDouble()) * avgServiceTime);
        return new Process(arrivalTime, processServiceTime, processID);
    }

}