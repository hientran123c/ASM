package LanguageTransitions;

public class Main {
    public class BubbleSort {
        public static void bubbleSort(int[] arr) {
            int n = arr.length;
            boolean swapped;
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // Hoán đổi arr[j] và arr[j+1]
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                    }
                }
                // Nếu không có hoán đổi nào, mảng đã được sắp xếp
                if (!swapped) break;
            }
        }

        public static void main(String[] args) {
            int[] arr = {64, 34, 25, 12, 22, 11, 90};
            bubbleSort(arr);
            System.out.println("Sorted array:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
        }
    }

//    Pythoncode

//    def bubble_sort(arr):
//    n = len(arr)
//    for i in range(n - 1):
//    swapped = False
//        for j in range(n - i - 1):
//            if arr[j] > arr[j + 1]:
//            # Hoán đổi arr[j] và arr[j + 1]
//    arr[j], arr[j + 1] = arr[j + 1], arr[j]
//    swapped = True
//        # Nếu không có hoán đổi nào, mảng đã được sắp xếp
//        if not swapped:
//            break
//
//            # Ví dụ sử dụng
//    arr = [64, 34, 25, 12, 22, 11, 90]
//    bubble_sort(arr)
//    print("Sorted array:")
//    print(arr)
}
