package com.company;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] aa = {1, 5, 3, 7, 11, 8, -8, -26, 4, 20, 50, 1, 0, 1, 1, 5, 555555};
        int[] aaaa = {5, 5};
        int[] aaa = new int[1000000];
        addRandomNumbers(aaa);
        int[] a = new int[]{7, 8, 9, 4, 0, 4, 6, 8, 10};
        printArray(aa);
        System.out.println();
        long startDate = System.nanoTime();
        Sorting.medSort(aa);
        long endDate = System.nanoTime();
        printArray(aa);
        System.out.println();
        System.out.println("the time is : " + (endDate - startDate) + "ns");
    }
    private static void addRandomNumbers(int[] aa) {
        Random rand = new Random();
        for (int i = 0; i < aa.length; i++) {
            aa[i] = rand.nextInt(1000);
        }
    }
    private static void printArray(int[] a) {
        for (int y : a) {
            System.out.print(y + "\t");
        }
        System.out.println();
    }


}