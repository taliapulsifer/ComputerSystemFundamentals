package org.example;

import java.util.PriorityQueue;

public class SJF extends Scheduler{
    private PriorityQueue<Process> processQueue = new PriorityQueue<>();
    private Process currentProcess = null;

    @Override
    public void processArrival(Event event){

    }

     @Override
    public void processDeparture(Event event){

    }
}
