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
     * @param year
     */
    public Student(String name, String rocketNumber, String year){
        this.name = name;
        this.rocketNumber = rocketNumber;
        this.year = year;
    }

    public String getName(){
        return name;
    }

    public String getRocketNumber(){
        return rocketNumber;
    }

    public String getYear(){
        return year;
    }
}
