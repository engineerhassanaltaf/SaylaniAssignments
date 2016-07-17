package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();
    static int trials;
    static int maxTrials = 3;
    static final int MIN_NUM = 1;
    static final int MAX_NUM = 10;
    static final int MIN_CREDIT = 1;
    static final int MAX_CREDIT = 10;

    public static void main(String[] args) {
        String choice;
        do {
            System.out.println("Do you want to play the game? (answer with yes/no)");
            choice = input.next().toLowerCase();

            if (choice.equals("yes")) {
                playGame();
            } else if (choice.equals("no")) {
                System.out.println("Please come back next time");
            } else {
                System.out.println("Enter valid choice\n");
            }

        } while(!choice.equals("yes") && !choice.equals("no"));
    }

    private static void playGame() {
        int randNum;
        int num;

        do {
            System.out.println("Remaining trials: " + (maxTrials - trials));
            do { // actual game
                randNum = rand.nextInt(10)+1;
                System.out.println("Please enter number between " + MIN_NUM + "-" + MAX_NUM);
                num = input.nextInt();
                if (isValidNumber(num, MIN_NUM, MAX_NUM)) {
                    if (isWon(randNum, num)) {
                        System.out.println("Congratulations!!! You Won the game");
                    } else {
                        System.out.println("Sorry, You Loss the game");
                    }
                }
                else {
                    System.out.println("Sorry, your number is out of the range");
                }
            } while (!isValidNumber(num, MIN_NUM, MAX_NUM));

            trials++;
            if(trials == 3) { // when trial version has finished
                offerForCredit("You have completed the trial version, ");
            } else if(trials == maxTrials) {
                offerForCredit("Your trails are finished, ");
            }

        } while (trials < maxTrials);

        System.out.println("Please come back next time");
    }

    private static boolean isValidNumber(int num, int minNum, int maxNum) {
        if(num >= minNum && num <= maxNum) {
            return true;
        } else {
            return false;
        }
    }

    private static void offerForCredit(String msg) {
        int credits;
        do {
            System.out.println(msg + "Enter credit to play more (credit must be between " + MIN_CREDIT + "-" + MAX_CREDIT + "), or press 0 to quit");
            credits = input.nextInt();
            if(credits == 0) {
                return;
            }
            if (isValidNumber(credits, MIN_CREDIT, MAX_CREDIT)) {
                maxTrials += credits;
            } else {
                System.out.println("Sorry, your number is out of the range");
            }
        } while (!isValidNumber(credits, MIN_CREDIT, MAX_CREDIT));
    }

    private static boolean isWon(int randNum, int num) {
        if(randNum == num) {
            return true;
        } else {
            return false;
        }
    }
}