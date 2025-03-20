package org.example;
import java.util.PriorityQueue;
import java.util.random.*;

public class Scheduler {

    PriorityQueue<Event> eventQueue = new PriorityQueue<>();

    protected float generateArrivalTime(){
        return 0;
    }

    protected float generateServiceTime(){
        return 0.0f;
    }

    protected float avgTurnaroundTime(){
        return 0.0f;
    }

    protected float throughput(){
        return 0.0f;
    }

    protected float utilization(){
        return 0;
    }

    protected float avgReadyQueue(){
        return 0;
    }
}
