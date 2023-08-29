package xyz.ctih1.wordlecopygui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable  {

    @FXML
    private TextField inputField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inputField.textProperty().addListener((observable, oldText, newText) -> {
            if(oldText.length() > newText.length()) {
                KeyHandler.onCharDelete(newText.length());
            }
            KeyHandler.assignLetter(newText);
        });
    }

    @FXML
    public void onEnter(ActionEvent ae) {
        inputField.clear();
        KeyHandler.row++;
    }
}