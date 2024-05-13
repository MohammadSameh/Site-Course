package application;


import java.util.List;



import java.util.ArrayList;
public class Instructor extends User {
    private List<Course> courses;
    
    
    public Instructor() {
        // Initialize instance variables with default values if needed
        id = 0;
        name = "";
    }
    public Instructor(int id, String name) {
        super(id, name);
        this.courses = new ArrayList<>();
        role = 1;
    }

    @Override
    public void displayDetails() {
        System.out.println("Instructor ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Courses Teaching:");
        for (Course course : courses) {
            System.out.println(course.getTitle());
        }
    }

    public void addCourse(Course course) throws CourseNotFoundException {
        if (!courses.contains(course)) {
            courses.add(course);
       
            System.out.println("Added course to teach: " + course.getTitle());
        } else if (courses.contains(course)){
            throw new CourseNotFoundException("Can't add course. Course already teaching.");
        } else {
            throw new CourseNotFoundException("Can't add course. Course not found.");
        }
    }

    public void removeCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
    
            System.out.println("Removed course from teaching: " + course.getTitle());
        } else {
            System.out.println("Can't remove course. Course not found.");
        }
    }
    
    public static class CourseNotFoundException extends Exception {
        public CourseNotFoundException(String message) {
            super(message);
 }
}
}