package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by ben on 11/8/17.
 */
public class Audit {

    public void show(Stage primaryStage){

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("CSET", 1200, 3, true));
        courses.add(new Course("CSET", 3100, 3, false));
        courses.add(new Course("ENGT", 2100, 4, false));

        primaryStage.setTitle("Hello World");
        GridPane pane = new GridPane();
        primaryStage.setScene(new Scene(pane, 300, 275));
        int i = 0;
        for (Course course : courses) {
            Button button = new Button(course.getSubject() + course.getCourseCode() + '\n'
                    + course.getCreditHours() + " hours");
            button.setPrefSize(125, 75);
            if(course.isCompleted()){
                button.setStyle("-fx-background-color: #00FF00");
            }
            else button.setStyle("-fx-background-color: #990000");
            pane.setHgap(10);
            pane.setVgap(10);
            pane.addColumn(i);
            pane.add(button, i, 0);
            i++;
        }
        primaryStage.show();
    }
}
