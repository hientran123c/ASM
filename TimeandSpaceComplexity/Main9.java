package TimeandSpaceComplexity;

public class Main9 {
    public class StackExample {
        public static void main(String[] args) {
            Stack st = new Stack();
            st.push(3);
            st.push(1);
            st.push(4);
            st.push(2);

            System.out.println("Stack before sorting:");
            st.printStack();

            st.sort();

            System.out.println("Stack after sorting:");
            st.printStack();
        }

        static class Stack {
            int[] stack = new int[10];
            int MAX = 10;
            int top;

            Stack() {
                top = -1;
            }

            void push(int val) {
                if (top >= MAX - 1) {
                    System.out.println("Stack Overflow");
                    return;
                }
                top++;
                stack[top] = val;
                System.out.println(val + " pushed into stack successfully !");
            }

            void sort() {
                for (int i = 0; i <= top - 1; i++) {
                    for (int j = 0; j <= top - 1 - i; j++) {
                        if (stack[j] > stack[j + 1]) {
                            // Swap
                            int temp = stack[j];
                            stack[j] = stack[j + 1];
                            stack[j + 1] = temp;
                        }
                    }
                }
                System.out.println("Stack sorted successfully!");
            }

            void printStack() {
                if (top < 0) {
                    System.out.println("Stack is Empty\n");
                    return;
                }
                for (int i = top; i >= 0; i--) {
                    System.out.println(stack[i]);
                }
            }
        }
    }


}
