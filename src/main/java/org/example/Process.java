package org.example;

//Represents a job that arrives at the CPU for execution. Stores arrival time, service time, and departure time
//Tracks execution progress can be places in the Ready Queue waiting for execution
public class Process implements Comparable<Process> {
    private float arrivalTime;
    private float departureTime;
    private float serviceTime;
    private float remainingServiceTime;
    private int processID = 0;

    //Constructor
    public Process(float arrivalTime, float serviceTime, int processID){
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.remainingServiceTime = serviceTime;
        this.processID = processID;
    }

    //Getters and Setters
    protected float generateArrivalTime(){
        return 0;
    }

    protected float generateServiceTime(){
        return 0.0f;
    }

    public float getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(float arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public float getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(float departureTime) {
        this.departureTime = departureTime;
    }
    public float getServiceTime() {
        return serviceTime;
    }
    public void setServiceTime(float serviceTime) {
        this.serviceTime = serviceTime;
    }
    public float getRemainingServiceTime() {
        return remainingServiceTime;
    }
    public void setRemainingServiceTime(float remainingServiceTime) {
        this.remainingServiceTime = remainingServiceTime;
    }
    public int getProcessID() {
        return processID;
    }
    public void setProcessID(int processID) {
        this.processID = processID;
    }

    //Comparing based on remainingServiceTime
    @Override
    public int compareTo(Process other) {
        return Float.compare(this.remainingServiceTime, other.remainingServiceTime);
    }
}
