package studentmanagement;

public class StudentManagement {
    private StudentStack students;

    public StudentManagement() {
        this.students = new StudentStack();
    }

    public void addStudent(Student student) {
        students.push(student);
    }

    public void updateStudent(String id, String newName, double newMarks) {
        StudentStack tempStack = new StudentStack();
        boolean found = false;
        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId().equals(id)) {
                tempStack.push(new Student(id, newName, newMarks));
                found = true;
            } else {
                tempStack.push(student);
            }
        }
        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }
        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void deleteStudent(String id) {
        StudentStack tempStack = new StudentStack();
        boolean found = false;
        while (!students.isEmpty()) {
            Student student = students.pop();
            if (!student.getId().equals(id)) {
                tempStack.push(student);
            } else {
                found = true;
            }
        }
        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }
        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public Student searchStudent(String id) {
        StudentStack tempStack = new StudentStack();
        Student result = null;

        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId().equals(id)) {
                result = student;
            }
            tempStack.push(student);
        }
        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }
        return result;
    }

    public void sortStudents() {
        students.sortStudents();
    }

    public void displayStudents() {
        StudentStack tempStack = new StudentStack();

        while (!students.isEmpty()) {
            Student student = students.pop();
            System.out.println(student);
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }
    }
}

