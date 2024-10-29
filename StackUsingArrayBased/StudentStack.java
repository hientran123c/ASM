package StackUsingArrayBased;

// StudentStack.java
public class StudentStack {
    private Student[] stack;
    private int top;

    public StudentStack() {
        stack = new Student[10];  // Initialize with a size of 10
        top = -1;
    }

    // Push: Add an element to the stack
    public void push(Student student) {
        if (top == stack.length - 1) {
            System.out.println("Stack is full! Cannot push more elements.");
            return;
        }
        stack[++top] = student;
        System.out.println("Pushed: " + student);
    }

    // Pop: Remove an element from the stack
    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop any elements.");
            return null;
        }
        Student student = stack[top--];
        System.out.println("Popped: " + student);
        return student;
    }

    // Peek: Look at the top element without removing it
    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! No elements to peek.");
            return null;
        }
        System.out.println("Peeked: " + stack[top]);
        return stack[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Return the current size of the stack
    public int size() {
        return top + 1;
    }
}
