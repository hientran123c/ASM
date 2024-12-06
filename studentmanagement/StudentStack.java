package studentmanagement;

public class StudentStack {
    private Node top;

    private class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    public StudentStack() {
        this.top = null;
    }

    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
    }

    public Student pop() {
        Student student = top.student;
        top = top.next;
        return student;
    }

    public Student peek() {
        return top.student;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void bubbleSortStudents() {
        if (top == null || top.next == null) {
            System.out.println("Stack is empty or contains only one student.");
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Node current = top;

            while (current != null && current.next != null) {
                if (current.student.getMarks() > current.next.student.getMarks()) {
                    // Swap students
                    Student temp = current.student;
                    current.student = current.next.student;
                    current.next.student = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("Students sorted by Bubble Sort.");
    }


    // Merge Sort
    public void mergeSortStudents() {
        top = mergeSort(top);
        System.out.println("Students sorted by Merge Sort.");
    }
    private Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head; // Base case: single node or empty list
        }

        // Split the linked list into two halves
        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null;

        // Recursively sort both halves
        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);

        // Merge the sorted halves
        return merge(left, right);
    }
    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        Node result;
        if (left.student.getMarks() <= right.student.getMarks()) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }
    private Node getMiddle(Node head) {
        if (head == null) return head;

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Quick Sort
    public void quickSortStudents() {
        top = quickSort(top);
        System.out.println("Students sorted by Quick Sort.");
    }
    private Node quickSort(Node head) {
        if (head == null || head.next == null) {
            return head; // Base case: empty list or single element
        }
        // Partitioning step
        Node pivot = head; // Choose first element as pivot
        Node lessHead = new Node(null); // Dummy head for "less than pivot" list
        Node greaterHead = new Node(null); // Dummy head for "greater or equal to pivot" list
        Node less = lessHead, greater = greaterHead, current = head.next;

        while (current != null) {
            if (current.student.getMarks() < pivot.student.getMarks()) {
                less.next = current;
                less = less.next;
            } else {
                greater.next = current;
                greater = greater.next;
            }
            current = current.next;
        }
        // Disconnect the last nodes
        less.next = null;
        greater.next = null;

        // Recursively sort the sublists
        Node sortedLess = quickSort(lessHead.next);
        Node sortedGreater = quickSort(greaterHead.next);

        // Combine the sorted lists with the pivot
        return concatenate(sortedLess, pivot, sortedGreater);
    }
    private Node concatenate(Node less, Node pivot, Node greater) {
        Node result = less;

        // Find the end of the "less" list and attach the pivot
        if (less != null) {
            while (less.next != null) {
                less = less.next;
            }
            less.next = pivot;
        } else {
            result = pivot; // If "less" list is empty, pivot becomes the head
        }

        pivot.next = greater; // Attach the "greater" list
        return result;
    }

    // Selection Sort
    public void selectionSortStudents() {
        if (top == null || top.next == null) {
            System.out.println("Stack is empty or contains only one student.");
            return;
        }

        Node current = top;
        while (current != null) {
            Node minNode = current;
            Node nextNode = current.next;

            // Find the minimum node in the unsorted part
            while (nextNode != null) {
                if (nextNode.student.getMarks() < minNode.student.getMarks()) {
                    minNode = nextNode;
                }
                nextNode = nextNode.next;
            }

            // Swap the current node with the minimum node
            if (minNode != current) {
                Student temp = current.student;
                current.student = minNode.student;
                minNode.student = temp;
            }

            current = current.next; // Move to the next node
        }

        System.out.println("Students sorted by Selection Sort.");
    }
    }

