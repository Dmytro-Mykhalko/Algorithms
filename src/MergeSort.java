import java.util.Arrays;

import static util.Util.createAndFillArray;
import static util.Util.isSorted;

/*
 * Based on the Divide and Conquer paradigm.
 * In this algorithm, the array is initially divided into two equal halves,
 * and then they are combined in a sorted manner.
 *
 * Time Complexity
 * O(n*logn) -> O(n*logn)
 *
 * Space complexity
 * O(n)
 * */
public class MergeSort {

    public static void sort(int[] arr) {
        if (arr != null && arr.length > 1) {
            int left = 0;
            int right = arr.length - 1;
            mergeSort(arr, left, right);
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int sizeLeft = middle - left + 1;
        int sizeRight = right - middle;

        int[] leftArr = new int[sizeLeft];
        int[] rightArr = new int[sizeRight];

        for (int i = 0; i < sizeLeft; i++)
            leftArr[i] = arr[left + i];
        for (int i = 0; i < sizeRight; i++)
            rightArr[i] = arr[middle + 1 + i];

        int i = 0, j = 0;
        int k = left;
        while (i < sizeLeft && j < sizeRight) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < sizeLeft) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < sizeRight) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int volume = 15;
        int maxValue = 99;
        int[] nums = createAndFillArray(volume, maxValue);
        System.out.println(Arrays.toString(nums));
        System.out.println("Before sort array is sorted: " + isSorted(nums));

        sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("After sort array is sorted: " + isSorted(nums));
    }
}
