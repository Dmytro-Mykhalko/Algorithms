import static util.Util.createAndFillArray;
import static util.Util.isSorted;

/*
 * Repeatedly swapping the adjacent elements if they are in the wrong order.
 * This algorithm is not suitable for large data sets as its average and worst-case time complexity is quite high.
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
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
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
