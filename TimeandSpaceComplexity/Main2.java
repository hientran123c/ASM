package TimeandSpaceComplexity;

public class Main2 {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(1);
        st.pop();
        st.pop();
    }

    static class Stack {
        int[] stack = new int[10];
        int MAX = 10;
        int top;

        Stack() {
            top = -1;
        }

        void push(int val) {
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

        void pop() {
            // Stack is already empty
            if (top < 0) {
                System.out.print("Stack Underflow");
            } else {
                // Removing top of stack
                int x = stack[top--];
                System.out.println(
                        "Element popped from stack : " + x);
            }

        }
    }
}

