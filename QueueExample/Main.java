package QueueExample;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
    public class QueueExample {

        public static void main(String[] args) {
            // Create a Queue using LinkedList
            Queue<String> queue = new LinkedList<>();

            // Enqueue: Add elements to the queue
            System.out.println("Enqueue: Adding elements to the queue");
            queue.add("John");
            queue.add("Alice");
            queue.add("Bob");

            // Display the queue
            System.out.println("Queue after enqueuing: " + queue);

            // Peek: View the first element in the queue without removing it
            System.out.println("Peek: The first element in the queue is " + queue.peek());

            // Dequeue: Remove the first element from the queue
            System.out.println("Dequeue: Removing element " + queue.remove());

            // Display the queue after dequeue
            System.out.println("Queue after dequeuing: " + queue);

            // Check the size of the queue
            System.out.println("Size of the queue: " + queue.size());

            // Check if the queue is empty
            System.out.println("Is the queue empty? " + queue.isEmpty());

            // Dequeue remaining elements
            queue.remove();
            queue.remove();

            // Check if the queue is empty after removing all elements
            System.out.println("Queue after removing all elements: " + queue);
            System.out.println("Is the queue empty now? " + queue.isEmpty());
        }
    }
}
