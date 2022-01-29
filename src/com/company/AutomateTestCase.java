package com.company;

import java.util.ArrayList;

public class AutomateTestCase {
    public ArrayList<String> dictionary;
    private int solved;
    public ArrayList<Integer> attempts;

    public AutomateTestCase(ArrayList<String> dictionary) {
        this.dictionary = dictionary;
        attempts = new ArrayList<>();
        solved = 0;
    }

    public void runTestCaseForDictionary(){
        for (int i = 0; i < dictionary.size(); i++) {
            if (i % 500 == 0){
                System.out.println("Running test case: " + i);
            }
            Wordle wordle = new Wordle(dictionary.get(i));
            Solver solver = new Solver();
            solver.pushDictionary(dictionary);
            for (int j = 0; j < 6; j++) {
                String str = solver.randomGuess();
                String verdict = wordle.check(str);
                solver.updateCandidates(str, verdict);
                if (wordle.solved()){
                    solved++;
                    attempts.add(j+1);
                    break;
                }
                /*if (j==5){
                    System.out.println(solver.remainingCandidate());
                }*/
            }
        }
    }

    public void printReport(){
        System.out.println("=================================");
        System.out.println("Solved test case: " + solved);
        int total = 0;
        for (int i : attempts){
            total+=i;
        }
        double avg = 1.0 * total / solved;
        double acc = 100.0 * solved / dictionary.size();
        System.out.println("Average attempts for solved test case: " + avg);
        System.out.println("Accuracy: " + acc);
    }
}
