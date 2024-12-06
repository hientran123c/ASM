package studentmanagement;
import java.util.Random;
import java.util.function.Consumer;
import java.util.HashSet;
import java.util.*;

public class StudentManagement {
    private StudentStack students;

    public StudentManagement() {
        this.students = new StudentStack();
    }

    public void addStudent(Student student) {
        if (searchStudent(student.getId()) != null) {
            System.out.println("Student with ID " + student.getId() + " already exists. Cannot add.");
            return;
        }
        students.push(student);
        System.out.println("Added Student: ID=" + student.getId() + ", Name=" + student.getName() + ", Marks=" + student.getMarks());
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

    public void generateRandomStudents(int count) {
        Random random = new Random();
        String[] sampleNames = {"Alice", "Bob", "Charlie", "Daisy", "Edward", "Fiona", "George", "Hannah", "Ian", "Jane"};
        Set<String> usedIds = new HashSet<>(); // Track used IDs
        List<Student> studentList = new ArrayList<>(); // List to hold all generated students

        // Create students
        for (int i = 0; i < count; i++) {
            String id;
            do {
                id = "S" + (1000 + random.nextInt(9000)); // Random ID like S1000-S9999
            } while (usedIds.contains(id)); // Ensure ID is unique
            usedIds.add(id);

            String name = sampleNames[random.nextInt(sampleNames.length)] + "_" + id; // Combine with ID for unique name
            double marks = 1 + (9 * random.nextDouble()); // Random marks from 1 to 10
            studentList.add(new Student(id, name, Math.round(marks * 100.0) / 100.0)); // Round marks to 2 decimals
        }

        // Shuffle the list to randomize the order
        Collections.shuffle(studentList);

        // Add the shuffled students to the stack
        for (Student student : studentList) {
            students.push(student);
        }

        System.out.println("Generated " + count + " unique random students in random order.");
    }

    public void sortAndAnalyze(String algorithm) {
        Consumer<StudentStack> sortFunction;
        switch (algorithm.toLowerCase()) {
            case "bubble":
                sortFunction = StudentStack::bubbleSortStudents;
                break;
            case "merge":
                sortFunction = StudentStack::mergeSortStudents;
                break;
            case "quick":
                sortFunction = StudentStack::quickSortStudents;
                break;
            case "selection":
                sortFunction = StudentStack::selectionSortStudents;
                break;
            default:
                System.out.println("Invalid sorting algorithm. Choose 'bubble', 'merge', 'quick', or 'selection'.");
                return;
        }
        // Đo thời gian thực thi thuật toán
        long startTime = System.nanoTime();
        sortFunction.accept(students); // Gọi hàm sắp xếp
        long endTime = System.nanoTime();
        displayStudents();
        long duration = endTime - startTime;
        System.out.println("Time taken: " + duration + " nanoseconds");
//        displayStudents(); // Hiển thị danh sách sinh viên sau sắp xếp
    }
}

