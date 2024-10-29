package LinkedListExample;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;
public class Main {
        public static void main(String[] args) {
            // Create a LinkedList
            LinkedList<Integer> linkedList = new LinkedList<>();

            // 1. Insertion: Add elements to the linked list
            linkedList.add(10);  // Adding at the end (default)
            linkedList.add(30);
            linkedList.add(20);
            linkedList.addFirst(5);  // Adding at the beginning
            linkedList.addLast(40);  // Adding at the end

            // 2. Traversal: Access and print each element
            System.out.println("Traversal: Elements in the linked list:");
            Iterator<Integer> iterator = linkedList.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();  // Line break

            // 3. Deletion: Remove elements from the linked list
            linkedList.remove(2);  // Remove element at index 2
            linkedList.removeFirst();  // Remove the first element
            linkedList.removeLast();   // Remove the last element

            System.out.println("After deletion: " + linkedList);

            // 4. Search: Find an element in the linked list
            int searchElement = 20;
            if (linkedList.contains(searchElement)) {
                System.out.println("Element " + searchElement + " found in the linked list.");
            } else {
                System.out.println("Element " + searchElement + " not found in the linked list.");
            }

            // 5. Sort: Sort the elements in the linked list
            Collections.sort(linkedList);
            System.out.println("Sorted linked list: " + linkedList);
        }
    }

