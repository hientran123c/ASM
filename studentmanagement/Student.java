package studentmanagement;

public class Student {
    private String id;
    private String name;
    private double marks;

    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String getRank() {
        if (marks >= 9.0) return "Excellent";
        else if (marks >= 7.5) return "Very Good";
        else if (marks >= 6.5) return "Good";
        else if (marks >= 5.0) return "Medium";
        else return "Fail";
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Marks=" + marks +
                ", Rank=" + getRank() +
                '}';
    }
}

