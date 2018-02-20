package com.codecool.multtimer;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {

    private List<Timer> timers;

    private App() {
        this.timers = new LinkedList<Timer>();
    }

    private void loopTimers() {
        String[] userInput = getUserInput();

        while (true) {
            if (ifNewTimer(userInput))
                addTimer(userInput);
            else if (ifStopTimer(userInput))
                stopTimer(userInput);
            else if (ifCheckTimer(userInput))
                checkTimer(userInput);
            else if (ifCheckTimers(userInput))
                checkTimers();
            else if (ifExit(userInput))
                System.exit(0);

            userInput = getUserInput();
        }
    }

    private boolean ifNewTimer(String[] userInput) {
        return userInput[0].equals("start");
    }

    private boolean ifStopTimer(String[] userInput) {
        return userInput[0].equals("stop");
    }

    private void stopTimer(String[] userInput) {
        for (Timer t : timers)
            if (userInput[1].equals(t.getTimerName()))
                t.stopTimer();
    }

    private boolean ifCheckTimer(String[] userInput) {
        return userInput[0].equals("check") && userInput.length == 2;
    }

    private void checkTimer(String[] userInput) {
        for (Timer t : timers)
            if (userInput[1].equals(t.getTimerName()))
                System.out.println(t.toString());

    }

    private boolean ifCheckTimers(String[] userInput) {
        return userInput[0].equals("check") && userInput.length == 1;
    }

    private void checkTimers() {
        StringBuilder sb = new StringBuilder();

        if (timers.size() == 0)
            System.out.println("No timers started yet.");
        else {
            for (Timer t : timers)
                sb.append(t.toString() + "\n");

            System.out.println(sb.toString());
        }
    }

    private boolean ifExit(String[] userInput) {
        return userInput[0].equals("exit");
    }

    private void addTimer(String[] userInput) {
        Timer timer = new Timer(userInput[1]);
        timer.start();
        timers.add(timer);
    }

    private String[] getUserInput() {
        Scanner s = new Scanner(System.in);
        return s.nextLine().split(" ");
    }

    public static void main(String[] args) {
        App a = new App();
        a.loopTimers();
    }
}
