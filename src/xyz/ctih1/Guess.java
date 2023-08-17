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
	List<String> guessedWords = new ArrayList<String>();
	List<String> correctColors = new ArrayList<String>();
	String reset = "\\u001b[0m";
	String correct = "\\u001b[42m";
	String wrongPos = "\\u001b[43m";
	String none = "\\u001b[47m";
	Boolean proceed;
	public void GetGuess() {
		proceed = true;
		correctWord = Main.correctWord;
		System.out.println("Take a guess.");
		System.out.println(guess);
		guess = reader.nextLine();
		if(guess.length()!=5) {
			System.out.println("A word must have 5 letters, you had: " + guess);
			guess = "";
			proceed = false;
		}
		if(!RandomWord.words.contains(guess)) {
			System.out.println("Word not found in words!");
			proceed = false;
		}
		if(!proceed) {
			
		}
		else { 
			System.out.println("correctChars: " + correctChars);
			System.out.println("guessChars: " + guessChars);
			for(int i = 0; i < 5; i++) {
				guessChars.add(String.valueOf(guess.charAt(i)));
			}
			for(int i = 0; i < 5; i++) {
				if(correctChars.size() > 5) {
					correctChars.clear();
				}
				correctChars.add(String.valueOf(correctWord.charAt(i)));

				
			}
			System.out.println("correctChars: " + correctChars);
			System.out.println("guessChars: " + guessChars);
			for(int i = 0; i < correctWord.length(); i++) {
				correctChars.add(String.valueOf(correctWord.charAt(i)));
			}
			System.out.println(correctChars.size());
			for(int i = 0; i < 5; i++) {
				if(correctChars.get(i).equals(guessChars.get(i))) {
					System.out.println("Correct char & pos at " + i);
					correctColors.add(i,correct);
				}
				else {
					correctColors.add(i, none);
				}
			}
			
			for (int i = 0; i < 5; i++) {
				if(correctChars.contains(guessChars.get(i))) {
					if(!(correctChars.get(i).equals(guessChars.get(i)))) {
						correctColors.add(i,wrongPos);
					}
					
				}
			}
			if(guess.equals(correctWord)) {
				System.out.println("Correct word!");
			}
			guessedWords.add(guess);
			System.out.println(correctWord);
			System.out.println(correctColors);
			correctColors.clear();
			guess = "";
			guessChars.clear();
		}
	}
}
