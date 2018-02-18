package com.codecool.multtimer;

public class Timer implements Runnable {

    private Thread timer;
    private int timerCount;
    private boolean stop;
    private String timerName;

    public Timer(String timerName) {
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

    public void start() {
        timer = new Thread(this, this.getTimerName());
        stop = false;
        timer.start();
    }

    public int checkTimer() {
        return timerCount;
    }

    public Thread getTimer() {
        return timer;
    }

    public String getTimerName() {
        return timerName;
    }
}
