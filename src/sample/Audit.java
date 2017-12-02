package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * This class holds the GUI for the audit
 */
public class Audit {
    // Course controller to access all the courses in the degree
    private CourseController courseController;
    // Student to make audit for
    private Student student;
    // Grid pane to align objects
    private GridPane pane;
    //add grid pane inside scroll pane    
    ScrollPane sp = new ScrollPane();
    sp.setContent(pane);

    // Labels to display information to the user
    private Label nameLabel, rocketNumberLabel,
            currentTotalHoursLabel, remainingHoursLabel,
            remainingCETHoursLabel, remainingMATHHoursLabel,
            remainingENGTHoursLabel, remainingENGLHoursLabel,
            remainingPHYSHoursLabel, remainingElectiveHoursLabel;

    /**
     * Creates a new audit for the specified student
     * @param student student to make audit for
     */
    public Audit(Student student){
        // Creates a new course controller and assigns student
        courseController = new CourseController();
        this.student = student;
    }

    /**
     * Displays the audit to the user
     * @param primaryStage stage to show audit on
     */
    public void show(Stage primaryStage){

        // Set the title of the stage
        primaryStage.setTitle("Audit for " + student.getName());
        // Create a new grid pane
        this.pane = new GridPane();
        // Set the scene with width and height
        primaryStage.setScene(new Scene(pane, 1050, 700));
        // Get courses and add buttons
        getCourses();
        // Add all the labels
        addLabels(pane);
        // Show the audit
        primaryStage.show();
    }

    /**
     * Gets all of the courses within the degree and creates a button for them.
     * Adds labels to separate courses by year
     */
    private void getCourses() {
        ArrayList<Course> courses;
        int row = 0;
        // Loop through year
        for(int i = 1; i < 5; i++){
            Label yearLabel = new Label(getYear(i));
            //adding labels to divide student's status (i.e. freshman, sophomore, etc.)
            pane.add(yearLabel, 0, row);
            row++;
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

    /**
     * Gets the year of the student
     * @param year year of student in number format
     *             1 - freshman
     *             2 - sophomore
     *             3 - junior
     *             4 - senior
     * @return String representation of the year of the student
     */
    private String getYear(int year){
        switch(year){
            case 1: return "Freshman";               
            case 2: return "Sophomore";              
            case 3: return "Junior";               
            case 4: return "Senior";             
        }
        // Return null in the case that an incorrect year has been passed
        return null;
    }

    /**
     * Adds all of the courses buttons to the pane
     * @param pane pane to add buttons to
     * @param courses course list to use for adding buttons
     * @param row row to put button on
     */
    private void addCourseButtons(GridPane pane, ArrayList<Course> courses, int row){
        // Variable for specifying the column
        int column = 0;
        // Loop through each course
        for (Course course : courses) {
            // Create a new button with information on the course
            Button button = new Button(course.getSubject() + course.getCourseCode() + '\n'
                    + course.getCourseName() + '\n'
                    + course.getCreditHours() + " hours");
            button.wrapTextProperty().set(true);
            button.setPrefSize(125, 125);
            // Default the color to red
            button.setStyle("-fx-background-color: #AA0000");
            // Runs when the button is clicked
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    // Reset the course to not completed and change color back to red
                    if(course.isCompleted()){
                        course.completed = false;
                        button.setStyle("-fx-background-color: #AA0000");
                    }
                    // Set the course to completed and change the color to green
                    else {
                        course.completed = true;
                        button.setStyle("-fx-background-color: #00FF00");
                    }
                    // Update all the labels
                    updateLabels();
                    // Check to see if the user has completed all the requirements and can graduate
                    if(courseController.getRemainingTotalHours() == 0){
                        // Display congratulatory message
                        displayCompleted();
                    }
                }
            });
            // Add some spacing between the buttons
            pane.setHgap(10);
            pane.setVgap(10);
            // Add a new column
            pane.addColumn(column);
            // Add the button to the pane
            pane.add(button, column, row);
            // Increase the column
            column++;
        }
    }

    /**
     * Adds all of the labels to the audit to display information to the user
     * @param pane pane to add the labels to
     */
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

        // Create spacing for the labels
        pane.setHgap(10);
        pane.setVgap(10);
        // Add all of the labels - add(label, column, row)
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
        // Update all the labels to given them the proper text
        updateLabels();

    }

    /**
     * Updates all of the labels to display the proper text
     */
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

    /**
     * Displays a congratulatory message that the student has completed their degree and can graduate
     * Opens a new dialog window with the message
     */
    private void displayCompleted(){
        Dialog dialog = new Dialog();
        // When x is clicked in title bar close the window
        dialog.getDialogPane().getScene().getWindow().setOnCloseRequest(event -> dialog.close());
        // Make sure that all of the content will fit on to the dialog pane
        dialog.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        // Set the title
        dialog.setTitle("Congratulations!");
        // Add an okay button to the dialog
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        // Display the message
        dialog.contentTextProperty().setValue("Congratulations! You have completed all the requirements for your degree!\n" +
                "You can now graduate!");
        // Show the dialog and wait for user event
        dialog.showAndWait();
    }
}
