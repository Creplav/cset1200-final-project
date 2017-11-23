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

/**
 * Created by ben on 11/8/17.
 */
public class Login {


     public static boolean isValid(String pw) {
        return pw.matches("[a-zA-Z0-9]{8,}");
}
    public void show(Stage stage){
        GridPane pane = new GridPane();
        stage.setTitle("Login");
        stage.setScene(new Scene(pane, 500, 300));
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
                boolean valid = true;
                for (int i = 1; i < rocketNumberField.getText().length() -1; i++)
                {
                     char l = rocketNumberField.getText().charAt(i);
                     if (rocketNumberField.getText().length() < 9 && !Character.isLetter(l) || !Character.isDigit(l))
                     {
                         pane.add(new Label("The password is not in the required format" +
                                 "\nFormat: R00000000"), 0, 5);
                        return;
                     }
                }
                if(nameField.getText().equals("") || rocketNumberField.getText().equals("")){
                    //TODO Keep this from constantly creating
                    pane.add(new Label("At least one required text field is empty"), 0,6);
                    return;
                }
                //((Node)(event.getSource())).getScene().getWindow().hide();
                Audit audit = new Audit();
                audit.show(stage);
            }
        });
    }
}