package application;


import java.util.ArrayList;

public class CourseQuiz implements Duration ,Quiz {
	private String quizTitle;
    private int totalQuestions;
    private String difficultyLevel;
    private int passingScore;
    private Instructor instructor; // we will link it with instructor class
    private ArrayList<Student> student = new ArrayList<>(); // will be linked with students class
    private int duration;
    
    
    public CourseQuiz(String quizTitle, int totalQuestions, String difficultyLevel,  Instructor instructor,int duration) {
        this.quizTitle = quizTitle;
        this.totalQuestions = totalQuestions;
        this.difficultyLevel = difficultyLevel;
       // this.passingScore = passingScore;
        this.instructor = instructor; // will be linked with constructor class
        this.duration = duration;
    }

    @Override
    public String getQuizTitle() {
        return quizTitle;
    }

    @Override
    public int getTotalQuestions() {
        return totalQuestions;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public int getPassingScore() {
        return passingScore;
    }
    public Instructor getInstructor() { // wil be linked with instructor class
		return this.instructor;
	}
	public void setInstructor(Instructor inst) { // will be linked with instructor class
		this.instructor = inst;
	}
	public void showStudents() {
		for(int i = 0; i < this.student.size(); i++) {
			System.out.println(this.student.get(i).getUsername());
		}
	}
	public void addStudent(Student x) {
		this.student.add(x);
	}
	public static String getresult(int G) {
		if (G>50) {
			return "passed" ;
		}else {
			return "failed";
		}
		
	}

	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return this.duration;
	}
	
}

interface Quiz {
    String getQuizTitle();
   int getTotalQuestions();
}