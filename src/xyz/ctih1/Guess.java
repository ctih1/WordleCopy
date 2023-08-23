package xyz.ctih1;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
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
	HashMap<String, Integer> letters = new HashMap<>();
	String reset = "\\u001b[0m";
	String correct = "O";
	String wrongPos = "V";
	String none = "X";
	String className = this.getClass().getSimpleName();
	static boolean forceActualWords = true;
	static boolean showAnwser = false;
	Boolean proceed;
	
	public void setWord(String word) {
		correctWord = word;
		for(int i = 0; i < 5; i++) {
			correctChars.add(String.valueOf(correctWord.charAt(i)));
		}
	}
	
	public void guess() {
		proceed = true;
		System.out.println("[" + className.toUpperCase() + "] " + "Take a guess.");
		guess = reader.nextLine();
		if(guess.length()!=5) {
			System.out.println("[" + className.toUpperCase() + "] " + "A word must have 5 letters, you had: " + guess);
			guess = "";
			proceed = false;
		}
		if(!(RandomWord.words.contains(guess)) && forceActualWords) {
			System.out.println("[" + className.toUpperCase() + "] " + "Word not found in words!");
			proceed = false;
		}
		if(!proceed) {
			// Tee myöhemmin
		}
		else { 
			
			for(int i= 0; i < 5; i++) {
				System.out.println(letters);
				if(!(letters.containsKey(String.valueOf(correctWord.charAt(i))))) {
					System.out.println("Registered "+ correctWord.charAt(i) );
					letters.put(String.valueOf(correctWord.charAt(i)), 1);
				}
				else {
					System.out.println(letters);
					letters.put(String.valueOf(correctWord.charAt(i)), letters.get(String.valueOf(correctWord.charAt(i)))+1);
				}
			}
			for(int i = 0; i < 5; i++) {
				guessChars.add(String.valueOf(guess.charAt(i)));
			}
			System.out.println("[" + className.toUpperCase() + "] " + correctChars.size());
			for(int i = 0; i < 5; i++) {
				if(correctChars.get(i).equals(guessChars.get(i))) {
					correctColors.add(correct);
				}
				else if(correctChars.contains(guessChars.get(i))) {
					if(!(correctChars.get(i).equals(guessChars.get(i)))) {
						if(letters.get(correctChars.get(i)) > 0) {
							correctColors.add(wrongPos);
							letters.put(String.valueOf(correctChars.get(i)), letters.get(correctChars.get(i) + 10));
						}
						
						}
					}

				else if(!(correctChars.get(i).equals(guessChars.get(i)) && correctChars.get(i).equals(guessChars.get(i)))) {
					correctColors.add(none);
				}

	

			}

			
			if(guess.equals(correctWord)) {
				System.out.println("[" + className.toUpperCase() + "] " + "Correct word!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
			
			guessedWords.add(guess);
			if(showAnwser) {
				System.out.println("[" + className.toUpperCase() + "] " + correctWord);
			}
			System.out.println("[" + className.toUpperCase() + "] " + guessChars);
			System.out.println("[" + className.toUpperCase() + "] " + correctColors);
			correctColors.clear();
			letters.clear();
			guess = "";
			guessChars.clear();
		}
	}
}
