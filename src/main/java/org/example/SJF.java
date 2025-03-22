package org.example;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class SJF extends Scheduler{
    private boolean CPUBusy = false;
    private Process currentProcess = null;
    private float remainingServiceTime = 0;

    public SJF() {
        readyQueue = new PriorityBlockingQueue<>(1000, Comparator.comparing(Process::getServiceTime));
    }

    @Override
    public void scheduleDeparture(Process process) {
        Event departureEvent = new Event(Event.EventType.DEPARTURE, getCurrentTime() + process.getServiceTime(), process);
        addEvent(departureEvent);
        System.out.println("Scheduled departure: " + departureEvent.getProcess().getProcessID() + ", time: " + departureEvent.getEventTime());
    }

    @Override
    public void processArrival(Event event){
        Process newProcess = event.getProcess();
        readyQueue.add(newProcess);

        if(CPUBusy){
            currentProcess.setServiceTime(remainingServiceTime);
            if(newProcess.getServiceTime() < currentProcess.getServiceTime()){
                removeDeparture(currentProcess);
                addProcessToReadyQueue(currentProcess);
                currentProcess = readyQueue.poll();
                remainingServiceTime = currentProcess.getServiceTime();
                setTime(getCurrentTime() + currentProcess.getServiceTime());
                scheduleDeparture(currentProcess);
            }
        }
        else{
            currentProcess = readyQueue.poll();
            remainingServiceTime = currentProcess.getServiceTime();
            setTime(getCurrentTime() + currentProcess.getServiceTime());
            scheduleDeparture(currentProcess);
            CPUBusy = true;
        }
    }

    @Override
    public void processDeparture(Event event){
        System.out.println("Processing departure: " + event.getProcess().getProcessID() + ", time: " + getCurrentTime());
        incrementCompletedProcesses();
        CPUBusy = false;
        event.getProcess().setDepartureTime(getCurrentTime());

        if (!readyQueue.isEmpty()) {
            currentProcess = readyQueue.poll();
            setTime(getCurrentTime() + currentProcess.getServiceTime());
            scheduleDeparture(currentProcess);
            CPUBusy = true;
        }
        else{
            currentProcess = null;
        }

    }

    private void removeDeparture(Process process){
        eventQueue.removeIf(event -> event.getType() == Event.EventType.DEPARTURE &&
                event.getProcess().getProcessID() == process.getProcessID());
    }
}
