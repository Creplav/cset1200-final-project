package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * This class holds the GUI for the audit
 */
public class Audit {
    CourseController courseController;
    Student student;

    GridPane pane;

    Label nameLabel, rocketNumberLabel,
            currentTotalHoursLabel, remainingHoursLabel,
            remainingCETHoursLabel, remainingMATHHoursLabel,
            remainingENGTHoursLabel, remainingENGLHoursLabel,
            remainingPHYSHoursLabel, remainingElectiveHoursLabel;

    public Audit(Student student){
        courseController = new CourseController();
        this.student = student;
    }

    public void show(Stage primaryStage){

        // Set the title of the stage
        primaryStage.setTitle("Audit for " + student.getName());
        this.pane = new GridPane();
        primaryStage.setScene(new Scene(pane, 1050, 700));
        getCourses();
        addLabels(pane);
        primaryStage.show();
    }

    private void getCourses() {
        ArrayList<Course> courses;
        int row = 0;
        // Loop through year
        for(int i = 1; i < 5; i++){
            Label yearLabel = new Label(getYear(i));
            pane.add(yearLabel, 0, row);
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
    
    private String getYear(int year){
        switch(year){
            case 1: return "Freshman";
                break;
            case 2: return "Sophomore";
                break;
            case 3: return "Junior";
                break;
            case 4: return "Senior";
                break;
        }
    }

    private void addCourseButtons(GridPane pane, ArrayList<Course> courses, int row){
        int k = 0;
        for (Course course : courses) {
            Button button = new Button(course.getSubject() + course.getCourseCode() + '\n'
                    + course.getCreditHours() + " hours");
            button.setPrefSize(125, 75);
            button.setStyle("-fx-background-color: #AA0000");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(course.isCompleted()){
                        course.completed = false;
                        button.setStyle("-fx-background-color: #AA0000");
                    }
                    else {
                        course.completed = true;
                        button.setStyle("-fx-background-color: #00FF00");
                    }
                    updateLabels();
                }
            });

            pane.setHgap(10);
            pane.setVgap(10);
            pane.addColumn(k);
            pane.add(button, k, row);
            k++;
        }
    }

    private void addLabels(GridPane pane){
        nameLabel = new Label("Currently logged in as: ");
        rocketNumberLabel = new Label();
        currentTotalHoursLabel = new Label();
        remainingHoursLabel = new Label();
        remainingCETHoursLabel = new Label();
        remainingMATHHoursLabel = new Label();
        remainingENGTHoursLabel = new Label();
        remainingENGLHoursLabel = new Label();
        remainingPHYSHoursLabel = new Label();
        remainingElectiveHoursLabel = new Label();

        pane.setHgap(10);
        pane.setVgap(10);
        pane.add(nameLabel, 6, 0);
        pane.add(rocketNumberLabel, 6, 1);
        pane.add(currentTotalHoursLabel, 6, 2);
        pane.add(remainingHoursLabel, 6, 3);
        pane.add(remainingCETHoursLabel, 6, 4);
        pane.add(remainingMATHHoursLabel, 6, 5);
        pane.add(remainingENGTHoursLabel, 6, 6);
        pane.add(remainingENGLHoursLabel, 6, 7);
        pane.add(remainingPHYSHoursLabel, 6, 8);
        pane.add(remainingElectiveHoursLabel, 6, 9);
        updateLabels();

    }

    private void updateLabels() {
        nameLabel.setText("Currently logged in as: " + student.getName());
        rocketNumberLabel.setText("Rocket number: " + student.getRocketNumber().substring(
                student.getRocketNumber().length() - 4));
        currentTotalHoursLabel.setText("Total current hours: "
                + Integer.toString(courseController.getCurrentTotalHours()));
        remainingHoursLabel.setText("Total remaining hours: "
                + Integer.toString(courseController.getRemainingTotalHours()));
        remainingCETHoursLabel.setText("Remaining CET hours: "
                + Integer.toString(courseController.getRemainingSubjectHours("CET")));
        remainingMATHHoursLabel.setText("Remaining MATH hours: "
                + Integer.toString(courseController.getRemainingSubjectHours("MATH")));
        remainingENGTHoursLabel.setText("Remaining ENGT hours: "
                + Integer.toString(courseController.getRemainingSubjectHours("ENGT")));
        remainingENGLHoursLabel.setText("Remaining ENGL hours: "
                + Integer.toString(courseController.getRemainingSubjectHours("ENGL")));
        remainingPHYSHoursLabel.setText("Remaining PHYS hours: "
                + Integer.toString(courseController.getRemainingSubjectHours("PHYS")));
        remainingElectiveHoursLabel.setText("Remaining Elective hours: "
                + Integer.toString(courseController.getRemainingSubjectHours("Elective")));
    }
}
