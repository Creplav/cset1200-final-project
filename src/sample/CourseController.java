public class CourseController {
	//A new object called "elective" has been introduced which extends the course object
		private static class freshman1{
			Course course1 = new Course("ENGT", 1000, 1);
			Course course2 = new Course("MATH", 1330, 3);
			Course course3 = new Course("ENGL", 1110, 3);
			Course course4 = new Course("CET", 1100, 3);
			Course course5 = new Course("CET", 1150, 3);
			Course course6 = new Course("CET", 1010, 1);
		}
		private static class freshman2{
			Course course7 = new Course("PHYS", 2010, 5);
			Course course8 = new Course("CET", 1210, 3);
			Course course9 = new Course("ENGL", 2950, 3);
			Course course10 = new Course("CET",1250, 3);
			Course elective1 = new Course("Elective", 1000, 3)
		}
		private static class sophomore1{
			Course course11 = new Course("PHYS", 2020, 5);
			Course course12 = new Course("CET", 1200, 4);
			Course course13 = new Course("MATH", 2450, 4);
			Course course14 = new Course("CET", 2110, 3);			
		}
		private static class sophomore2{
			Course course15 = new Course("CET", 2060, 3);
			Course course16 = new Course("CET", 2250, 4);
			Course course17 = new Course("CET", 2030, 3);
			Course course18 = new Course("CET", 2220, 3);
			Course elective2 = new Course("Elective", 2000, 3);
		}
		private static class junior1{
			Course course19 = new Course("CET", 3210, 3);
			Course course20 = new Course("MATH", 2460, 4);
			Course course21 = new Course("CET", 3010, 4);
			Course elective3 = new Course("Elective", 3000, 3);
			Course elective4 = new Course("Elective", 3100, 3);
		}
		private static class junior2{
			Course elective5 = new Course("Elective", 3200, 3);
			Course course22 = new Course("CET", 3160, 3);
			Course course23 = new Course("ENGT", 3010, 4);
			Course course24 = new Course("CET", 3220, 3);
			Course course25 = new Course("CET", 3120, 3);	
		}
		private static class senior1{
			Course course26 = new Course("CET", 4460, 3);
			Course course27 = new Course("CET", 4250, 4);
			Course course28 = new Course("ENGT", 3600, 3);
			Course elective6 = new Course("Elective", 4000, 3);
			Course elective7 = new Course("Elective", 4100, 3);
		}
		private static class senior2{	
			Course course29 = new Course("ENGT", 4050, 3);
			Course course30 = new Course("CET", 4350, 4);
			Course elective7 = new Course("Elective", 4200, 3);
			Course elective8 = new Course("Elective", 4300, 3);
			Course elective9 = new Course("Elective", 4400, 3);
		}
}
