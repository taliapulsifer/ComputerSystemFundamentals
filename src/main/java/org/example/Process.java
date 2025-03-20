package org.example;

public class Process implements Comparable<Process> {
    private float arrivalTime;
    private float departureTime;
    private float serviceTime;
    private float remainingServiceTime;
    private int processID;

    //Constructor
    public Process(float arrivalTime, float serviceTime, int processID){
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.remainingServiceTime = serviceTime;
        this.processID = processID;
    }

    //Getters and Setters
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
