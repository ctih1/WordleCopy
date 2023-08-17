package xyz.ctih1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomWord {
	int wordsLenght;
	int index;
	Random random = new Random();
	static List<String> words = new ArrayList<String>();
	public void init() throws IOException {
		InputStream inputStream = RandomWord.class.getResourceAsStream("/xyz/ctih1/resources/words.txt");
		if (inputStream != null) {
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
				String line;
				while((line = reader.readLine()) != null) {
					words.add(line);
				}
			}
       	catch (IOException e) {
            e.printStackTrace();
       	}		
		}
		else {
            throw new RuntimeException("Failed to load words!");
        }
		
	}
	
	public String GetRandomWord() {
		wordsLenght = words.size();
		index = random.nextInt(wordsLenght + 1);
		
		return words.get(index);
	}
	
}
