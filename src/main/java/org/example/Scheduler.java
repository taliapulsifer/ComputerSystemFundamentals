package org.example;
import java.util.PriorityQueue;
import java.util.random.*;
//Responsible for managing the scheduling of processes. Knows how to
//handle events, maintain the event queue and implement the specific
//scheduling algorithm (SJF, FCFS)
public abstract class Scheduler {

    PriorityQueue<Event> eventQueue = new PriorityQueue<>();
    PriorityQueue<Process> readyQueue = new PriorityQueue<>();
    private float currentTime;
    private float serviceTime;

    protected float generateArrivalTime(){
        return 0;
    }

    protected float generateServiceTime(){
        return 0.0f;
    }

    public void addEvent(Event e){
        eventQueue.add(e);
    }
    public Event getNextEvent(){
        return eventQueue.poll();
    }
    public void addProcessToReadyQueue(Process p){
        readyQueue.add(p);
    }
    public Process getNextProcessFromReadyQueue(){
        return readyQueue.poll();
    }
    public float getCurrentTime(){
        return currentTime;
    }
    public void setTime(float time){
        currentTime = time;
    }
    public void setServiceTime(float time){
        serviceTime = time;
    }
    public float getAvgServiceTime(){
        return serviceTime;
    }



    public abstract void processArrival(Event event);

    public abstract void processDeparture(Event event);
    public abstract void runSimulation();
}
