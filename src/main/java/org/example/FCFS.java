package org.example;

public class FCFS extends Scheduler{
    private boolean CPUBusy = false;

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
        Process process = event.getProcess();

        scheduleDeparture(process);
        //If the CPU is not busy, run process
        if(!CPUBusy){
            CPUBusy = true;
            setTime(getCurrentTime() + process.getServiceTime());
        }
        //If CPU is busy, add event to the ready queue
        else {
            addProcessToReadyQueue(process);
        }
    }

    @Override
    public void processDeparture(Event event) {
        incrementCompletedProcesses();
        CPUBusy = false;

        //Check ready queue for waiting processes
        if(!readyQueue.isEmpty()){
            Process nextProcess = getNextProcessFromReadyQueue();
            CPUBusy = true;
            setTime(getCurrentTime() + nextProcess.getServiceTime());
            scheduleDeparture(nextProcess);

        }
    }
}
