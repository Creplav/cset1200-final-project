package sample;


import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * This class holds the GUI for the login screen
 * @author Ben, Naba, Chris
 */
public class Login {

    // Variables to check if their has already been a warning message
    private int incorrectFormatCount = 0;
    private int emptyWarningCount = 0;
    // Label for warning the user that a text field is empty
    private Label emptyLabel;

    /**
     * Shows the login screen
     * @param stage the stage to use for the pane
     */
    public void show(Stage stage){
        // Create a new pane for lining up objects
        GridPane pane = new GridPane();

        // Set the title, width and height
        stage.setTitle("Login");
        stage.setScene(new Scene(pane, 700, 300));

        // Add a stylesheet to the pane to make it look pretty
        pane.getStylesheets().add("sample/custom.css");

        // Create a new text field for the user to enter their name and rocket number
        TextField nameField = new TextField();
        PasswordField rocketNumberField = new PasswordField();

        // Add all of the labels and text fields - add(object, column, row)
        pane.add(new Label("Login"), 1, 0);
        pane.add(new Label("Please enter your name: "), 0, 1);
        pane.add(nameField, 1, 1);
        pane.add(new Label("Please enter your Rocket Number: "), 0, 2);        pane.add(rocketNumberField, 1, 2);


        // Create a button to login with and add it to the pane
        Button button = new Button("Login");
        pane.add(button, 0, 4);

        // Show the stage
        stage.show();

        // Runs with the button has been clicked
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                // Make sure no field is empty
                if(isFieldEmpty(rocketNumberField, nameField)){
                    // If a field is empty display a warning to the user
                    if (emptyWarningCount < 1) {
                        emptyLabel = new Label("At least one required field is empty");
                        pane.add(emptyLabel, 0, 6);
                        // Variable to prevent duplication of the label
                        emptyWarningCount++;
                        return;
                    }
                }

                // Make sure rocketNumberField is valid
                if (isRocketNumberValid(rocketNumberField)) {
                    // Create a new student with the corresponding information
                    Student student = new Student(nameField.getText(), rocketNumberField.getText(), "Freshman");
                    // Create and show the audit for that student
                    Audit audit = new Audit(student);
                    audit.show(stage);
                }

                // Warn the user something is wrong
                else {
                    if (incorrectFormatCount < 1) {
                        // Remove empty label
                        if (emptyWarningCount == 1) {
                            pane.getChildren().remove(emptyLabel);
                            emptyWarningCount--;
                        }

                        // Warn the user that they have not imputed the correct format
                        pane.add(new Label("The Rocket Number is not in the required format" +
                                "\nFormat: R00000000"), 0, 5);
                        incorrectFormatCount++;
                    }
                }


            }

        });
    }

    /**
     * Checks if one of the text fields are empty
     * @param rocketNumberField text field for Rocket number
     * @param nameField text field for student name
     * @return
     * field text size.
     * if 0 returns false
     * else true
     */
    private boolean isFieldEmpty(TextField rocketNumberField, TextField nameField){
        return (nameField.getText().equals("") || rocketNumberField.getText().equals(""));
    }

    /**
     * Checks if the rocket number is entered in the correct format
     * @param rocketNumberField the text field for the rocket number
     * @return valid or not - boolean value
     */
    private boolean isRocketNumberValid(TextField rocketNumberField){
        // Make sure the length is 9 because a rocket number is 9 characters long
        if(rocketNumberField.getText().length() == 9){
            // Make sure the first character is an uppercase R
            if(rocketNumberField.getText().charAt(0) == 'R'){
                // Variable for checking how many characters are numbers
                int count = 0;
                // Make sure that all characters after the R are numbers
                for(int i = 1; i < 9; i++){
                    // If the character is a digit add it to the count
                    if(Character.isDigit(rocketNumberField.getText().charAt(i))){
                        count++;
                    }
                    // If something wasn't a number there is no sense in continuing the loop
                    else break;
                }
                // If there are 8 numbers after the R return true
                if(count == 8){
                 return true;
                }
            }
        }
        // If something was correct we return false
        return false;
    }
}