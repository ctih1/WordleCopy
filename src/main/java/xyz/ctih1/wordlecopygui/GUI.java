package xyz.ctih1.wordlecopygui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class GUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("view.fxml"));
        Scene scene = new Scene((Parent) (fxmlLoader.load()), 320, 240);
        KeyHandler.root = scene;
        stage.setTitle("Wordle Copy");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        RandomWord.init();
        launch();

    }
}