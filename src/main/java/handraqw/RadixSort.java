package handraqw;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {

        int[] arr1 = {123456, 654321, 111111};
        int[] arr2 = {9000, 1000, 99};

        sort(arr1);
        sort(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void sort(int[] arr) {

        if (arr.length == 0) {
            return;
        }

        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < 0) {
                return;
            }

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int place = 1; max / place > 0; place *= 10) {
            countingSortByDigit(arr, place);
        }
    }

    private static void countingSortByDigit(int[] arr, int place) {

        int[] count = new int[10];

        for (int i = 0; i < arr.length; i++) {
            int digit = (arr[i] / place) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] = count[i] + count[i - 1];
        }

        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            int digit = (arr[i] / place) % 10;

            count[digit]--;
            result[count[digit]] = arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }
}