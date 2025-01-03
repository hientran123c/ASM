package BubbleSelectionSort;

// Main.java
public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        // Add students
        students[0] = new Student("S01", "John", 8.5);
        students[1] = new Student("S02", "Alice", 9.2);
        students[2] = new Student("S03", "Bob", 7.3);
        students[3] = new Student("S04", "Charlie", 6.8);
        students[4] = new Student("S05", "Ropz", 4);

        // Print unsorted students
        System.out.println("Unsorted students:");
        for (Student x : students) {
            System.out.println(x);
        }

        quickSort(students, 0, students.length - 1);
        // Print sorted students
        System.out.println("\nSorted students by score (Quick Sort):");
        for (Student x : students) {
            System.out.println(x);
        }
        // Bubble sort to sort students by score
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (students[j].getMarks() > students[j + 1].getMarks()) {
                    // Swap students
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        // Print sorted students
        System.out.println("\nSorted students by score(Bubble sort):");
        for (Student x : students) {
            System.out.println(x);
        }

        // Bubble sort to sort students by score
        int n1 = students.length;
        for (int i = 0; i < n1 - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n1; j++) {
                if (students[j].getMarks() < students[minIndex].getMarks()) {
                    minIndex = j;
                }
            }
            // Swap element
            Student temp = students[minIndex];
            students[minIndex] = students[i];
            students[i] = temp;
        }

//         Print sorted students
        System.out.println("\nSorted students by score(Selection sort):");
        for (Student x : students) {
            System.out.println(x);
        }


    }
    // Quick Sort method
    private static void quickSort(Student[] students, int low, int high) {
        if (low < high) {
            // Choose the pivot from the middle
            int mid = low + (high - low) / 2; // Midpoint for the pivot
            double pivot = students[mid].getMarks();

            // Move the pivot to the end
            Student temp = students[mid];
            students[mid] = students[high];
            students[high] = temp;

            int i = low - 1;

            for (int j = low; j < high; j++) {
                // If current element is smaller than or equal to pivot
                if (students[j].getMarks() <= pivot) {
                    i++;
                    // Swap students[i] and students[j]
                    temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
            // Swap students[i + 1] and students[high] (which is the pivot)
            temp = students[i + 1];
            students[i + 1] = students[high];
            students[high] = temp;
            // Recursively sort elements before and after partition
            quickSort(students, low, i);
            quickSort(students, i + 2, high);
        }
    }
}

