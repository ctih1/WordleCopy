package xyz.ctih1.wordlecopygui;

import java.util.ArrayList;
import java.util.HashMap;


public class Guess {

    private static final ArrayList<String> score = new ArrayList<String>();
    private static final ArrayList<String> correctThing = new ArrayList<String>();
    private static final HashMap<String, Integer> letters = new HashMap<String, Integer>();
    public static ArrayList<String> checkGuess(String guess, String correct) {
        letters.clear();
        score.clear();
        for(int i = 0; i<5; i++) {
            System.out.println(guess + " <|> " + correct);
            System.out.println(letters);
            letters.put(String.valueOf(guess.charAt(i)), 1 + letters.getOrDefault(letters.get(String.valueOf(guess.charAt(i))), 0));

            //System.out.println(correct.get(i));
            if(String.valueOf(guess.charAt(i)).equalsIgnoreCase(String.valueOf(correct.charAt(i)))) {
                score.add("1");
            }
            else if(guess.contains(String.valueOf(correct.charAt(i)))) {

                if(letters.get(String.valueOf(guess.charAt(i))) > 0) {
                     letters.put(String.valueOf(guess.charAt(i)), letters.get(String.valueOf(guess.charAt(i)))-1);
                     score.add("2");
                }
            }
            else {
                score.add("0");
            }

        }
        guess = "";
        return score;
    }
}
