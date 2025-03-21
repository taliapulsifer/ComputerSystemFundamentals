package org.example;

import java.util.PriorityQueue;

//Priority queue based on service time
//If a new job arrives, you have to re-order. Check for new events every q

public class SJF extends Scheduler{
    private PriorityQueue<Process> processQueue = new PriorityQueue<>();
    private Process currentProcess = null;

    @Override
    public void runSimulation(){
        
    }

    @Override
    public void scheduleDeparture(Process process) {

    }

    @Override
    public void processArrival(Event event){

    }
    @Override
    public void processDeparture(Event event){

    }
}

// Thread that wakes up every few seconds to generate new arrivals
