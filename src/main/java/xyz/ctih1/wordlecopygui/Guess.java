package xyz.ctih1.wordlecopygui;

import java.util.ArrayList;
import java.util.HashMap;


public class Guess {

    private static final ArrayList<String> score = new ArrayList<String>();
    private static final ArrayList<String> correctThing = new ArrayList<String>();
    private static final HashMap<String, Integer> letters = new HashMap<String, Integer>();
    public static ArrayList<String> checkGuess(ArrayList guess, ArrayList correct) {
        letters.clear();
        score.clear();
        for(int i = 0; i<5; i++) {
            if(!(letters.containsKey(String.valueOf(guess.get(i))))) {
                letters.put((String) guess.get(i), 1);
            }
            else {
                letters.put((String) guess.get(i), letters.get(String.valueOf(guess.get(i)))+1);
            }
            System.out.println(guess.get(i));
            //System.out.println(correct.get(i));
            if(guess.get(i).equals(correct.get(i))) {
                score.add("1");
            }
            else if(guess.contains(correct.get(i))) {

                if(letters.get(String.valueOf(guess.get(i))) > 0) {
                     letters.put((String) guess.get(i), letters.get(String.valueOf(guess.get(i)))-1);
                     score.add("2");
                }
            }
            else {
                score.add("0");
            }

        }
        guess.clear();
        return score;
    }

    public static ArrayList splitWord(String text) {
        correctThing.clear();
        for(int i = 0; i <5; i++) {
            correctThing.add(String.valueOf(text.charAt(i)));
        }
        return correctThing;
    }
}
