package com.company;

public abstract class Main {
    public static void main(String[] args){
        int[] a = new int[1000000];
        a[0] = 1;
        Utils.addRandomNumbers(a);
        Utils.printArray(a);
        System.out.println();
        // median sort
        long startDate = System.nanoTime();
        MedianSort.sortArray(a);
        long endDate = System.nanoTime();
        Utils.printArray(a);
        System.out.println(Utils.isItSorted(a));
        System.out.println();
        System.out.println("the time is : " + (endDate - startDate) + "ns");
        System.out.println("----------------");
    }
}
