package TimeandSpaceComplexity;

public class Main6 {
    public static class Queue {
        private static final int capacity = 10;
        private int[] queue;
        private int front;
        private int rear;

        public Queue() {
            queue = new int[capacity];
            front = -1;
            rear = -1;
        }

        public boolean isEmpty() {
            // if there are no elements or
            // the queue has exceeded its rear
            if (front == -1 || front > rear) {
                return true;
            }

            return false;
        }

        public static void main(String[] args) {
            Queue q = new Queue();
            if (q.isEmpty()) {
                System.out.println("Queue is empty");
            } else {
                System.out.println("Queue is not empty");
            }
        }
    }
}

