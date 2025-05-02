package com.company;

public class MedianSort {
    public static int[] sortArray(int[] nums) {
        var minMax = minMax(nums);
        medSort(nums, 0, nums.length - 1, minMax[0], minMax[1]);
        return nums;
    }
    public static void medSort(int[] a, int start, int end, double min, double max) {
        //length of the array portion
        int length = ((end - start) + 1);
        var median = (min + max) / 2.0;
        // the first termination condition
        if (length <= 2) {
            if (length == 2 && a[start] > a[end])
                swap(start, end, a);
            return;
        }

        // termination condition to avoid the infinite loop when all elements are identical
        if (min == max) return;

        // actual medSort
        int addLast = end;
        int i = start;
        while (i < addLast + 1) {
            if (a[i] > median)
                swap(i, addLast--, a);
            else i++;
        }

        // left
        medSort(a, start, addLast, min, median);
        // right
        medSort(a, addLast + 1, end, median + 1, max);
    }
    public static int[] minMax(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        return new int[]{min, max};
    }
    public static void swap(int index, int index2, int[] a) {
        int t = a[index2];
        a[index2] = a[index];
        a[index] = t;
    }
}
