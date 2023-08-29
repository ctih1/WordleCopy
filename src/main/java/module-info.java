module xyz.ctih1.wordlecopygui {
    requires javafx.controls;
    requires javafx.fxml;


    opens xyz.ctih1.wordlecopygui to javafx.fxml;
    exports xyz.ctih1.wordlecopygui;
}