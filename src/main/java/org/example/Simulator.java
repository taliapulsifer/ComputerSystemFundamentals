package org.example;

import java.util.*;

public class Simulator {
    private boolean CPUBusy;
    private Scheduler scheduler;

    public Simulator(Scheduler scheduler){

        //Stores future events in order of time 
        //this.eventQueue = new PriorityQueue<>();

        //If the CPU is free it runs immediately, if the CPU is busy it adds to the ready queue
        //When a departure event occurs, the scheduler selects the next process from the ready queue
        //Stores processes that are waiting for CPU time
        //this.readyQueue = new LinkedList<>();
        this.CPUBusy = false;
        this.scheduler = scheduler;
    }

    public void scheduleEvent(Event event){
        scheduler.addEvent(event);
    }

    public void runSimulation(){
        //while the event queue is not empty, and we have not reached the process cap of 10,000
        while(!scheduler.eventQueue.isEmpty() && scheduler.getCompletedProcesses() < 10000){
            //Retrieves and removes the next event
            Event currentEvent = scheduler.getNextEvent();

            switch (currentEvent.getType()) {
                case ARRIVAL:
                    handleArrival(currentEvent.getProcess());
                    break;
                case DEPARTURE:
                    handleDeparture(currentEvent.getProcess());
                    break;
            }
        }
    }

    private void handleArrival(Process process){
        scheduler.scheduleDeparture(process);
        //If the CPU is not busy, run process
        if(!CPUBusy){
            CPUBusy = true;
            scheduler.setTime(scheduler.getCurrentTime() + process.getServiceTime());
        }
        //If CPU is busy, add event to the ready queue
        else {
            scheduler.addProcessToReadyQueue(process);
        }

    }

    private void handleDeparture(Process process){
        scheduler.incrementCompletedProcesses();
        CPUBusy = false;

        //Check ready queue for waiting processes
        if(!scheduler.readyQueue.isEmpty()){
            Process nextProcess = scheduler.getNextProcessFromReadyQueue();
            CPUBusy = true;
            scheduler.setTime(scheduler.getCurrentTime() + nextProcess.getServiceTime());
            scheduler.scheduleDeparture(process);

        }
    }

}
