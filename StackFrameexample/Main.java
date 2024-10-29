package StackFrameexample;

public class Main {
    public static int findProduct(int a, int b) {
        int product = a * b;
        return product;
    }

    // findSum method
    public static int findSum(int a, int b) {
        int sum = a + b;
        return sum;
    }

    // main function
    public static void main(String[] args) {
        int a = 6;
        int b = 6;
        // findProduct method called
        int product = findProduct(a, b);
        // findSum method called
        int sum = findSum(a, b);
        System.out.println("Product is: " + product);
        System.out.println("Sum is: " + sum);
    }
}
