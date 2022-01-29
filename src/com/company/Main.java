package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        ArrayList<String> dic= new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("dictionaries.txt"))){
            String word;
            while ((word = reader.readLine()) != null){
                dic.add(word);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        AutomateTestCase testCase = new AutomateTestCase(dic);
        testCase.runTestCaseForDictionary();
        testCase.printReport();
        /*System.out.println(dic.size());

        Wordle wordle = new Wordle("acorn");
        Solver solver = new Solver();
        solver.pushDictionary(dic);
        for (int i = 0; i < 6; i++) {
            String str = solver.randomGuess();
            System.out.println(str);
            String verdict = wordle.check(str);
            System.out.println("verdict: " + verdict);
            solver.updateCandidates(str,verdict);
            System.out.println("remaining candidate: " + solver.remainingCandidate());
            if (solver.remainingCandidate() <= 10){
                for (String s: solver.candidate()){
                    System.out.println(s);
                }
            }
        }*/
    }
}
