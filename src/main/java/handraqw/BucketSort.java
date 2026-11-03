package handraqw;

import java.util.ArrayList; import java.util.Arrays; import java.util.List;

public class BucketSort {

    public static void main(String[] args) {

        double[] arr1 = {0.30, 0.95, 0.05, 0.60};
        double[] arr2 = {0.40, 0.01, 0.99};

        sort(arr1);
        sort(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void sort(double[] arr) {

        if (arr.length == 0) return;

        int n = arr.length;

        List<List<Double>> buckets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        for (double value : arr) {
            int index = (int) (value * n);
            buckets.get(index).add(value);
        }

        int index = 0;

        for (List<Double> bucket : buckets) {

            insertionSort(bucket);

            for (double value : bucket) {
                arr[index] = value;
                index++;
            }
        }
    }

    private static void insertionSort(List<Double> bucket) {

        for (int i = 1; i < bucket.size(); i++) {

            double key = bucket.get(i);
            int j = i - 1;

            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }

            bucket.set(j + 1, key);
        }
    }
}