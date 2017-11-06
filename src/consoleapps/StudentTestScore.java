/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleapps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author B1
 */
public class StudentTestScore {

    private List<Integer> scoreList = new ArrayList();
    private Scanner sc = new Scanner(System.in);
    private static int maxScore = 40;

    public void inputScores() {
        int nextScore = -1;

        do {
            System.out.print("Enter score*(-1 to exit) : ");
            nextScore = sc.nextInt();
            if (nextScore > maxScore) {
                System.out.println("Error! Maximum test score: " + maxScore);
            } else if (nextScore >= 0) {
                scoreList.add(nextScore);   //invoke add
            }
        } while (nextScore >= 0);
        System.out.println("Input test score completed.\n");
    }

    public void displayScores() {
        for (int i = 0; i < scoreList.size(); ++i) {  //array list size
            System.out.printf("%3d.%6d\n", (i + 1), scoreList.get(i));
        }
        System.out.println("\nLowest score: " + findLowest());
        System.out.println("Highest score: " + findHighest());
        System.out.printf("Average score: %.2f\n", computeAverage());
    }

    public int findLowest() {
        int lowest = scoreList.get(0);

        for (int i = 0; i < scoreList.size(); ++i) {
            if (scoreList.get(i) < lowest) {
                lowest = scoreList.get(i);
            }
        }
        return lowest;
    }

    public int findHighest() {
        int highest = scoreList.get(0);

        for (int i = 1; i < scoreList.size(); ++i) {
            if (scoreList.get(i) > highest) {
                highest = scoreList.get(i);
            }
        }
        return highest;
    }

    public double computeAverage() {
        double total = 0;
        for (int i = 0; i < scoreList.size(); ++i) {
            total += scoreList.get(i);
        }

        return (double) total / scoreList.size();
    }

    public static void main(String[] args) {
        StudentTestScore testScore = new StudentTestScore();
        testScore.inputScores();
        testScore.displayScores();
    }

}
