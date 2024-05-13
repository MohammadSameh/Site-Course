package application;



public abstract class User {
    int id;
    String name;
    public static int userCount = 0;
    public int role; // 0 = Student, 1 = Instructor
    // Constructor
    public User(){}
    public User(int id, String name) {
        this.id = id;
        this.name = name;

    }

    // Abstract method to display user details
    public abstract void displayDetails();

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
 public void setId(int id) {
        this.id = id;
 }}