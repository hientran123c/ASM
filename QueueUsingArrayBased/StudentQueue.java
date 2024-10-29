package QueueUsingArrayBased;

// StudentQueue.java
public class StudentQueue {
    private Student[] queue;
    private int front;
    private int rear;
    private int size;

    public StudentQueue() {
        queue = new Student[10];  // Initialize with a size of 10
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue: Add an element to the queue
    public void enqueue(Student student) {
        if (size == queue.length) {
            System.out.println("Queue is full! Cannot enqueue more elements.");
            return;
        }
        rear++;
        queue[rear] = student;
        size++;
        System.out.println("Enqueued: " + student);
    }

    // Dequeue: Remove an element from the queue
    public Student dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue any elements.");
            return null;
        }
        Student student = queue[front];
        front++;
        size--;
        System.out.println("Dequeued: " + student);
        return student;
    }

    // Peek: Look at the front element without removing it
    public Student peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No elements to peek.");
            return null;
        }
        System.out.println("Peeked: " + queue[front]);
        return queue[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Return the current size of the queue
    public int size() {
        return size;
    }
}
