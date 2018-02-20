package com.codecool.multtimer;

public class Timer implements Runnable {

    private Thread timer;
    private int timerCount;
    private boolean stop;
    private String timerName;

    Timer(String timerName) {
        this.timer = null;
        this.stop = false;
        this.timerCount = 0;
        this.timerName = timerName;
    }

    public void run() {

        while (!stop) {
            try {
                timerCount += 1;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Stopped timer: " + this.getTimerName());
                stop = true;
            }
        }

    }

    void start() {
        timer = new Thread(this, this.getTimerName());
        stop = false;
        timer.start();
        System.out.println("Started timer: " + this.getTimerName());
    }

    void stopTimer() {
        this.timer.interrupt();
    }

    public String toString() {
        return "Name: " + this.getTimerName() +
                ", ThreadID: " + this.getTimer().getId() +
                ", Seconds: " + this.getTimerCount();
    }

    private int getTimerCount() {
        return timerCount;
    }

    private Thread getTimer() {
        return timer;
    }

    String getTimerName() {
        return timerName;
    }
}
