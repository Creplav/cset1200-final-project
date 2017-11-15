package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * This class holds the GUI for the audit
 */
public class Audit {
    CourseController courseController;

    GridPane pane;
    public Audit(){
        courseController = new CourseController();
    }

    public void show(Stage primaryStage){

        // Set the title of the stage
        primaryStage.setTitle("Audit for ");
        this.pane = new GridPane();
        primaryStage.setScene(new Scene(pane, 750, 600));
        getCourses();
        primaryStage.show();
    }

    private void getCourses() {
        ArrayList<Course> courses;
        int row = 0;
        // Loop through year
        for(int i = 1; i < 5; i++){
            // Loop through semester
            for(int j = 1; j < 3; j++){
                // Get the correct courses
                courses = courseController.getCourseList(i, j);
                // Add the buttons
                addCourseButtons(pane, courses, row);
                // Add a new row
                row++;
            }
        }
    }

    private void addCourseButtons(GridPane pane, ArrayList<Course> courses, int row){
        int k = 0;
        for (Course course : courses) {
            Button button = new Button(course.getSubject() + course.getCourseCode() + '\n'
                    + course.getCreditHours() + " hours");
            button.setPrefSize(125, 75);
            if (course.isCompleted()) {
                button.setStyle("-fx-background-color: #00FF00");
            } else button.setStyle("-fx-background-color: #AA0000");
            pane.setHgap(10);
            pane.setVgap(10);
            pane.addColumn(k);
            pane.add(button, k, row);
            k++;
        }
    }
}
