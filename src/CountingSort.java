import static util.Util.*;

/*
* Sorting technique based on keys between a specific range.
* It works by counting the number of objects having distinct key values (kind of hashing).
* Then do some arithmetic to calculate the position of each object in the output sequence.
*
* Time Complexity
* O(n+k) -> O(n+k)
*
* Space complexity
* O(k)
* */
public class CountingSort {

    public static void sort(int[] input, int maxValue) {
        int[] output = new int[input.length];
        int[] count = new int[maxValue + 1];

        for (int k : input) ++count[k];

        for (int i = 0; i < count.length - 1; i++)
            count[i + 1] += count[i];

        for (int i = 0; i < output.length ; i++) {
            output[count[input[i]] - 1] = input[i];
            --count[input[i]];
        }

        for (int i = 0; i < output.length; i++)
            input[i] = output[i];
    }

    private static void customSort(int[] arr, int maxValue) {
        int[] count = new int[maxValue + 1];

        for (int k : arr) ++count[k];

        for (int i = 0, j = 0; i < arr.length && j < count.length ; i++, j++) {
            if (count[j] > 0) {
                arr[i] = j;
                --count[j];
                j--; // so in new iteration j will have the same value
            } else i--; // so we won't miss to fill arr[i] in the next iteration
        }
    }

    public static void main(String[] args) {
        int volume = 1000;
        int maxValue = 5;
        int[] nums = createAndFillArray(volume, maxValue);
        System.out.println("Before sort is sorted: " + isSorted(nums));

        sort(nums, maxValue);
        System.out.println("After sort is sorted: " + isSorted(nums));
    }
}