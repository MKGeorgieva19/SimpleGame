module com.game.simplegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.game.simplegame to javafx.fxml;
    exports com.game.simplegame;
}