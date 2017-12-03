package sample;

/**
 * This class holds data on the student such as their name, rocket number, and year of school
 * @author Ben
 */
public class Student {
    // Name of the student
    private String name;
    // Rocket number for the student
    private String rocketNumber;

    /**
     * Creates a new student with a name, rocket number, and year of school
     * @param name
     * @param rocketNumber
     */

    public Student(String name, String rocketNumber){
        this.name = name;
        this.rocketNumber = rocketNumber;
    }

    /**
     * Gets the name of the student
     * @return name of the student
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the rocket number of the student
     * @return rocket number - String
     */
    public String getRocketNumber(){
        return rocketNumber;
    }
}
