package org.example;

public class FCFS extends Scheduler{

    @Override
    public void runSimulation(){

    }

    @Override
    public void scheduleDeparture(Process process) {
        //Add departure event to the queue
        Event departureEvent = new Event(Event.EventType.DEPARTURE, getCurrentTime() + process.getServiceTime(), process);
        addEvent(departureEvent);
    }

    @Override
    public void processArrival(Event event) {

    }
    @Override
    public void processDeparture(Event event) {

    }
}
