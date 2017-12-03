package sample;

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
    // Full name of the course i.e "Intro to Engineering"
    private String courseName;
    // Boolean for course completion
    boolean completed;

    /**
     * Creates a new course
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
     * Checks to see if the course has been completed
     * @return completed
     */
    public boolean isCompleted() { return this.completed; }

}
