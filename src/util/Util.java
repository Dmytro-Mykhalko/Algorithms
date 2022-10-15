package util;

import java.util.Random;


public class Util {

    public static int[] createAndFillArray(int volume, int maxValue) {
        Random random = new Random();
        int[] result = new int[volume];

        for (int i = 0; i < result.length; i++)
            result[i] = random.nextInt(maxValue + 1);

        return result;
    }

    public static boolean isSorted(int[] arr) {
        if (arr == null)
            throw new IllegalArgumentException("Input array can't be null");

        for (int i = 1; i < arr.length; i++)
            if(arr[i] < arr[i-1])
                return false;

        return true;
    }
}
