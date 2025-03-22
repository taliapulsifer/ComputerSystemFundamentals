package org.example;

public class Simulator implements Runnable{
    private Scheduler scheduler;
    private volatile boolean stop = false;

    public Simulator(Scheduler scheduler){

        //Stores future events in order of time 
        //this.eventQueue = new PriorityQueue<>();

        //If the CPU is free it runs immediately, if the CPU is busy it adds to the ready queue
        //When a departure event occurs, the scheduler selects the next process from the ready queue
        //Stores processes that are waiting for CPU time
        //this.readyQueue = new LinkedList<>();
        this.scheduler = scheduler;
    }

    public void scheduleEvent(Event event){
        scheduler.addEvent(event);
    }

    public void setStop() {
        this.stop = true;
    }
    

    @Override
    public void run() {
        //while the event queue is not empty, and we have not reached the process cap of 10,000
        while(! this.stop && scheduler.getCompletedProcesses() < 10000){
            //Retrieves and removes the next event
            Event currentEvent = scheduler.getNextEvent();

            switch (currentEvent.getType()) {
                case ARRIVAL:
                    scheduler.processArrival(currentEvent);
                    break;
                case DEPARTURE:
                    scheduler.processDeparture(currentEvent);;
                    break;
            }
        }
    }
}
