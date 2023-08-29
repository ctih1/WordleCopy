package xyz.ctih1.wordlecopygui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomWord {
    static int wordsLenght;
    static int index;
    static Random random = new Random();
    static List<String> words = new ArrayList<String>();
    public static void init() throws IOException {
        InputStream inputStream = RandomWord.class.getResource("words.txt").openStream();
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
        }

    }

    public static String getWord() {
        wordsLenght = words.size();
        index = random.nextInt(wordsLenght + 1);

        return words.get(index);
    }

}
