package TimeandSpaceComplexity;

public class Main3 {
    public static void main (String[] args) {

        Stack st = new Stack();
        st.push(1);
        st.push(2);

        System.out.println("Peek element of stack : "
                + st.peek() + "\n");

    }
    static class Stack {
        int[] stack = new int[10];
        int MAX = 10;
        int top;

        Stack() { top = -1; }

        void push(int val)
        {
            // If top is pointing to maximum size of stack
            if (top >= MAX - 1) {

                // Stack is full
                System.out.println("Stack Overflow");
                return;
            }

            // Point top to new top
            top++;

            // Insert new element at top of stack
            stack[top] = val;
            System.out.println(
                    val + " pushed into stack successfully !");
        }

        int peek()
        {
            // Stack is already empty then
            // we can't get peek element
            if (top < 0) {
                System.out.println("Stack is Empty\n");
                return 0;
            }
            else {

                // Retrieving top element from stack
                int x = stack[top];
                return x;
            }
        }
    }
}

