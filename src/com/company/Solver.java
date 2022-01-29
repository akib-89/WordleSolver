package com.company;

import java.util.*;

public class Solver {
    private ArrayList<String> candidate;

    public Solver() {
        candidate = new ArrayList<>();
    }

    public String randomGuess(){
        Random random =  new Random();
        int randomInt = random.nextInt(candidate.size());
        return candidate.get(randomInt);
    }

    public void updateCandidates(String tried, String verdict){
        tried = tried.toLowerCase();
        verdict = verdict.toLowerCase();
        ArrayList<Character> forbidden =  new ArrayList<>();
        Map<Character,Integer> selected = new HashMap<>();
        Map<Character,Integer> potential = new HashMap<>();

        for (int i = 0; i < tried.length(); i++) {
            char c = tried.charAt(i);
            char v = verdict.charAt(i);
            if (v == 'b'){
                forbidden.add(c);
            }else if (v=='y'){
                potential.put(c, i);
            }else {
                selected.put(c, i);
            }
        }

        for (int i = candidate.size()-1; i >=0 ; i--) {
            String str = candidate.get(i);

            for (int j = 0; j < str.length(); j++) {
                if (forbidden.contains(str.charAt(j))){
                    // string contains a forbidden character
                    candidate.remove(str);
                    break;
                }else {
                    if (!selected.isEmpty()){
                        Set<Character> keys = selected.keySet();
                        for (Character c:keys){
                            int index = selected.get(c);
                            if (str.charAt(index) != c){
                                candidate.remove(str);
                            }
                        }
                    }

                    if (!potential.isEmpty()){
                        Set<Character> keys = potential.keySet();
                        for (Character c:keys){
                            int index = potential.get(c);
                            if (str.charAt(index) == c){
                                candidate.remove(str);
                            }
                        }
                    }
                }
            }




        }
    }

    public void pushDictionary(ArrayList<String> dictionary){
        candidate = new ArrayList<>(dictionary);
    }

    public int remainingCandidate(){
        return candidate.size();
    }
    public ArrayList<String> candidate(){
        return new ArrayList<>(candidate);
    }
}
