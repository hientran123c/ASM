package TimeandSpaceComplexity;

public class Main4 {
    static int capacity = 10;
    static class Queue {
        int queue[] = new int[capacity];
        int front;
        int rear;

        void enqueue(int val)
        {
            if(front==-1)
            {
                front++;
            }

            if(rear==capacity-1)
            {
                System.out.println("Queue overflow!!!");
                return;
            }

            queue[++rear] = val;
            System.out.println(val + " inserted successfully");
        }

    }

    public static void main(String[] args)
    {
        Queue q = new Queue();
        //Inserting elements in queue
        //using enqueue operation
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(2);
    }
}
