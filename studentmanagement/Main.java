package studentmanagement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement management = new StudentManagement();
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Sort Students");
            System.out.println("6. Display All Students");
            System.out.println("7. Generate Random Students");
            System.out.println("8. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: // Add Student
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    double marks;
                    while (true) {
                        System.out.print("Enter student marks (0 to 10): ");
                        marks = scanner.nextDouble();
                        if (marks < 0 || marks > 10) {
                            System.out.println("Invalid marks. Please enter a number between 0 and 10.");
                        } else {
                            break; // Exit the loop if input is valid
                        }
                    }
                    management.addStudent(new Student(id, name, marks));
                    break;

                case 2: // Update Student
                        scanner.nextLine(); // Consume newline
                        String updateId;
                        boolean found = false;

                        // Loop until a valid ID is entered or operation is cancelled
                        do {
                            System.out.print("Enter student ID to update (or type 'cancel' to exit): ");
                            updateId = scanner.nextLine();

                            if (updateId.equalsIgnoreCase("cancel")) {
                                System.out.println("Update operation canceled.");
                                break;
                            }

                            if (management.searchStudent(updateId) != null) {
                                found = true; // ID exists, continue to update
                            } else {
                                System.out.println("Student with ID " + updateId + " not found. Please enter a valid ID.");
                            }
                        } while (!found);

                        if (found) {
                            System.out.print("Enter new name: ");
                            String newName = scanner.nextLine();

                            double newMarks;
                            while (true) {
                                System.out.print("Enter new marks (0 to 10): ");
                                newMarks = scanner.nextDouble();
                                if (newMarks < 0 || newMarks > 10) {
                                    System.out.println("Invalid marks. Please enter a number between 0 and 10.");
                                } else {
                                    break; // Exit the loop if input is valid
                                }
                            }

                            management.updateStudent(updateId, newName, newMarks);
                            System.out.println("Updated Student: ID=" + updateId + ", New Name=" + newName + ", New Marks=" + newMarks);
                        } break;

                case 3: // Delete Student
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    if (management.searchStudent(deleteId) != null) {
                        management.deleteStudent(deleteId);
                        System.out.println("Successfully deleted student with ID=" + deleteId);
                    } else {
                        System.out.println("Student with ID " + deleteId + " not found. No deletion performed.");
                    }
                    break;

                case 4: // Search Student
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student ID to search: ");
                    String searchId = scanner.nextLine();
                    Student foundStudent = management.searchStudent(searchId);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;

                case 5: // Sort Students
                    System.out.println("Choose sorting algorithm: 'bubble', 'merge', 'quick', or 'selection'");
                    scanner.nextLine(); // Consume newline
                    String algorithm = scanner.nextLine();
                    management.sortAndAnalyze(algorithm);
                    break;

                case 6: // Display All Students
                    System.out.println("List of all students:");
                    management.displayStudents();
                    break;

                case 7: // Generate Random Students
                    System.out.print("Enter the number of random students to generate: ");
                    int count = scanner.nextInt();
                    management.generateRandomStudents(count);
                    break;

                case 8: // Exit
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

