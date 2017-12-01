package sample;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class for the application.
 * Runs the program
 */
public class Main extends Application {

    // Starts the JavaFX application
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creates a new login screen
        Login login = new Login();
        // Show the login screen
        login.show(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
