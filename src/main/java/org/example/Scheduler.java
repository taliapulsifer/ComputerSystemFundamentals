package org.example;
import java.util.PriorityQueue;
//Responsible for managing the scheduling of processes. Knows how to
//handle events, maintain the event queue and implement the specific
//scheduling algorithm (SJF, FCFS)
public abstract class Scheduler {

    PriorityQueue<Event> eventQueue = new PriorityQueue<>();
    PriorityQueue<Process> readyQueue = new PriorityQueue<>();
    private float currentTime = 0.0f;
    private int completedProcesses = 0;
    private float busyTime = 0.0f;

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
    public void incrementCompletedProcesses() {
        completedProcesses++;
    }
    public void updateBusyTime(float time) {
        busyTime += time;
    }
    public float getTotalBusyTime() {
        return busyTime;
    }
    public float turnaroundTime(){
        return currentTime / completedProcesses;
    }
    public float getTotalTime(){
        return currentTime;
    }
    public float readyQueueLength(){
        return (float)readyQueue.size();
    }
    public int getCompletedProcesses() {
        return completedProcesses;
    }
    public abstract void processArrival(Event event);

    public abstract void scheduleDeparture(Process process);
    public abstract void processDeparture(Event event);
}
