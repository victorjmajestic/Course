package Project1Package;
public class CourseList {
	
	public Course[] listofCourses = new Course[10];
	
	public CourseList() {
	}
	
	public CourseList(Course[] listofCourses) {
		this.listofCourses = listofCourses;
	}
	
	public int size() {
		int count = 0; //to store the number of elements in the list
		for (int i = 0; i < listofCourses.length; i++) {
			if (listofCourses[i] != null)
				count = count + 1; //increases every time there is an element in the list as it iterates through the array
		}
		return count;
	}
	
	public void addCourse(int i, Course course) {
		System.out.println("Operation: Add a course at index " + i + ".");
		System.out.println("Course ID: " + course.getCourseID() + ". Course Name: " + course.getCourseName()
		+ ". Capacity: " + course.getCapacity() + "."); //prints the course to be added
		System.out.println("");
		System.out.println("List before the operation:");
		for (int k=0; k<size(); k++) {
			System.out.println(k + ". Course ID: " + listofCourses[k].getCourseID() + ". Course Name: " +
		    listofCourses[k].getCourseName() + ". Capacity: " + listofCourses[k].getCapacity() + "");
		} //prints the list before the operation
		System.out.println("");
		System.out.println("List after the operation: ");
	    if (size() == listofCourses.length) {
	    	System.out.println("The course list is full. You cannot add any more courses.");
	    } //indicates that the course cannot be added and ends the operation.
	    else if (i > listofCourses.length) {
	    	System.out.println("There is no index " + i + " in this list. The course was not added.");
	    } //indicates that the index is invalid and ends the operation.
	    else if (i > size())
			listofCourses[size()] = course; //adds to the end of the list if i is greater than the list size and ends the operation.
		else {
			for (int j = size() - 1; j >= i; j--) {
				listofCourses[j+1] = listofCourses[j]; /*starts at the end of the list size and shifts all elements up the list if
				an element is in the middle of the list. */
			}
			listofCourses[i] = course; //finally, sets the index i to the desired course and finishes the operation.
		}
		for (int k=0; k<size(); k++) {
			System.out.println(k + ". Course ID: " + listofCourses[k].getCourseID() + ". Course Name: " +
		    listofCourses[k].getCourseName() + ". Capacity: " + listofCourses[k].getCapacity() + ".");
		} //prints the completed list after the operation
		System.out.println("");
	}
	
	public boolean removeCourse(int i) {
		System.out.println("Operation: Remove a course at index " + i + ".");
		System.out.println("List before the operation:");
		for (int k=0; k<size(); k++) {
			System.out.println(k + ". Course ID: " + listofCourses[k].getCourseID() + ". Course Name: " +
		    listofCourses[k].getCourseName() + ". Capacity: " + listofCourses[k].getCapacity() + "");
		} //prints the list before the operation
		System.out.println("");
		if (size() < i) {
			System.out.println("There is no course at the index " + i + ".");
			System.out.println("");
			return false;
		} //checks if i is an invalid index or an index with no course, indicates the invalidity and ends the operation.
		for (int j=i+1; j<size(); j++) {
			listofCourses[j-1] = listofCourses[j]; //shifts all courses back in the list by one, thus removing the course.
			if (j == size()-1)
				listofCourses[j] = null; //sets the final element to null so it does not repeat twice
		}
		System.out.println("List after the operation: ");
		for (int k=0; k<size(); k++) {
			System.out.println(k + ". Course ID: " + listofCourses[k].getCourseID() + ". Course Name: " +
		    listofCourses[k].getCourseName() + ". Capacity: " + listofCourses[k].getCapacity() + "");
		} //prints the list after the operation
		System.out.println("");
		return true;
	}
	
	public boolean changeCapacity(String courseID, int capacity) {
		boolean result = false; /*to indicate the result of the operation. defaults false and will return true if the
		operation is successful.*/
		System.out.println("Operation: Change the capacity of the course " + courseID + " in the list.");
		System.out.println("List before the operation:");
		for (int k=0; k<size(); k++) {
			System.out.println(k + ". Course ID: " + listofCourses[k].getCourseID() + ". Course Name: " +
		    listofCourses[k].getCourseName() + ". Capacity: " + listofCourses[k].getCapacity() + "");
		} //prints the list before the operation
		System.out.println("");
		for (int i=0; i<size(); i++) {
			if (listofCourses[i].getCourseID() == courseID)
				listofCourses[i].setCapacity(capacity); //changes the capacity if the course is in the list
			result = true;
		}
		System.out.println("List after the operation: ");
		for (int k=0; k<size(); k++) {
			System.out.println(k + ". Course ID: " + listofCourses[k].getCourseID() + ". Course Name: " +
		    listofCourses[k].getCourseName() + ". Capacity: " + listofCourses[k].getCapacity() + "");
		} //prints the list after the operation
		System.out.println("");
		return result;
	}
	
	public Course getCourseWithIndex(int i) {
		System.out.println("Operation: Return the course at index " + i + " in the list.");
		if (size() < i) {
			System.out.println("There is no course at this index.");
			System.out.println("");
			return null; //checks if the index is empty and ends the operation if it does.
		}
		System.out.println("Course ID: " + listofCourses[i].getCourseID() + ". Course Name: " + listofCourses[i].getCourseName()
				+ ". Capacity: " + listofCourses[i].getCapacity() + "."); //prints the course
		System.out.println("");
		return listofCourses[i];
	}
	
	public int SearchCourseID(String courseID) {
		System.out.println("Operation: Return the index of the course with the ID " + courseID + ".");
		for (int i=0; i<size(); i++) {
			if (listofCourses[i].getCourseID() == courseID) { //checks if the course is in the list
				System.out.println(courseID + " is at index " + i + "."); //prints the course
				System.out.println("");
				return i;
			}
		}
		System.out.println(courseID + " is not in the list."); //indicates the course is not in the list
		System.out.println("");
		return -1;
	}
	
	public int SearchCourseName(String courseName) {
		System.out.println("Operation: Return the index of the course with the name " + courseName + ".");
		for (int i=0; i<size(); i++) {
			if (listofCourses[i].getCourseName() == courseName) { //checks if the course is in the list
				System.out.println(courseName + " is at index " + i + "."); //prints the course
				System.out.println("");
				return i;
			}
		}
		System.out.println(courseName + " is not in the list."); //indicates the course is not in the list
		System.out.println("");
		return -1;
	}
}
