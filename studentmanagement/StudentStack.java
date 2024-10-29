package studentmanagement;

public class StudentStack {
    private Node top;

    private class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    public StudentStack() {
        this.top = null;
    }

    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
    }

    public Student pop() {
        Student student = top.student;
        top = top.next;
        return student;
    }

    public Student peek() {
        return top.student;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void sortStudents() {
        if (top == null || top.next == null) {
            System.out.println("Stack is empty");
            return; // No need to sort
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = top;
            Node previous = null;
            while (current != null && current.next != null) {
                if (current.student.getMarks() > current.next.student.getMarks()) {
                    // Swap students
                    Student temp = current.student;
                    current.student = current.next.student;
                    current.next.student = temp;
                    swapped = true;
                }
                previous = current;
                current = current.next;
            } System.out.println("Students sorted by marks:");
        } while (swapped);

    }
    }

