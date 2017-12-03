package sample;

import javafx.application.Application;
import javafx.stage.Stage;

/*
 * ==========
 * The program
 * ==========
 * This program creates an degree audit for the CET degree
 * The first step is to create a login screen that the user can use
 * to login with. A student class instance is then created using the
 * information entered in the login screen. After that the audit is
 * created and displayed. Buttons can be clicked to mark courses as
 * completed.
 * There is the CourseController class that holds all of the courses
 * together and allows certain courses to be accessed if needed.
 *
 * Created by Ben Doty, Naba Rizvi, and Chris Hansen
 */

/**
 * Main class for the application.
 * Runs the program
 * @author Ben
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
