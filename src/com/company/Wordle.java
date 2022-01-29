package com.company;

import java.util.ArrayList;

public class Wordle {
    private String strToMatch;
    private ArrayList<Character> characters;
    private String lastVerdict;

    public Wordle(String strToMatch) {
        this.strToMatch = strToMatch;
        characters = new ArrayList<>();
        for (int i = 0; i < strToMatch.length(); i++) {
            char c = strToMatch.charAt(i);
            characters.add(c);
        }
    }

    public boolean solved(){
        return lastVerdict.equalsIgnoreCase("ggggg");
    }

    public String check(String str){
        char[] verdict = new char[strToMatch.length()];
        for (int i = 0; i < strToMatch.length(); i++) {
            char main = strToMatch.charAt(i);
            char compare = str.charAt(i);
            if (main == compare){
                verdict[i] = 'g';
            }else if (characters.contains(compare)){
                verdict[i] = 'y';
            }else {
                verdict[i] = 'b';
            }
        }

        lastVerdict = String.valueOf(verdict);
        return String.valueOf(verdict);
    }
}
