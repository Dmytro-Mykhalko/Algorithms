import java.util.Arrays;

import static util.Util.createAndFillArray;
import static util.Util.isSorted;

/*
 * Picks an element as a pivot and partitions the given array around the picked pivot.
 *
 * Time Complexity
 * O(n*logn) -> O(n^2)
 *
 * Space complexity
 * O(n)
 * */
public class QuickSort {

    public static void sort(int[] arr) {
        if (arr != null && arr.length > 1)
            quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // partition index
            quickSort(arr, low, pi - 1); // before pi
            quickSort(arr, pi + 1, high); // after pi
        }
    }

    /* This function takes last element as pivot,
    places the pivot element at its correct position in sorted array,
    and places all smaller (smaller than pivot) to left of pivot
    and all greater elements to right of pivot */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int swapCounter = low;

        // don't include high, because it's our pivot point
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                int temp = arr[swapCounter];
                arr[swapCounter] = arr[i];
                arr[i] = temp;
                swapCounter++;
            }
        }
        // swap pivot with the 1st value that is bigger than pivot
        arr[high] = arr[swapCounter];
        arr[swapCounter] = pivot;

        return swapCounter;
    }

    public static void main(String[] args) {
        int volume = 10;
        int maxValue = 99;
        int[] nums = createAndFillArray(volume, maxValue);
        System.out.println(Arrays.toString(nums));
        System.out.println("Before sort array is sorted: " + isSorted(nums));

        sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("After sort array is sorted: " + isSorted(nums));
    }
}
