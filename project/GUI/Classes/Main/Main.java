package application;

import java.util.ArrayList;
import java.util.Collections;

//import application.Student.NotFilled;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Main extends Application {

    private Stage primaryStage;
    private GridPane firstPageLayout;
    private TextField nameField, idField;
    private RadioButton maleRadioButton, femaleRadioButton,StudentRadioBtn,InstructorRadioBtn,
    q1Option1,q1Option2,q2Option3 ,q2Option4,q2Option1,q2Option2,q1Option3,q1Option4;
    public int G=0;
    
    Instructor doctor1=new Instructor(1,"doctor1");
    Instructor doctor2=new Instructor(2,"doctor2");
    Instructor doctor3=new Instructor(3,"doctor3");
    
    Course MachineLearing=new Course("Machine Learing Course", "Master the core principles and applications of machine learning in our comprehensive course. Dive into supervised and unsupervised learning, reinforcement learning, and deep learning. Learn optimization, regularization, and model selection techniques. Gain hands-on experience with feature engineering, dimensionality reduction, and data preprocessing. Through practical projects and case studies, acquire the skills to excel in diverse industries. Start your journey into the world of artificial intelligence today.",
    		49, 33, doctor1);
    
    Course Javacourse=new Course("Java Programming Course","This course covers the fundamentals of Java programming, including syntax, object-oriented programming concepts, and practical exercises.",
    		99, 66, doctor2);
    Course EmebeddedCourse=new Course("Emebedded Course", "Master the essentials of embedded systems development in our focused course. Learn microcontroller architectures, real-time operating systems, and low-level programming. Gain hands-on experience in hardware-software integration, sensor interfacing, and system optimization. Whether you're a beginner or experienced developer, this course equips you with the skills for creating efficient embedded solutions. Start your journey into embedded systems development today.",
    		150, 102, doctor3);
    
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
    	 login(primaryStage);
        primaryStage.show();
    }
    	private Scene login(Stage primaryStage) {
	
    		this.primaryStage = primaryStage;
    		primaryStage.setTitle("Student Registration");

    		// Layout for the first page
    		firstPageLayout = new GridPane();
    		firstPageLayout.setPadding(new Insets(20));
    		firstPageLayout.setVgap(10);
    		firstPageLayout.setHgap(10);

    		// Header Label
    		Label headerLabel = new Label("Welcome to Student Registration");
    		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20)); // Adjust font and size as needed
    		firstPageLayout.add(headerLabel, 0, 0, 2, 1); // Span two columns for the header

    		// Logo Image
    		Image logoImage = new Image("file:///C:/Users/Ahmed/eclipse-workspace/project1/src/application/ain.png"); // Replace "path/to/your/logo.png" with the actual path to your logo image
    		ImageView logoImageView = new ImageView(logoImage);
    		logoImageView.setFitWidth(100); // Adjust width and height as needed
    		logoImageView.setFitHeight(100);
    		firstPageLayout.add(logoImageView, 0, 1, 2, 1); // Span two columns for the logo

    		// Name field
    		Label nameLabel = new Label("Name:");
    		nameField = new TextField();
    		firstPageLayout.addRow(2, nameLabel, nameField);

    		// ID field
    		Label idLabel = new Label("ID:");
    		idField = new TextField();
    		firstPageLayout.addRow(3, idLabel, idField);

    		// Gender selection
    		Label genderLabel = new Label("Gender:");
    		ToggleGroup genderGroup = new ToggleGroup();
    		maleRadioButton = new RadioButton("Male");
    		femaleRadioButton = new RadioButton("Female");
    		maleRadioButton.setToggleGroup(genderGroup);
    		femaleRadioButton.setToggleGroup(genderGroup);
    		firstPageLayout.addRow(4, genderLabel, maleRadioButton, femaleRadioButton);

    		// Unity selection
    		Label unityLabel = new Label("Unity:");
    		ToggleGroup unityGroup = new ToggleGroup();
    		StudentRadioBtn = new RadioButton("Student");
    		InstructorRadioBtn = new RadioButton("Instructor");
    		StudentRadioBtn.setToggleGroup(unityGroup);
    		InstructorRadioBtn.setToggleGroup(unityGroup);
    		firstPageLayout.addRow(5, unityLabel, StudentRadioBtn, InstructorRadioBtn);

    		// Next button
    		Button nextButton = new Button("Next");
    		nextButton.setOnAction(event -> {
    		    try {
    		    	control();
    		    } catch (NotFilled e) {
    		        Alert alert = new Alert(Alert.AlertType.ERROR);
    		        alert.setTitle("Error");
    		        alert.setHeaderText(null);
    		        alert.setContentText(e.getMessage());
    		        alert.showAndWait();
    		    } catch (WrongGender e) {
    		        Alert alert = new Alert(Alert.AlertType.ERROR);
    		        alert.setTitle("Error");
    		        alert.setHeaderText(null);
    		        alert.setContentText(e.getMessage());
    		        alert.showAndWait();
    		    } catch (Idwrong e) {
					// TODO Auto-generated catch block
    		    	Alert alert = new Alert(Alert.AlertType.ERROR);
    		        alert.setTitle("Error");
    		        alert.setHeaderText(null);
    		        alert.setContentText(e.getMessage());
    		        alert.showAndWait();
				}
    		});
    		firstPageLayout.add(nextButton, 1, 6);
    		
    		

    		Scene scene1 = new Scene(firstPageLayout, 500, 350); // Increased height to accommodate header and logo
    		primaryStage.setScene(scene1);
    		return scene1;
}
		
    	public void control() throws NotFilled , WrongGender,Idwrong {
        // Check if all fields are filled
    	if (nameField.getText().isEmpty() || idField.getText().isEmpty() ||
                (maleRadioButton.isSelected() == false && femaleRadioButton.isSelected() == false && InstructorRadioBtn.isSelected()==true)) {
            // Show an alert if any field is empty
    		throw new NotFilled("Please fill in all fields.");	
        } 
    	//doctor 1 login
    	
    	else { if(nameField.getText().equals(doctor1.getName()) && maleRadioButton.isSelected() == true &&InstructorRadioBtn.isSelected()==true && Integer.parseInt(idField.getText()) == (doctor1.getId())  ) {
    		showinstrucor1Page();
    	} 
    	else if(nameField.getText().equals(doctor1.getName()) && maleRadioButton.isSelected() == false &&InstructorRadioBtn.isSelected()==true &&Integer.parseInt(idField.getText()) == (doctor1.getId())) {
    		throw new WrongGender("Please enter the right gender.");
    	}
    	else if(nameField.getText().equals(doctor1.getName()) && maleRadioButton.isSelected() == true &&InstructorRadioBtn.isSelected()==true &&Integer.parseInt(idField.getText()) != (doctor1.getId())) {
    		throw new Idwrong("enter the right ID for doctor 1");
    	}
    	
    	//doctor 2 login
    	else if(nameField.getText().equals(doctor2.getName()) && maleRadioButton.isSelected() == true&&InstructorRadioBtn.isSelected()==true &&Integer.parseInt(idField.getText()) == (doctor2.getId()) ) {
    		showinstrucor2Page();
    	}
    	else if(nameField.getText().equals(doctor2.getName()) && maleRadioButton.isSelected() == false&&InstructorRadioBtn.isSelected()==true&&Integer.parseInt(idField.getText()) == (doctor2.getId())) {
    		throw new WrongGender("Please enter the right gender for doctor 2");
    	}
    	
    	else if(nameField.getText().equals(doctor2.getName()) && maleRadioButton.isSelected() == true &&InstructorRadioBtn.isSelected()==true &&Integer.parseInt(idField.getText()) != (doctor2.getId())) {
    		throw new Idwrong("enter the right ID for doctor 2");
    	}
    	// doctor 3 login
    	
    	else if(nameField.getText().equals(doctor3.getName()) && maleRadioButton.isSelected() == true&&InstructorRadioBtn.isSelected()==true &&Integer.parseInt(idField.getText()) == (doctor3.getId())) {
    		showinstrucor3Page();
    	}
    	else if(nameField.getText().equals(doctor3.getName()) && maleRadioButton.isSelected() == false&&InstructorRadioBtn.isSelected()==true&&Integer.parseInt(idField.getText()) == (doctor3.getId())) {
    		throw new WrongGender("Please enter the right gender for doctor 3");
    	}
    	
    	else if(nameField.getText().equals(doctor3.getName()) && maleRadioButton.isSelected() == true &&InstructorRadioBtn.isSelected()==true &&Integer.parseInt(idField.getText()) != (doctor3.getId())) {
    		throw new Idwrong("enter the right ID for doctor 3");
    	}
    	
    	// student login
    	else if(StudentRadioBtn.isSelected() == true) {
    		showCourseSelectionPage();
    	}} 
        
    }

    	
		private void showCourseSelectionPage() {
        // Layout for the second page
    	//Pane pane =new Pane();
        GridPane courseSelectionLayout = new GridPane();
        courseSelectionLayout.setPadding(new Insets(20));
        courseSelectionLayout.setVgap(10);
        courseSelectionLayout.setHgap(10);

        // Course selection
        Label courseLabel = new Label("Select Courses:");
        Button MachineLearingCheckBox = new Button(MachineLearing.getTitle());
        Button JavacourseCheckBox = new Button(Javacourse.getTitle());
        Button EmebeddedCourseCheckBox = new Button(EmebeddedCourse.getTitle());
        
  
        
        courseSelectionLayout.add(courseLabel,0,0);
        courseSelectionLayout.add(MachineLearingCheckBox,1,1);
        courseSelectionLayout.add(JavacourseCheckBox,1,2);
        courseSelectionLayout.add(EmebeddedCourseCheckBox,1,3);
        MachineLearingCheckBox.setOnAction(event -> {showcourse1();});
        JavacourseCheckBox.setOnAction(event -> {showcourse2();});
        EmebeddedCourseCheckBox.setOnAction(event -> {showcourse3();});
   
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> login(primaryStage));
        courseSelectionLayout.add(backButton, 0, 4);


        Scene scene = new Scene(courseSelectionLayout, 300, 200);
        primaryStage.setScene(scene);
    }
    
    	private void showinstrucor1Page() {
        // Layout for the second page
    		//String WELCOME = (doctor1.getName()+"MC COURSE");
           // String numOfStudents = "NUMBER OF ENROLLED STUDENTS: 5500";
           // String instructorBio = "Our esteemed instructor,";

            // Load instructor image
            Image instructorImage = new Image("file:///C:/Users/Ahmed/eclipse-workspace/project1/src/application/mc%20doctr.png"); // Replace "path/to/instructor_image.png" with the path to your instructor's image
            ImageView imageView = new ImageView(instructorImage);
            imageView.setFitWidth(200); // Adjust image width
            imageView.setPreserveRatio(true);

            // Create labels for instructor information
            Label nameLabel = new Label("Name: " + doctor1.getName());
            Label titleLabel = new Label("Title: " + "NUMBER OF ENROLLED STUDENTS: 5500");
            Label bioLabel = new Label("Bio:");
            Label bioText = new Label("Leading Expert in Machine Learning Guides Students to Mastery: Harnessing Knowledge for Tomorrow's Innovations");
            bioText.setWrapText(true); // Wrap text within the label

            // Create layout for instructor information
            VBox instructorInfoLayout = new VBox(10, nameLabel, titleLabel, bioLabel, bioText);
            instructorInfoLayout.setPadding(new Insets(20));

            // Create Column Chart data
            CategoryAxis xAxis = new CategoryAxis();
            NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("Grades");
            yAxis.setLabel("Students");

            BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
            barChart.setTitle("Final Test Grades");

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.getData().addAll(
                    new XYChart.Data<>("<60%", 500),
                    new XYChart.Data<>("60%", 800),
                    new XYChart.Data<>("70%", 1000),
                    new XYChart.Data<>("80%", 600),
                    new XYChart.Data<>("90%", 400),
                    new XYChart.Data<>("100%", 100)
            );

            barChart.getData().add(series);

            // Create layout for column chart
            VBox columnChartLayout = new VBox(barChart);
            columnChartLayout.setPadding(new Insets(20));
            columnChartLayout.setSpacing(10);
            Button backButton = new Button("Back");
            backButton.setOnAction(e -> login(primaryStage));
            // Create layout for instructor page
            VBox vv=new VBox(imageView,backButton);
            HBox hbox = new HBox(70,vv, columnChartLayout);
            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(instructorInfoLayout);
            borderPane.setBottom(hbox);
            BorderPane.setMargin(imageView, new Insets(10));

            // Create the scene
            Scene scene = new Scene(borderPane, 800, 500);

            // Set the stage
            primaryStage.setTitle("Instructor Page");
            primaryStage.setScene(scene);}
    
    	private void showinstrucor3Page() {
        // Layout for the second page
//    		String WELCOME = "DOCTOR 3  EMBEDDED COURSE";
//            String numOfStudents = "NUMBER OF ENROLLED STUDENTS: 3500";
//            String instructorBio = "Our esteemed instructor,";

            // Load instructor image
            Image instructorImage = new Image("file:///C:/Users/Ahmed/eclipse-workspace/project1/src/application/emb%20doc.png"); // Replace "path/to/instructor_image.png" with the path to your instructor's image
            ImageView imageView = new ImageView(instructorImage);
            imageView.setFitWidth(200); // Adjust image width
            imageView.setPreserveRatio(true);

            // Create labels for instructor information
            Label nameLabel = new Label("Name: " + doctor3.getName());
            Label titleLabel = new Label("Title: " + "NUMBER OF ENROLLED STUDENTS: 3500");
            Label bioLabel = new Label("Bio:");
            Label bioText = new Label("Embedded Systems Maestro: Nurturing Innovation and Proficiency in Cutting-Edge Technology");
            bioText.setWrapText(true); // Wrap text within the label

            // Create layout for instructor information
            VBox instructorInfoLayout = new VBox(10, nameLabel, titleLabel, bioLabel, bioText);
            instructorInfoLayout.setPadding(new Insets(20));

            // Create Column Chart data
            CategoryAxis xAxis = new CategoryAxis();
            NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("Grades");
            yAxis.setLabel("Students");

            BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
            barChart.setTitle("Final Test Grades");

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.getData().addAll(
                    new XYChart.Data<>("<60%", 500),
                    new XYChart.Data<>("60%", 800),
                    new XYChart.Data<>("70%", 1000),
                    new XYChart.Data<>("80%", 600),
                    new XYChart.Data<>("90%", 400),
                    new XYChart.Data<>("100%", 100)
            );

            barChart.getData().add(series);

            // Create layout for column chart
            VBox columnChartLayout = new VBox(barChart);
            columnChartLayout.setPadding(new Insets(20));
            columnChartLayout.setSpacing(10);
            Button backButton = new Button("Back");
            backButton.setOnAction(e -> login(primaryStage));
            // Create layout for instructor page
            VBox vv=new VBox(imageView,backButton);
            HBox hbox = new HBox(70,vv, columnChartLayout);
            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(instructorInfoLayout);
            borderPane.setBottom(hbox);
            BorderPane.setMargin(imageView, new Insets(10));

            // Create the scene
            Scene scene = new Scene(borderPane, 800, 500);

            // Set the stage
            primaryStage.setTitle("Instructor Page");
            primaryStage.setScene(scene); }
    
     	private void showinstrucor2Page() {
        // Layout for the second page

            // Load instructor image
            Image instructorImage = new Image("file:///C:/Users/Ahmed/eclipse-workspace/project1/src/application/ji.jpg"); // Replace "path/to/instructor_image.png" with the path to your instructor's image
            ImageView imageView = new ImageView(instructorImage);
            imageView.setFitWidth(200); // Adjust image width
            imageView.setPreserveRatio(true);

            // Create labels for instructor information
            Label nameLabel = new Label("Name: " + doctor2.getName());
            Label titleLabel = new Label("NUMBER OF ENROLLED STUDENTS: 2560");
            Label bioLabel = new Label("Bio:");
            Label bioText = new Label("Java Guru: Empowering Students with Proficiency in Programming Excellence");
            bioText.setWrapText(true); // Wrap text within the label

            // Create layout for instructor information
            VBox instructorInfoLayout = new VBox(10, nameLabel, titleLabel, bioLabel, bioText);
            instructorInfoLayout.setPadding(new Insets(20));

            // Create Column Chart data
            CategoryAxis xAxis = new CategoryAxis();
            NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("Grades");
            yAxis.setLabel("Students");

            BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
            barChart.setTitle("Final Test Grades");

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.getData().addAll(
                    new XYChart.Data<>("<60%", 500),
                    new XYChart.Data<>("60%", 800),
                    new XYChart.Data<>("70%", 1000),
                    new XYChart.Data<>("80%", 600),
                    new XYChart.Data<>("90%", 400),
                    new XYChart.Data<>("100%", 100)
            );

            barChart.getData().add(series);

            // Create layout for column chart
            VBox columnChartLayout = new VBox(barChart);
            columnChartLayout.setPadding(new Insets(20));
            columnChartLayout.setSpacing(10);
            Button backButton = new Button("Back");
            backButton.setOnAction(e -> login(primaryStage));
            // Create layout for instructor page
            VBox vv=new VBox(imageView,backButton);
            HBox hbox = new HBox(70,vv, columnChartLayout);
            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(instructorInfoLayout);
            borderPane.setBottom(hbox);
            BorderPane.setMargin(imageView, new Insets(10));

            // Create the scene
            Scene scene = new Scene(borderPane, 800, 500);

            // Set the stage
            primaryStage.setTitle("Instructor Page");
            primaryStage.setScene(scene);}	
    
    	private void showcourse1() {
    			Label titleLabel = new Label(MachineLearing.getTitle());
    	        Label instructorLabel = new Label("Instructor:" + doctor1.getName() );
    	        Label durationLabel = new Label(  MachineLearing.getDuration() + "Hours");	    	 	 	  	
    	        Label descriptionLabel = new Label("Description:");
    	        TextArea descriptionTextArea = new TextArea(MachineLearing.getDescription());
    	        descriptionTextArea.setEditable(false);
    	        descriptionTextArea.setWrapText(true);

    	        // Create enroll button
    	        Button enrollButton = new Button("placement quiz");

    	        // Load image
    	        Image image = new Image("file:///C:/Users/Ahmed/eclipse-workspace/project1/src/application/mc.jpg"); // Replace "path/to/image.png" with your image path
    	        ImageView imageView = new ImageView(image);
    	        imageView.setFitWidth(200);
    	        imageView.setFitHeight(200);

    	        // Create a GridPane layout
    	        GridPane gridPane = new GridPane();
    	        gridPane.setPadding(new Insets(20));
    	        gridPane.setHgap(10);
    	        gridPane.setVgap(10);
    	        HBox hbox=new HBox();
    	        Button backButton = new Button("Back");
    	        backButton.setOnAction(event -> showCourseSelectionPage());
    	        
    	        enrollButton.setOnAction(event -> showquiz1());
    	        gridPane.add(backButton, 0, 5);
    	        // Add components to the grid
    	        //gridPane.add(imageView, 1, 0, 2, 1); // Image spanning two rows
    	        gridPane.add(titleLabel, 0, 0); // Spanning two columns
    	        gridPane.add(instructorLabel, 0, 1); // Spanning two columns
    	        gridPane.add(durationLabel, 0, 2); // Spanning two columns
    	        gridPane.add(descriptionLabel, 0, 3); // Spanning two columns
    	        gridPane.add(descriptionTextArea, 0, 4); // Spanning two columns
    	        gridPane.add(enrollButton, 1, 5); // Spanning two columns
    	        gridPane.add(imageView, 1, 0, 1, 5); // Image in the seco
    	        // Create the scene
    	        Scene scene = new Scene(gridPane, 600, 400);

    	        // Set the stage
    	        primaryStage.setTitle(MachineLearing.getTitle());
    	        primaryStage.setScene(scene);}

		private void showcourse2() {
			 Label titleLabel = new Label(Javacourse.getTitle());
 	        Label instructorLabel = new Label("Instructor:" + doctor2.getName() );
 	        Label durationLabel = new Label(Javacourse.getDuration() + "Hours");
 	        Label descriptionLabel = new Label("Description:");
 	        TextArea descriptionTextArea = new TextArea(Javacourse.getDescription());
 	        descriptionTextArea.setEditable(false);
 	        descriptionTextArea.setWrapText(true);

 	        // Create enroll button
 	        Button enrollButton = new Button("placement quiz");
 	        enrollButton.setOnAction(e -> showquiz2());
 	        // Load image
 	        Image image = new Image("file:///C:/Users/Ahmed/eclipse-workspace/project1/src/application/javalogo.jpg"); // Replace "path/to/image.png" with your image path
 	        ImageView imageView = new ImageView(image);
 	        imageView.setFitWidth(200);
 	        imageView.setFitHeight(200);

 	        // Create a GridPane layout
 	        GridPane gridPane = new GridPane();
 	        gridPane.setPadding(new Insets(20));
 	        gridPane.setHgap(10);
 	        gridPane.setVgap(10);
 	        HBox hbox=new HBox();
 	        Button backButton = new Button("Back");
 	        backButton.setOnAction(event -> showCourseSelectionPage());
 	        gridPane.add(backButton, 0, 5);
 	        // Add components to the grid
 	        //gridPane.add(imageView, 1, 0, 2, 1); // Image spanning two rows
 	        gridPane.add(titleLabel, 0, 0); // Spanning two columns
 	        gridPane.add(instructorLabel, 0, 1); // Spanning two columns
 	        gridPane.add(durationLabel, 0, 2); // Spanning two columns
 	        gridPane.add(descriptionLabel, 0, 3); // Spanning two columns
 	        gridPane.add(descriptionTextArea, 0, 4); // Spanning two columns
 	        gridPane.add(enrollButton, 1, 5); // Spanning two columns
 	        gridPane.add(imageView, 1, 0, 1, 5); // Image in the seco
 	        // Create the scene
 	        Scene scene = new Scene(gridPane, 600, 400);

 	        // Set the stage
 	        primaryStage.setTitle(Javacourse.getTitle());
 	        primaryStage.setScene(scene);  }
		private void showcourse3() {
			Label titleLabel = new Label(EmebeddedCourse.getTitle());
	        Label instructorLabel = new Label("Instructor:" + doctor3.getName() );
	        Label durationLabel = new Label(EmebeddedCourse.getDuration() + "Hours");
	        Label descriptionLabel = new Label("Description:");
	        TextArea descriptionTextArea = new TextArea(EmebeddedCourse.getTitle());
	        descriptionTextArea.setEditable(false);
	        descriptionTextArea.setWrapText(true);

	        // Create enroll button
	        Button enrollButton = new Button("placement quiz");
 	        enrollButton.setOnAction(e -> showquiz3());

	        // Load image
	        Image image = new Image("file:///C:/Users/Ahmed/eclipse-workspace/project1/src/application/embedd.jpg"); // Replace "path/to/image.png" with your image path
	        ImageView imageView = new ImageView(image);
	        imageView.setFitWidth(200);
	        imageView.setFitHeight(200);

	        // Create a GridPane layout
	        GridPane gridPane = new GridPane();
	        gridPane.setPadding(new Insets(20));
	        gridPane.setHgap(10);
	        gridPane.setVgap(10);
	        HBox hbox=new HBox();
	        Button backButton = new Button("Back");
	        backButton.setOnAction(event -> showCourseSelectionPage());
	        gridPane.add(backButton, 0, 5);
	        // Add components to the grid
	        //gridPane.add(imageView, 1, 0, 2, 1); // Image spanning two rows
	        gridPane.add(titleLabel, 0, 0); // Spanning two columns
	        gridPane.add(instructorLabel, 0, 1); // Spanning two columns
	        gridPane.add(durationLabel, 0, 2); // Spanning two columns
	        gridPane.add(descriptionLabel, 0, 3); // Spanning two columns
	        gridPane.add(descriptionTextArea, 0, 4); // Spanning two columns
	        gridPane.add(enrollButton, 1, 5); // Spanning two columns
	        gridPane.add(imageView, 1, 0, 1, 5); // Image in the seco
	        // Create the scene
	        Scene scene = new Scene(gridPane, 600, 400);

	        // Set the stage
	        primaryStage.setTitle(EmebeddedCourse.getTitle());
	        primaryStage.setScene(scene);  }
    	public void showquiz1() {    	  
    		 VBox quizVBox = new VBox();
        	 quizVBox.setStyle("-fx-background-color: lightgray;");
        	 quizVBox.setPrefSize(400, 300);
        	 quizVBox.setSpacing(10); // Set spacing between elements
        	 quizVBox.setPadding(new Insets(10)); // Set padding
        	 Button nextButton = new Button("submit");
             nextButton.setOnAction(event -> result1());
            
        	 // Question 1
        	 Label question1Label = new Label("Question 1: What is supervised learning?");
        	 ToggleGroup group1 = new ToggleGroup();
        	  q1Option1 = new RadioButton("Learning with a teacher providing labeled data");
        	  q1Option2 = new RadioButton("Learning without any guidance");
        	  q1Option3 = new RadioButton("Learning with reinforcement from rewards");
        	  q1Option4 = new RadioButton("Learning by observing unlabeled data");
        	 q1Option1.setToggleGroup(group1);
        	 q1Option2.setToggleGroup(group1);
        	 q1Option3.setToggleGroup(group1);
        	 q1Option4.setToggleGroup(group1);

        	 VBox question1Box = new VBox(question1Label, q1Option1, q1Option2, q1Option3, q1Option4);
        	 question1Box.setSpacing(5);

        	 // Question 2
        	 Label question2Label = new Label("Question 2:What is overfitting in machine learning?");
        	 ToggleGroup group2 = new ToggleGroup();
        	  q2Option1 = new RadioButton("When the model performs well on training data but poorly on new data");
        	  q2Option2 = new RadioButton("When the model performs poorly on training data and new data");
        	  q2Option3 = new RadioButton("When the model generalizes well to new data");
        	  q2Option4 = new RadioButton("When the model fails to converge during training");
        	 q2Option1.setToggleGroup(group2);
        	 q2Option2.setToggleGroup(group2);
        	 q2Option3.setToggleGroup(group2);
        	 q2Option4.setToggleGroup(group2);

        	 VBox question2Box = new VBox(question2Label, q2Option1, q2Option2, q2Option3, q2Option4);
        	 question2Box.setSpacing(5);

        	 // Add all elements to the VBox
        	 quizVBox.getChildren().addAll(question1Box, question2Box,nextButton);

        	 // Create a new scene with the VBox
        	 Scene quizScene = new Scene(quizVBox);

        	 // Set the scene to the stage
        	 primaryStage.setScene(quizScene);
        	 primaryStage.setTitle("Placement Quiz");}
    	
    	
    	public void showquiz2() {
    		VBox quizVBox = new VBox();
            quizVBox.setStyle("-fx-background-color: lightgray;");
            quizVBox.setPrefSize(400, 300);
            quizVBox.setSpacing(10); // Set spacing between elements
            quizVBox.setPadding(new Insets(10)); // Set padding

            Button nextButton = new Button("Submit");
            nextButton.setOnAction(event -> result2());

            // Question 1
            Label question1Label = new Label("Question 1: What is JVM?");

                   
            ToggleGroup group1 = new ToggleGroup();
            q1Option1 = new RadioButton("JAVA VISUAL MACHINE");
            q1Option2 = new RadioButton("JAVA VISIBLE MACHINE");
            q1Option3 = new RadioButton("JAVA VIRTUAL MACHINE");
            q1Option4 = new RadioButton("NONE OF THE ABOVE");
            q1Option1.setToggleGroup(group1);
            q1Option2.setToggleGroup(group1);
            q1Option3.setToggleGroup(group1);
            q1Option4.setToggleGroup(group1);

            VBox question1Box = new VBox(question1Label, q1Option1, q1Option2, q1Option3, q1Option4);
            question1Box.setSpacing(5);

            // Question 2
            Label question2Label = new Label("Question 2: Which of the following statements is true about interfaces in Java?");
            ToggleGroup group2 = new ToggleGroup();
            q2Option1 = new RadioButton("An interface can extend multiple interfaces.");
            q2Option2 = new RadioButton("An interface can implement another interface.");
            q2Option3 = new RadioButton("An interface can have constructors.");
            q2Option4 = new RadioButton("An interface can have instance variables.");
            q2Option1.setToggleGroup(group2);
            q2Option2.setToggleGroup(group2);
            q2Option3.setToggleGroup(group2);
            q2Option4.setToggleGroup(group2);

            VBox question2Box = new VBox(question2Label, q2Option1, q2Option2, q2Option3, q2Option4);
            question2Box.setSpacing(5);

            // Add all elements to the VBox
            quizVBox.getChildren().addAll(question1Box, question2Box, nextButton);

            // Create a new scene with the VBox
            Scene quizScene = new Scene(quizVBox);

            // Set the scene to the stage
            primaryStage.setScene(quizScene);
            primaryStage.setTitle("Java Quiz");
    	}

    	public void showquiz3() {
    		VBox quizVBox = new VBox();
       	 quizVBox.setStyle("-fx-background-color: lightgray;");
       	 quizVBox.setPrefSize(400, 300);
       	 quizVBox.setSpacing(10); // Set spacing between elements
       	 quizVBox.setPadding(new Insets(10)); // Set padding
       	 Button nextButton = new Button("submit");
            nextButton.setOnAction(event -> result3());
           
       	 // Question 1
       	 Label question1Label = new Label("Question 1: What is GPIO?");
       	 ToggleGroup group1 = new ToggleGroup();
       	  q1Option1 = new RadioButton("general purpose input output");
       	  q1Option2 = new RadioButton("good parallel initial observation");
       	  q1Option3 = new RadioButton("none");
       	  q1Option4 = new RadioButton("all");
       	 q1Option1.setToggleGroup(group1);
       	 q1Option2.setToggleGroup(group1);
       	 q1Option3.setToggleGroup(group1);
       	 q1Option4.setToggleGroup(group1);

       	 VBox question1Box = new VBox(question1Label, q1Option1, q1Option2, q1Option3, q1Option4);
       	 question1Box.setSpacing(5);

       	 // Question 2
       	 Label question2Label = new Label("Question 2: Arm processor is: ");
       	 ToggleGroup group2 = new ToggleGroup();
       	  q2Option1 = new RadioButton("Risc");
       	  q2Option2 = new RadioButton("cisc");
       	  q2Option3 = new RadioButton("both");
       	  q2Option4 = new RadioButton("none");
       	 q2Option1.setToggleGroup(group2);
       	 q2Option2.setToggleGroup(group2);
       	 q2Option3.setToggleGroup(group2);
       	 q2Option4.setToggleGroup(group2);

       	 VBox question2Box = new VBox(question2Label, q2Option1, q2Option2, q2Option3, q2Option4);
       	 question2Box.setSpacing(5);

       	 // Add all elements to the VBox
       	 quizVBox.getChildren().addAll(question1Box, question2Box,nextButton);

       	 // Create a new scene with the VBox
       	 Scene quizScene = new Scene(quizVBox);

       	 // Set the scene to the stage
       	 primaryStage.setScene(quizScene);
       	 primaryStage.setTitle("Placement Quiz");
    	}
    	
    	
     	public void result1() {
    		if (q1Option3.isSelected() == true ) {
    			G+=50;
    		}
    		if (q2Option2.isSelected() == true ) {
    			G+=50;
    		}
    		//CourseQuiz.getresult(G);
    		String s=CourseQuiz.getresult(G);
    		Label label = new Label(s);
            label.setStyle("-fx-font-size: 24pt;"); // Set font size
            Button nextButton = new Button("next");
            
            nextButton.setOnAction(event -> {
            	
            	if(s.equals("passed") == true) {
            		showcourse1();
            	}
            	else {showCourseSelectionPage();}
            });
            // Create a layout pane (StackPane) and add the label to it
            VBox v=new VBox(label,nextButton);
           // BorderPane root = new BorderPane();
           
           //root.setCenter(v);
            v.setAlignment(Pos.CENTER);
            // Create a scene with the layout pane as root
            Scene scene = new Scene(v, 400, 300);

            // Set the scene to the stage
            primaryStage.setScene(scene);
    	}

     	public void result3() {
    	if (q1Option1.isSelected() == true ) {
			G+=50;
		}
		if (q2Option1.isSelected() == true ) {
			G+=50;
		}
		//CourseQuiz.getresult(G);
		String s=CourseQuiz.getresult(G);
		Label label = new Label(s);
        label.setStyle("-fx-font-size: 24pt;"); // Set font size
        Button nextButton = new Button("next");
        
        nextButton.setOnAction(event -> {
        	
        	if(s.equals("passed") == true) {
        		showcourse3();
        	}
        	else {showCourseSelectionPage();}
        });
        // Create a layout pane (StackPane) and add the label to it
        VBox v=new VBox(label,nextButton);
        
       v.setAlignment(Pos.CENTER);
        // Create a scene with the layout pane as root
        Scene scene = new Scene(v, 400, 300);

        // Set the scene to the stage
        primaryStage.setScene(scene);
    }	
     	
     	public void result2() {
     		if (q1Option3.isSelected() == true ) {
    			G+=50;
    		}
    		if (q2Option1.isSelected() == true ) {
    			G+=50;
    		}
    	//	CourseQuiz.getresult(G);
    		String s=CourseQuiz.getresult(G);
    		Label label = new Label(s);
            label.setStyle("-fx-font-size: 24pt;"); // Set font size
            Button nextButton = new Button("next");
            
            nextButton.setOnAction(event -> {
            	
            	if(s.equals("passed") == true) {
            		showcourse2();
            	}
            	else {showCourseSelectionPage();}
            });
            // Create a layout pane (StackPane) and add the label to it
            VBox v=new VBox(label,nextButton);
            v.setAlignment(Pos.CENTER);

            // Create a scene with the layout pane as root
            Scene scene = new Scene(v, 400, 300);

            // Set the scene to the stage
            primaryStage.setScene(scene);
     	}
     	
    	public static void main(String[] args) {
        launch(args);
    }
}