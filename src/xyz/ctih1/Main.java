package xyz.ctih1;

import java.io.IOException;
public class Main {
	static RandomWord randomWord = new RandomWord();
	static Guess guess = new Guess();
	static String correctWord;
	String className = this.getClass().getSimpleName();
	public static void main(String[] args) {
		try {
			randomWord.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Guess.forceActualWords = false;
		run();
	}
	public static void run() {
		correctWord = randomWord.getWord();
		for(int i = 0;i < 5 ; i++) {
		
		guess.setWord(correctWord);
		guess.guess();
		}
		
	}
	

	
}
