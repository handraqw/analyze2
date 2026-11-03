package handraqw;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {

        int[] arr1 = {6, 1, 6, 3, 2};
        int[] arr2 = {4, 4, 2, 5};

        sort(arr1);
        sort(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void sort(int[] arr) {

        int[] count = new int[7];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int index = 0;

        for (int i = 1; i <= 6; i++) {

            for (int j = 0; j < count[i]; j++) {
                arr[index] = i;
                index++;
            }
        }
    }

}
