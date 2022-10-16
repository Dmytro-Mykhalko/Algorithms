import java.util.Arrays;

import static util.Util.createAndFillArray;
import static util.Util.isSorted;

/*
 * Similar to the way you sort playing cards in your hands.
 * The array is virtually split into a sorted and an unsorted part.
 * Values from the unsorted part are picked and placed at the correct position in the sorted part.
 *
 * Time Complexity
 * O(n^2) -> O(n^2)
 *
 * Space complexity
 * O(1)
 * */
public class InsertionSort {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int k = i;

            while (k > 0 && value < arr[k - 1]) {
                arr[k] = arr[k - 1];
                k--;
            }
            arr[k] = value;
        }
    }

    public static void main(String[] args) {
        int volume = 10;
        int maxValue = 10000;
        int[] nums = createAndFillArray(volume, maxValue);
        System.out.println(Arrays.toString(nums));
        System.out.println("Before sort array is sorted: " + isSorted(nums));

        sort(nums);
        System.out.println(Arrays.toString(nums));

        System.out.println("After sort array is sorted: " + isSorted(nums));
    }
}
