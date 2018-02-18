package com.codecool.multtimer;

import java.util.Scanner;

public class App {

    private Timer TEA;
    private Timer COFFEE;

    private App() {
        this.TEA = new Timer("TEA");
        this.COFFEE = new Timer("COFFEE");
    }

    private void loopTimers(){

        String userInput = getUserInput();

        while (true) {

            if (userInput.equals("start TEA"))
                TEA.start();
            else if (userInput.equals("start COFFEE"))
                COFFEE.start();
            else if (userInput.equals("check"))
                checkTimers();
            else if (userInput.equals("check TEA"))
                printTimer(TEA);
            else if (userInput.equals("check COFFEE"))
                printTimer(COFFEE);
            else if (userInput.equals("stop TEA"))
                TEA.getTimer().interrupt();
            else if (userInput.equals("stop COFFEE"))
                COFFEE.getTimer().interrupt();
            else if (userInput.equals("exit"))
                break;

            userInput = getUserInput();
        }
    }

    private void printTimer(Timer timer) {
        System.out.println("Name: " + timer.getTimerName() + ", ThreadID: " +
        timer.getTimer().getId() + ", Seconds: " + timer.checkTimer());
    }

    private void checkTimers() {
        if (COFFEE.getTimer() != null && TEA.getTimer() != null)
            System.out.println("Name: TEA, ThreadID: " + TEA.getTimer().getId() +
                    ", Seconds: " + TEA.checkTimer() +
                    "\nName: COFFEE, ThreadID: " + COFFEE.getTimer().getId() +
                    ", Seconds: " + COFFEE.checkTimer() + "\n");
        else {
            if (TEA.getTimer() != null)
                System.out.println("Name: TEA, ThreadID: " + TEA.getTimer().getId() +
                        ", Seconds: " + TEA.checkTimer());
            else if (COFFEE.getTimer() != null)
                System.out.println("Name: COFFEE, ThreadID: " + COFFEE.getTimer().getId() +
                        ", Seconds: " + COFFEE.checkTimer());
            else
                System.out.println("Timers not started.");
        }
    }


    private String getUserInput() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    public static void main(String[] args) {
        App a = new App();
        a.loopTimers();
    }
}
