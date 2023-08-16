package xyz.ctih1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
public class Main {
	static RandomWord randomWord = new RandomWord();
	static Guess guess = new Guess();
	static String correctWord;
	public static void main(String[] args) {
		try {
			randomWord.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
		run();
	}
	public static void run() {
		correctWord = randomWord.GetRandomWord();
		for(int i = 0; i < 5; i ++) {
			guess.GetGuess();
		}
	}
	

	
}
