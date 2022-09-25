package Project1Package;
public class CourseTester {

	CourseList list;
	private Course course1 = new Course("CSDS233", "Intro to Data Structures", 200);
	private Course course2 = new Course("CSDS302", "Discrete Mathematics", 50);
	private Course course3 = new Course("PHYS122", "Electricity and Magnetism", 250);
	private Course course4 = new Course("MATH223", "Calculus for Science and Engineering III", 30);
	private Course course5 = new Course("ENGR145", "Chemistry of Materials", 100);
	private Course course6 = new Course("CHEM111", "Principles of Chemistry for Engineers", 300);
	private Course course7 = new Course("USSY294H", "Mapping Spaces and Mobility", 17);
	private Course course8 = new Course("CSDS132", "Introduction to Java", 200);
	private Course course9 = new Course("MATH121", "Calculus for Science and Engineering I", 400);
	private Course course10 = new Course("MATH122", "Calculus for Science and Engineering II", 300);
	private Course course11 = new Course("LOL420", "Victor's Meme Course", 420);
	
	public static void main(String[] args) {
		CourseTester test = new CourseTester();
		System.out.println("THE TESTER IS CREATING A LIST OF COURSES TO TEST.");
		System.out.println("");
		test.fillList();
		System.out.println("");
		System.out.println("THE TESTS ARE NOW RUNNING.");
		System.out.println("");
		System.out.println("TESTING THE size METHOD");
		System.out.println("");
		test.testSize();
		System.out.println("");
		System.out.println("TESTING THE addCourse METHOD");
		System.out.println("");
		test.testAddCourse();
		System.out.println("");
		System.out.println("TESTING THE removeCourse METHOD");
		System.out.println("");
		test.testRemoveCourse();
		System.out.println("");
		System.out.println("TESTING THE changeCapacity METHOD");
		System.out.println("");
		test.testChangeCapacity();
		System.out.println("");
		System.out.println("TESTING THE getCourseWithIndex METHOD");
		System.out.println("");
		test.testGetCourseWithIndex();
		System.out.println("");
		System.out.println("TESTING THE searchCourseID METHOD");
		System.out.println("");
		test.testSearchCourseID();
		System.out.println("");
		System.out.println("TESTING THE searchCourseName() METHOD");
		System.out.println("");
		test.testSearchCourseName();
		System.out.println("");
		System.out.println("THE TESTS ARE NOW COMPLETE.");
	}
	
	public void fillList() {
		list = new CourseList();
		list.addCourse(0, course1);
		list.addCourse(1, course2);
		list.addCourse(2, course3);
		list.addCourse(3, course4);
	}
	
	public void testSize() {
		System.out.println("The size of the list is " + list.size() + ".");
		System.out.println("");
	}
	
	public void testAddCourse() {
		list.addCourse(0, course5); //add to the start of the list
		list.addCourse(2, course6); //add to the middle of the list
		list.addCourse(9, course7); //add at an index greater than the current list size
		list.addCourse(99, course8); //attempt to add at an out of range index, will fail.
		list.addCourse(list.size(), course8); //this and the next two lines are to fill up the list.
		list.addCourse(list.size(), course9);
		list.addCourse(list.size(), course10);
		list.addCourse(10, course11); //attempt to add to a full list, will fail. 
	}
	
	public void testRemoveCourse() {
		list.removeCourse(0); //remove the start of the list
		list.removeCourse(2); //remove an existing course
		list.removeCourse(10); //now that index 10 has no course, attempt to remove it, will fail.
		list.removeCourse(99); //attempt to remove a course at a nonexistent index, will fail.
	}
	
	public void testChangeCapacity() {
		list.changeCapacity("PHYS122", 87); //change the capacity of an existing course
		list.changeCapacity("LOL420", 888); //attempt to change the capacity of a nonexistent course, fails and does nothing.
	}
	
	public void testGetCourseWithIndex() {
		list.getCourseWithIndex(1);
		list.getCourseWithIndex(10);
		list.getCourseWithIndex(99);
	}
	
	public void testSearchCourseID() {
		list.SearchCourseID("MATH223"); //search for an existing course
		list.SearchCourseID("LOL420"); //search for a nonexistent course
	}
	
	public void testSearchCourseName() {
		list.SearchCourseName("Intro to Data Structures"); //search for an existing course
		list.SearchCourseName("Victor's Meme Course"); //search for a nonexistent course
	}

}
