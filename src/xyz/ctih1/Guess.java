package xyz.ctih1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Guess{
	Scanner reader = new Scanner(System.in);
	String guess;
	String correctWord;
	List<String> correctChars = new ArrayList<String>();
	List<String> guessChars = new ArrayList<String>();
	public void GetGuess() {
		correctWord = Main.correctWord;
		System.out.println("Take a guess.");
		System.out.println(guess);
		guess = reader.nextLine();
		if(guess.length()!=5) {
			System.out.println("A word must have 5 letters, you had: " + guess);
		}
		
		for(int i = 0; i < guess.length(); i++) {
			guessChars.add(String.valueOf(guess.charAt(i)));
		}
		
		for(int i = 0; i < correctWord.length(); i++) {
			correctChars.add(String.valueOf(correctWord.charAt(i)));
		}
		System.out.println(correctChars.size());
		for(int i = 0; i < correctChars.size(); i++) {
			if(correctChars.get(i).equals(guessChars.get(i))) {
				System.out.println("Correct char & pos at " + i);
			}
		}
		System.out.println(correctWord);
		guess = "";
		guessChars = new ArrayList<String>();
	}
}
