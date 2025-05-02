package com.company;

import com.company.CustomArrays.ArrayDesc;

import java.util.Random;

public class Utils {
    public static boolean isItSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) return false;
        }
        return true;
    }
    public static void addRandomNumbers(int[] aa) {
        Random rand = new Random();
        for (int i = 1; i < aa.length; i++) {
            aa[i] = rand.nextInt(100000000, 1000000000);
        }
    }
    public static void printArray(int[] a) {
        for (int y : a) {
            System.out.print(y + "\t");
        }
        System.out.println();
    }
    public static void swap(int index, int index2, int[] a) {
        int t=a[index2];
        a[index2]=a[index];
        a[index]=t;
    }
    public static void copyArrays(int[] a, int start, int end, int[] temp) {
        for (int i = start; i <= end; i++) {
            temp[i - start] = a[i];
        }
    }
    public static ArrayDesc minMax(int[] a, int start, int end) {
        int min = a[start];
        int max = a[start];
        for (int i = start; i <= end; i++) {
            if (a[i] > max) max = a[i];
            if (a[i] < min) min = a[i];
        }

        return new ArrayDesc(min, max);
    }
    public static int[] minMaxArr(int[] a, int start, int end) {
        int min = a[start];
        int max = a[start];
        for (int i = start; i <= end; i++) {
            if (a[i] > max) max = a[i];
            if (a[i] < min) min = a[i];
        }

        return new int[]{min, max};
    }
}
