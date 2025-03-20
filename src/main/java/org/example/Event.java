package org.example;

//can reference a Process, represents an event in the simulation such as a process 
//arriving or a process finishing
public class Event implements Comparable<Event>{

    public enum EventType {ARRIVAL, DEPARTURE};
    private EventType type;
    private float eventTime;
    private Process process;

    public Event(EventType type, float eventTime, Process process){
        this.type = type;
        this.eventTime = eventTime;
        this.process = process;
    }

    public EventType getType(){
        return type;
    }

    public float getEventTime(){
        return eventTime;
    }

    public Process getProcess(){
        return process;
    }

    @Override
    public int compareTo(Event other){
        return Float.compare(this.eventTime, other.eventTime);
    }

}
