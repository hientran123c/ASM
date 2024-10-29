package Example;

public class Main {
    public static void main(String[] args) {
        StackExample.StudentStack studentStack = new StackExample.StudentStack();

        // Add students to the stack (push operation)
        studentStack.push(new StackExample.Student("S01", "John", 8.5));
        studentStack.push(new StackExample.Student("S02", "Alice", 9.2));
        studentStack.push(new StackExample.Student("S03", "Bob", 7.3));

        // View the top element of the stack (peek operation)
        studentStack.peek();

        // Remove an element from the stack (pop operation)
        studentStack.pop();

        // Check the current size of the stack
        System.out.println("Stack size: " + studentStack.size());

        // Check if the stack is empty
        System.out.println("Is stack empty? " + studentStack.isEmpty());

        // Add a new element and peek again
        studentStack.push(new StackExample.Student("S04", "Charlie", 6.8));
        studentStack.peek();
    }
    public class StackExample {
            private static class Student {
            private String id;
            private String name;
            private double marks;

            public Student(String id, String name, double marks) {
                this.id = id;
                this.name = name;
                this.marks = marks;
            }

            @Override
            public String toString() {
                return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
            }
        }

        public static class StudentStack {
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
    }
}
