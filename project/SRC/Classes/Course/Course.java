package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


// course class for Online-Course System
public class Course implements Duration , Comparable<Course> {
	//private Duration d ;
	private String title;
	private String description;
	private int price;
	private int grade;
	private ArrayList<Student> class_list = new ArrayList<>();
	private int duration ;
	private Instructor instructor;

	    public Course (String title, String description, int price,int duration,Instructor instructor ) {//
	        this.title = title;
	        this.description = description;
	        this.price =price;
	        this.duration =duration;
	        this.instructor =instructor;
	    }

	    //getters part
	    public String getTitle() {
	        return title;}
	 
	    
	    public String getDescription() {
	        return description;}
            public int getPrice() {
                 return price;
                             }
	    @Override
	    public String toString() {
	        return title + " - " + description; }
	    
	   
	    public void showMembers() {
			for(int i = 0; i < this.class_list.size(); i++) {
				System.out.println(this.class_list.get(i).getName());
			}
		}
		public void addStudent(Student x) {
			this.class_list.add(x);
		}
		// polymopmrphizm
		@Override
		public int getDuration() {
			// TODO Auto-generated method stub
			return this.duration;
		}

    @Override // object
    public int compareTo(Course course) {
        if(this.duration> course.duration )
            return 1;
        else if( this.duration< course.duration)
          return -1;
        else 
            return 0;
    }

   
                
}