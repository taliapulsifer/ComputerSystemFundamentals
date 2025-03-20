package org.example;

import java.util.*;

public class Simulator {
    private PriorityQueue<Event> eventQueue;
    private Queue<Process> readyQueue;
    private float clock;
    private int numberOfCompletedProcesses;
    private boolean CPUBusy;
    private Scheduler scheduler;

    public Simulator(Scheduler scheduler){

        //Stores future events in order of time 
        this.eventQueue = new PriorityQueue<>();

        //If the CPU is free it runs immediatly, if the CPU is busy it adds to the ready queue
        //When a departure event occurs, the scheduler selects the next process from the ready queue
        //Stores processes that are waiting for CPU time
        this.readyQueue = new LinkedList<>();
        this.clock = 0;
        this.numberOfCompletedProcesses = 0;
        this.CPUBusy = false;
        this.scheduler = scheduler;
    }

    public void scheduleEvent(Event event){
        eventQueue.add(event);
    }

    public void runSimulation(){
        //while the event queue is not empty and we have not readched the process cap of 10,000
        while(!eventQueue.isEmpty() && numberOfCompletedProcesses < 10000){
            Event currentEvent = eventQueue.poll();
            clock = currentEvent.getEventTime();

            switch (currentEvent.getType()) {
                case ARRIVAL:
                    handleArrival(currentEvent.getProcess());
                    break;
                case DEPARTURE:
                    handleDeparture(currentEvent.getProcess());
                    break;
            
                default:
                    break;
            }
        }
    }

    private void handleArrival(Process process){
        scheduleDeparture(process);
    }

    private void handleDeparture(Process process){

    }

    private void scheduleDeparture(Process process){

    }

}
