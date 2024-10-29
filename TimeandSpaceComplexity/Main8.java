package TimeandSpaceComplexity;

public class Main8 {
    public static void main(String[] args)
    {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
    }


       public static class Queue {
            int capacity = 10;
            int queue[] = new int[capacity];
            int front;
            int rear;

            void Queue()
            {
                front = -1;
                rear = -1;
            }

            void enqueue(int val)
            {
                if (front == -1) {
                    front++;
                }

                if (rear == capacity - 1) {
                    System.out.println("Queue overflow!!!");
                    return;
                }

                queue[++rear] = val;
            }
            void dequeue()
            {
                if (front == -1 || front > rear) {
                    System.out.println("Queue is empty!!!");
                }
                System.out.println(
                        "Element deleted from queue : "
                                + queue[front + 1]);
            }
        }

    }

