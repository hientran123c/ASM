package QueueUsingLinkedListBased;

// Main.java
public class Main {
    public static void main(String[] args) {
        StudentQueue studentQueue = new StudentQueue();

        // Add students to the queue (enqueue operation)
        studentQueue.enqueue(new Student("S01", "John", 8.5));
        studentQueue.enqueue(new Student("S02", "Alice", 9.2));
        studentQueue.enqueue(new Student("S03", "Bob", 7.3));

        // View the front element of the queue (peek operation)
        studentQueue.peek();

        // Remove an element from the queue (dequeue operation)
        studentQueue.dequeue();

        // Check the current size of the queue
        System.out.println("Queue size: " + studentQueue.size());

        // Check if the queue is empty
        System.out.println("Is queue empty? " + studentQueue.isEmpty());

        // Add a new element and peek again
        studentQueue.enqueue(new Student("S04", "Charlie", 6.8));
        studentQueue.peek();
    }
}

