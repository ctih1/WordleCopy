package xyz.ctih1.wordlecopygui;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;


public class KeyHandler {
    private static String words = "";
    private static ArrayList<String> returnList = new ArrayList<>();
    private static TextField field;
    static int row = 0;
    static int pos = 0;
    public static Scene root;

    public static String randomWord = RandomWord.getWord();
    public static void assignLetter(String text) {
        System.out.println(randomWord);
        if (pos > 4) {
            pos = 0;

        }
        System.out.println(randomWord);
        field = (TextField) root.lookup("#text" + String.valueOf(pos) + String.valueOf(row));
        System.out.println(field);
        if (text.length() > pos) {
            if(field!=null) {
                field.setText(String.valueOf(text.charAt(pos)));
                pos++;
            }

        }
    }


    public static void onCharDelete(int newLenght) {
        field = (TextField) root.lookup("#text" + String.valueOf(newLenght) + String.valueOf(row));
        field.setText("");
        pos--;
     }

     public static void evaluate() {
        words = "";
        for(int i = 0; i < 5; i++) {
            field = (TextField) root.lookup("#text" + String.valueOf(i) + String.valueOf(row));
            words += field.getText();
        }
        returnList.clear();
        returnList = Guess.checkGuess(String.valueOf(words),randomWord);
        System.out.println(returnList);
        for(int i = 0; i <5; i++) {
            field = (TextField) root.lookup("#text" + String.valueOf(i) + String.valueOf(row));
            if(returnList.get(i) == "0") {
                field.setBackground(Background.fill(Color.GRAY));
            }
            if(returnList.get(i) == "1") {
                field.setBackground(Background.fill((Color.GREEN)));
            }
            else if(returnList.get(i) == "2") {
                field.setBackground(Background.fill(Color.YELLOW));
            }
            else {
                System.out.println(returnList);
            }
        }


     }

}


