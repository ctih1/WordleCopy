package xyz.ctih1.wordlecopygui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable  {

    private double yoff;
    private double xoff;

    @FXML
    private TextField inputField;

    @FXML
    private Button min;

    @FXML
    private Pane bar;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inputField.textProperty().addListener((observable, oldText, newText) -> {
            if(oldText.length() > newText.length()) {
                    KeyHandler.onCharDelete(newText.length());


            }
            if(!newText.contains("\n")) {
                KeyHandler.assignLetter(newText);
            }
            else {
                inputField.setText(inputField.getText().substring(0, inputField.getText().length() - 1));
            }
        });
    }



    @FXML
    public void onEnter(ActionEvent ae) {
        KeyHandler.evaluate();
        KeyHandler.row++;
        inputField.setText("");
        KeyHandler.pos = 0;
    }


}