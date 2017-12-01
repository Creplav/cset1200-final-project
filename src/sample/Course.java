package sample;

import java.util.ArrayList;

/**
 * This class holds course data such as the subject, course code, course name, and credit hours
 * @author Ben
 */
public class Course {
    //The course subject i.e. CET, MATH etc..
    private String subject;
    // The course code for the course i.e. 1100, 2040 etc..
    private int courseCode;
    // The number of credit hours for the course
    private int creditHours;
    // List of prereqs for the class
    private ArrayList<Course> prerequisites;
    // Full name of the course i.e "Intro to Engineering"
    private String courseName;
    // Boolean for course completion
    boolean completed;

    /**
     * Creates a new course with no prerequisites
     * @param subject
     * @param courseCode
     * @param creditHours
     * @param completed
     */
    public Course(String subject, int courseCode, int creditHours, String courseName, boolean completed){
        this.subject = subject;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
        this.courseName = courseName;
        this.completed = completed;
    }

    /**
     * Creates a new course with a list of prerequisites
     * @param subject
     * @param courseCode
     * @param creditHours
     * @param prerequisites
     * @param completed
     */
    public Course(String subject, int courseCode, int creditHours, ArrayList<Course> prerequisites, boolean completed){
        this.subject = subject;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
        this.prerequisites = prerequisites;
        this.completed = completed;
    }

    /**
     * Gets the subject of the course
     * @return subject
     */
    public String getSubject() { return this.subject; }

    /**
     * Gets the course code for the course
     * @return course code
     */
    public int getCourseCode() { return this.courseCode;}

    /**
     * Gets the number of credit hours for the course
     * @return credit hours
     */
    public int getCreditHours() { return  this.creditHours; }

    /**
     * Gets the course name
     * @return course name - String
     */
    public String getCourseName() { return this.courseName; }

    /**
     * Gets all the prerequisites the course has
     * @return prerequisites
     */
    public ArrayList<Course> getPrerequisites() { return this.prerequisites; }

    /**
     * Checks to see if the course has been completed
     * @return completed
     */
    public boolean isCompleted() { return this.completed; }

    /**
     * Checks to see if all of the prerequisites have been met
     * @return true or false
     */
    public boolean prerequisitesCompleted() {
        int completed = 0;
        for(Course course : this.prerequisites){
            if(course.isCompleted())
                completed++;
        }
        return completed == this.prerequisites.size();
    }
}
