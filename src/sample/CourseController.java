package sample;

import java.util.ArrayList;

/**
 * This class holds all of the courses for the CET degree
 * The course controller manages all of the courses required for the degree.
 * It handles add the courses to the lists of courses.
 * Courses are broken down into year and further into semesters.
 * The courses can be accessed by calling {@code getCourseList(int year, int semester)}
 */
public class CourseController {
	// Create lists for the courses broken down by year and semester
	private ArrayList<Course> freshman1 = new ArrayList<>();
	private ArrayList<Course> freshman2 = new ArrayList<>();
	private ArrayList<Course> sophomore1 = new ArrayList<>();
	private ArrayList<Course> sophomore2 = new ArrayList<>();
	private ArrayList<Course> junior1 = new ArrayList <>();
	private ArrayList<Course> junior2 = new ArrayList<>();
	private ArrayList<Course> senior1 = new ArrayList<>();
	private ArrayList<Course> senior2 = new ArrayList<>();

	/**
	 * Creates a new CourseController
	 */
	public CourseController(){
		addCourses();
	}

	//A new object called "elective" has been introduced which extends the course object.

	/**
	 * Adds all the courses to the lists
	 */
	private void addCourses(){
		addFreshmanCourses();
		addSophomoreCourses();
		addJuniorCourses();
		addSeniorCourses();
	}

	/**
	 * Adds courses to freshman level course lists
	 */
	private void addFreshmanCourses(){
		// Freshman year first semester
		freshman1.add(new Course("ENGT", 1000, 1, false));
		freshman1.add(new Course("MATH", 1330, 3, false));
		freshman1.add(new Course("ENGL", 1110, 3, false));
		freshman1.add(new Course("CET", 1100, 3, false));
		freshman1.add(new Course("CET", 1150, 3, false));
		freshman1.add(new Course("CET", 1010, 1, false));
		// Freshman Year second semester
		freshman2.add(new Course("PHYS", 2010, 5, false));
		freshman2.add(new Course("CET", 1210, 3, false));
		freshman2.add(new Course("ENGL", 2950, 3, false));
		freshman2.add(new Course("CET",1250, 3, false));
		freshman2.add(new Course("Elective", 1000, 3, false));
	}

	/**
	 * Adds courses to sophomore level course lists
	 */
	private void addSophomoreCourses(){
		// Sophomore year first semester
		sophomore1.add(new Course("PHYS", 2020, 5, false));
		sophomore1.add(new Course("CET", 1200, 4, false));
		sophomore1.add(new Course("MATH", 2450, 4, false));
		sophomore1.add(new Course("CET", 2110, 3, false));
		// Sophomore year second semester
		sophomore2.add(new Course("CET", 2060, 3, false));
		sophomore2.add(new Course("CET", 2250, 4, false));
		sophomore2.add(new Course("CET", 2030, 3, false));
		sophomore2.add(new Course("CET", 2220, 3, false));
		sophomore2.add(new Course("Elective", 2000, 3, false));
	}

	/**
	 * Adds courses to junior level courses lists
	 */
	private void addJuniorCourses(){
		// First semester
		junior1.add(new Course("CET", 3210, 3, false));
		junior1.add(new Course("MATH", 2460, 4, false));
		junior1.add(new Course("CET", 3010, 4, false));
		junior1.add(new Course("Elective", 3000, 3, false));
		junior1.add(new Course("Elective", 3100, 3, false));
		// Second semester
		junior2.add(new Course("Elective", 3200, 3, false));
		junior2.add(new Course("CET", 3160, 3, false));
		junior2.add(new Course("ENGT", 3010, 4, false));
		junior2.add(new Course("CET", 3220, 3, false));
		junior2.add(new Course("CET", 3120, 3, false));
	}

	/**
	 * Adds classes for both senior class lists
	 */
	private void addSeniorCourses(){
		// First semester
		senior1.add(new Course("CET", 4460, 3, false));
		senior1.add(new Course("CET", 4250, 4, false));
		senior1.add(new Course("ENGT", 3600, 3, false));
		senior1.add(new Course("Elective", 4000, 3, false));
		senior1.add(new Course("Elective", 4100, 3, false));

		// Second semester
		senior2.add(new Course("ENGT", 4050, 3, false));
		senior2.add(new Course("CET", 4350, 4, false));
		senior2.add(new Course("Elective", 4200, 3, false));
		senior2.add(new Course("Elective", 4300, 3, false));
		senior2.add(new Course("Elective", 4400, 3, false));
	}

	/**
	 * Gets the array list holding the courses for the specified year and semester
	 * @param year The year of school
	 *             1 - Freshman
	 *             2 - Sophomore
	 *             3 - Junior
	 *             4 - Senior
	 * @param semester The semster within the year of school
	 *                 1 - Fall semester
	 *                 2 - Spring semester
	 * @return The chosen list - defaults to fall of freshman year
	 */
	public ArrayList<Course> getCourseList(int year, int semester){
		// Check to see the year and semester and return the correct one
		// Freshman
		if(year == 1){
			if(semester == 1)
				return freshman1;
			else
				return freshman2;
		}
		// Sophomore
		else if(year == 2){
			if(semester == 1)
				return sophomore1;
			else
				return sophomore2;
		}
		// Junior
		else if(year == 3){
			if(semester == 1)
				return junior1;
			else
				return junior2;
		}
		// Senior
		else if(year == 4){
			if(semester == 1)
				return senior1;
			else
				return senior2;
		}
		// Default to fall freshman year
		else return freshman1;
	}
}
