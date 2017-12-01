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
    // Year of the student i.e. Freshman, Sophomore, etc...
    private String year;

    /**
     * Creates a new student with a name, rocket number, and year of school
     * @param name
     * @param rocketNumber
     * @param year String value
     *             Can be:
     *             1 - Freshman
     *             2 - Sophomore
     *             3 - Junior
     *             4 - Senior
     */
    public Student(String name, String rocketNumber, String year){
        this.name = name;
        this.rocketNumber = rocketNumber;
        this.year = year;
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

    /**
     * Gets the year of school that the student is in
     * @return year of school - String
     */
    public String getYear(){
        return year;
    }
}
