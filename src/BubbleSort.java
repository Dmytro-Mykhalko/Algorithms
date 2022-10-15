import static util.Util.createAndFillArray;
import static util.Util.isSorted;

/*
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element
 * (considering ascending order) from the unsorted part and putting it at the beginning.
 *
 * Time Complexity
 * O(n^2) -> O(n^2)
 *
 * Space complexity
 * O(1)
 * */
public class BubbleSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int volume = 1000;
        int maxValue = 10;
        int[] nums = createAndFillArray(volume, maxValue);
        System.out.println("Before sort array is sorted: " + isSorted(nums));

        sort(nums);
        System.out.println("After sort array is sorted: " + isSorted(nums));
    }
}
