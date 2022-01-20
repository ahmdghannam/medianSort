package com.company;
import java.util.Random;

public abstract class Main {

    public static void main(String[] args) {
//        int[] a = {1, 5, 3, 7, 11, 8, -8, -26, 4, 20, 50, 1, 0, 1, 1, 5, 555555};
//        int[] a = {5, 5};
        int[] a = new int[2000];
        addRandomNumbers(a);
//        int[] a = new int[]{10,3,7,5,4,11};
//        int []a=new int[]{7,8,9,4,0,4,4,6,8,10};
        printArray(a);
        System.out.println();
        // average sort
        long startDate = System.nanoTime();
        Sorting.avgSort(a);
        long endDate = System.nanoTime();
        printArray(a);
        System.out.println(isItSorted(a));
        System.out.println();
        System.out.println("the avgSort time is : " + (endDate - startDate) + "ns");
        System.out.println("----------------");
        //med sort
        startDate = System.nanoTime();
        Sorting.medSort(a);
        endDate = System.nanoTime();
        printArray(a);
        System.out.println(isItSorted(a));
        System.out.println();
        System.out.println("the medSort time is : " + (endDate - startDate) + "ns");
        System.out.println("----------------");
        // quick sort
        startDate = System.nanoTime();
        Sorting.quickSort(a);
        endDate = System.nanoTime();
        printArray(a);
        System.out.println(isItSorted(a));
        System.out.println();
        System.out.println("the quickSort time is : " + (endDate - startDate) + "ns");
        System.out.println("----------------");
        //mergeSort
        startDate = System.nanoTime();
        Sorting.avgSort(a);
        endDate = System.nanoTime();
        printArray(a);
        System.out.println(isItSorted(a));
        System.out.println();
        System.out.println("the avgSort time is : " + (endDate - startDate) + "ns");
        System.out.println("----------------");


    }

    private static boolean isItSorted(int[] a) {

        for (int i = 1; i < a.length; i++) {
            if (a[i]<a[i-1])return false;
        }
        return true;
    }

    private static void addRandomNumbers(int[] aa) {
        Random rand = new Random();
        for (int i = 0; i < aa.length; i++) {
            aa[i] = rand.nextInt(1000000000);
        }
    }

    public static void printArray(int[] a) {
        for (int y : a) {
            System.out.print(y + "\t");
        }
        System.out.println();
    }
//        int addLast=a.length-1;
//        for (int i = 0; i < addLast; ) {
//            if (a[i] > 7) {
////                Sorting.swap(i,addLast--,a);
//                int t=a[addLast];
//                a[addLast]=a[i];
//                a[i]=t;
//                addLast--;
//            } else {
//                i++;
//            }
//            System.out.println("iteration:"+i);
//            printArray(a);
//        }
}