package QueueUsingLinkedListBased;

// StudentQueue.java
public class StudentQueue {
    private Node front;
    private Node rear;
    private int size;

    // Node class for linked list
    private class Node {
        Student student;
        Node next;

        public Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    public StudentQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Enqueue: Add an element to the end of the queue
    public void enqueue(Student student) {
        Node newNode = new Node(student);
        if (rear == null) {  // Queue is empty
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Enqueued: " + student);
    }

    // Dequeue: Remove an element from the front of the queue
    public Student dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue any elements.");
            return null;
        }
        Student student = front.student;
        front = front.next;
        if (front == null) {  // Queue becomes empty after dequeue
            rear = null;
        }
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
        System.out.println("Peeked: " + front.student);
        return front.student;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Return the current size of the queue
    public int size() {
        return size;
    }
}

