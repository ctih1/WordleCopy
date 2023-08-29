package xyz.ctih1.wordlecopygui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class KeyHandler {

    private static TextField field;
    static int row = 0;
    static int pos = 0;
    public static Scene root;

    public static void assignLetter(String text) {

        if(pos > 4) {
            pos = 0;
        }
        field = (TextField) root.lookup("#text" + String.valueOf(pos) + String.valueOf(row));
        field.setText(String.valueOf(text.charAt(pos)));
        pos++;
    }

    public static void onCharDelete(int newLenght) {
        field = (TextField) root.lookup("#text" + String.valueOf(newLenght) + String.valueOf(row));
        field.setText("");
        pos--;
     }
    public static void newLine() {
        pos = 0;
        row++;

    }
}


