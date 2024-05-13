package application;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NewMain {

    public static void main(String[] args) {
        System.out.println("Please enter if you're an instructor or a student (0/1) (0 for student, 1 for instructor):");
        Scanner scanner = new Scanner(System.in);
        String role = scanner.nextLine();
    Instructor doctor1=new Instructor(1,"doctor1");
    Instructor doctor2=new Instructor(2,"doctor2");
    Instructor doctor3=new Instructor(3,"doctor3");
    Instructor hussam=new Instructor();

    Course MachineLearing=new Course("Machine Learing Course", "Master the core principles and applications of machine learning in our comprehensive course. Dive into supervised and unsupervised learning, reinforcement learning, and deep learning. Learn optimization, regularization, and model selection techniques. Gain hands-on experience with feature engineering, dimensionality reduction, and data preprocessing. Through practical projects and case studies, acquire the skills to excel in diverse industries. Start your journey into the world of artificial intelligence today.",
    		49, 33, doctor1);
    
    Course Javacourse=new Course("Java Programming Course","This course covers the fundamentals of Java programming, including syntax, object-oriented programming concepts, and practical exercises.",
    		99, 66, doctor2);
    Course EmebeddedCourse=new Course("Emebedded Course", "Master the essentials of embedded systems development in our focused course. Learn microcontroller architectures, real-time operating systems, and low-level programming. Gain hands-on experience in hardware-software integration, sensor interfacing, and system optimization. Whether you're a beginner or experienced developer, this course equips you with the skills for creating efficient embedded solutions. Start your journey into embedded systems development today.",
    		150, 102, doctor3);
    
 
        if (role.equals("1")) {
            // If the user is an instructor
            System.out.println("Enter instructor's ID:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter instructor's name:");
            String name = scanner.nextLine();
            
            // Create an instructor object
            
            // Set instructor's ID and name
            hussam.setId(id);
            hussam.setName(name);

            // Display instructor details
            hussam.displayDetails();
        } else if (role.equals("0")) {
            // If the user is a student
            System.out.println("Enter student's ID:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter student's name:");
            String name = scanner.nextLine();
            
            // Create a student object
            Student student1 = new Student(24,"hus");
            
            // Set student's ID and name
            student1.setId(id);
            student1.setName(name);
            System.out.println("----------------------------------------");
            // Display student details
            student1.displayDetails();
            
            ArrayList<Course> myList = new ArrayList<>();

            // Add Course objects to the ArrayList
            myList.add(Javacourse);
            myList.add(MachineLearing);
            myList.add(EmebeddedCourse);

            // Sort the ArrayList
            Collections.sort(myList);       

            // Access and print the title of the first Course object
            
            
            System.out.println("which course would you like to attend? based on field and duration   " +myList.get(0).getTitle()+"  "+
            		myList.get(1).getTitle()+"  "+myList.get(2).getTitle());
            Scanner studentCourse = new Scanner(System.in);
            String course = scanner.nextLine();
            if(course.equalsIgnoreCase("MachineLearing")){
            	Course ChoosingCourse = new Course("MachineLearing", "gives you the basics of MachineLearing", 25 ,40 ,doctor1 );
            	String title = ChoosingCourse.getTitle();
            String description = ChoosingCourse.getDescription();
            int price = ChoosingCourse.getPrice();
            System.out.println("Title: " + title);
            System.out.println("Description: " + description);
            System.out.println("Price: $" + price);
            System.out.println("Duration (in hours): " + MachineLearing.getDuration()); // Printing duration
            System.out.println("Instructor: " + doctor1.getName()); 
            
            if (title.equalsIgnoreCase("MachineLearing")){      // Close the scanner to release resources
            	System.out.println("Upcoming quiz for MachineLearing:");
            	CourseQuiz quiz = new CourseQuiz("chapter 1", 10, "easy", doctor1, 5);
            	System.out.println("Quiz Title: " + quiz.getQuizTitle());
            	System.out.println("Total Questions: " + quiz.getTotalQuestions());
            	System.out.println("Difficulty Level: " + quiz.getDifficultyLevel());
            	System.out.println("Passing Score: " + quiz.getPassingScore());
            	System.out.println("Instructor: " + quiz.getInstructor().getName()); // Assuming getName() returns the instructor's name
  }
            
        }
        else if(course.equalsIgnoreCase("Javacourse")){
        	Course ChoosingCourse = new Course("Javacourse", "simple java", 60,35, doctor2);
        	String title = ChoosingCourse.getTitle();
            String description = ChoosingCourse.getDescription();
            int price = ChoosingCourse.getPrice();
            System.out.println("Title: " + title);
            System.out.println("Description: " + description);
            System.out.println("Price: $" + price);
             System.out.println("Duration (in hours): " + Javacourse.getDuration()); // Printing duration
            System.out.println("Instructor: " + doctor2.getName()); 
            
            if (title.equalsIgnoreCase("Javacourse")){
            	System.out.println("Upcoming quiz for Javacourse:");
            	CourseQuiz quiz = new CourseQuiz("chapter 1", 10, "easy",  doctor2 ,5);
            	System.out.println("Quiz Title: " + quiz.getQuizTitle());
            	System.out.println("Total Questions: " + quiz.getTotalQuestions());
            	System.out.println("Difficulty Level: " + quiz.getDifficultyLevel());
            	System.out.println("Passing Score: " + quiz.getPassingScore());
            	System.out.println("Instructor: " + quiz.getInstructor().getName()); // Assuming getName() returns the instructor's name

  }
        }
        
         if(course.equalsIgnoreCase("EmebeddedCourse")){
        	 Course ChoosingCourse = new Course("EmebeddedCourse", "1st and 2nd chapter in embedded", 40 ,50 ,doctor3);
        	 String title = ChoosingCourse.getTitle();
        	 String description = ChoosingCourse.getDescription();
            int price = ChoosingCourse.getPrice();
            System.out.println("Title: " + title);
            System.out.println("Description: " + description);
            System.out.println("Price: $" + price);
            System.out.println("Duration (in hours): " + EmebeddedCourse.getDuration()); // Printing duration
            System.out.println("Instructor: " + doctor3.getName()); // Printing instructor's name
            
             if(title.equalsIgnoreCase("EmebeddedCourse")){
              System.out.println("Upcoming quiz for MachineLearing:");
              CourseQuiz quiz = new CourseQuiz("chapter 1", 10, "easy", doctor1, 5);
              System.out.println("Quiz Title: " + quiz.getQuizTitle());
              System.out.println("Total Questions: " + quiz.getTotalQuestions());
              System.out.println("Difficulty Level: " + quiz.getDifficultyLevel());
              System.out.println("Passing Score: " + quiz.getPassingScore());
              System.out.println("Instructor: " + quiz.getInstructor().getName()); // Assuming getName() returns the instructor's name
  }
       
        }
         scanner.close();
        } else {
            // If the user enters an invalid option
            System.out.println("Invalid input. Please enter '1' for instructor or '0' for student.");
        }
  

        
   }}