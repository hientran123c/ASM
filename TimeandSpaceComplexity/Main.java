package TimeandSpaceComplexity;

class Main {
    static class Stack {
        int stack[] = new int[10];
        int MAX = 10;
        int top;

        void stack() { top = -1; }

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
    }
    public static void main(String[] args)
    {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
    }
}