package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.xml.soap.Text;

/**
 * Created by ben on 11/8/17.
 */
public class Login {

    // Variables to check if their has already been a warning message
    int incorrectFormatCount = 0;
    int emptyWarningCount = 0;
    Label emptyLabel;

    public void show(Stage stage){
        GridPane pane = new GridPane();
        stage.setTitle("Login");
        stage.setScene(new Scene(pane, 700, 300));
        pane.getStylesheets().add("sample/custom.css");
        TextField nameField = new TextField();
        PasswordField rocketNumberField = new PasswordField();
        pane.add(new Label("Login"), 1, 0);
        pane.add(new Label("Please enter your name: "), 0, 1);
        pane.add(nameField, 1, 1);
        pane.add(new Label("Please enter your Rocket Number: "), 0, 2);
        pane.add(rocketNumberField, 1, 2);
        //pane.add(new ComboBox<String>().setItems(), 0, 3);
        Button button = new Button("Done");
        pane.add(button, 0, 4);
        stage.show();



        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                // Make sure no field is empty
                if(isFieldEmpty(rocketNumberField, nameField)){
                    if (emptyWarningCount < 1) {
                        emptyLabel = new Label("At least one required text field is empty");
                        pane.add(emptyLabel, 0, 6);
                        emptyWarningCount++;
                        return;
                    }
                }

                // Make sure rocketNumberField is valid
                if (isRocketNumberValid(rocketNumberField)) {
                    Student student = new Student(nameField.getText(), rocketNumberField.getText(), "Freshman");
                    //((Node)(event.getSource())).getScene().getWindow().hide();
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


    private boolean isRocketNumberValid(TextField rocketNumberField){
        if(rocketNumberField.getText().length() == 9){
            if(rocketNumberField.getText().charAt(0) == 'R'){
                int count = 0;
                for(int i = 1; i < 9; i++){
                    if(Character.isDigit(rocketNumberField.getText().charAt(i))){
                        count++;
                    }
                }
                if(count == 8){
                 return true;
                }
            }
        }

        return false;
    }
}