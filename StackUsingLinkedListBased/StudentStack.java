package StackUsingLinkedListBased;

// StudentStack.java
public class StudentStack {
    private Node top;  // Top of the stack
    private int size;  // Size of the stack

    // Node class for the linked list
    private static class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    public StudentStack() {
        top = null;
        size = 0;
    }

    // Push: Add an element to the stack
    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;  // Link the new node to the previous top
        top = newNode;       // Update top to the new node
        size++;
        System.out.println("Pushed: " + student);
    }

    // Pop: Remove an element from the stack
    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop any elements.");
            return null;
        }
        Student student = top.student;
        top = top.next;  // Move top to the next node
        size--;
        System.out.println("Popped: " + student);
        return student;
    }

    // Peek: Look at the top element without removing it
    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! No elements to peek.");
            return null;
        }
        System.out.println("Peeked: " + top.student);
        return top.student;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Return the current size of the stack
    public int size() {
        return size;
    }
}
