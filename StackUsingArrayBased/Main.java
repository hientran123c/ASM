package StackUsingArrayBased;

// Main.java
public class Main {
    public static void main(String[] args) {
        StudentStack studentStack = new StudentStack();
        // Add students to the stack (push operation)
        studentStack.push(new Student("S01", "John", 8.5));
        studentStack.push(new Student("S02", "Alice", 9.2));
        studentStack.push(new Student("S03", "Bob", 7.3));
        // View the top element of the stack (peek operation)
        studentStack.peek();
        // Remove an element from the stack (pop operation)
        studentStack.pop();
        // Check the current size of the stack
        System.out.println("Stack size: " + studentStack.size());
        // Check if the stack is empty
        System.out.println("Is stack empty? " + studentStack.isEmpty());
        // Add a new element and peek again
        studentStack.push(new Student("S04", "Charlie", 6.8));

    }
}

