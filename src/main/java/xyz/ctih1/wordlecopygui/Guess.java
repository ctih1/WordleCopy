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

        for(int i = 0; i < 5; i++) {
            score.add(" ");
        }

        for(int i = 0; i<5; i++) {
            System.out.println(guess + " <|> " + correct);
            System.out.println(letters);
            letters.put(String.valueOf(guess.charAt(i)), 1 + letters.getOrDefault(String.valueOf(letters.get(guess.charAt(i))), 0));

            //System.out.println(correct.get(i));
            boolean b = String.valueOf(guess.charAt(i)).equalsIgnoreCase(String.valueOf(correct.charAt(i)));

            boolean contains = correct.contains(String.valueOf(guess.charAt(i)));
            if(!(contains) && !(b)) {
                score.set(i,"0");
            }
            else if(b) {
                score.set(i,"1");
                letters.put(String.valueOf(guess.charAt(i)), letters.get(String.valueOf(guess.charAt(i)))-1);
            }
            else if(contains && !b && letters.get(String.valueOf(guess.charAt(i))) > 0)  {
                score.set(i,"2");
                letters.put(String.valueOf(guess.charAt(i)), letters.get(String.valueOf(guess.charAt(i)))-1);
            }


        }
        return score;
    }
}
