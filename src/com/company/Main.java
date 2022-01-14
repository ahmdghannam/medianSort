package com.company;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        int[] a = {1, 5, 3, 7, 11, 8, -8, -26, 4, 20, 50, 1, 0, 1, 1, 5, 555555};
//        int[] a = {5, 5};
        int[] a = new int[1000000];
        addRandomNumbers(a);
//        int[] a = new int[]{10,3,7,5,4,11};
//        int []a=new int[]{7,8,9,4,0,4,6,8,10};
        printArray(a);
        System.out.println();

        long startDate = System.nanoTime();

        Sorting.medSort(a);

        long endDate = System.nanoTime();
        printArray(a);
        System.out.println(isIySorted(a));
        System.out.println();
        System.out.println("the time is : " + (endDate - startDate) + "ns");
    }

    private static boolean isIySorted(int[] a) {
        int min=0;
        for (int i = 0; i < a.length; i++) {
            if (a[i]<a[min])min=i;
        }
        return min==0;
    }

    private static void addRandomNumbers(int[] aa) {
        Random rand = new Random();
        for (int i = 0; i < aa.length; i++) {
            aa[i] = rand.nextInt(10);
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