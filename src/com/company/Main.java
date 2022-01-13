package com.company;


import java.util.Arrays;
import java.util.Random;

public class Main {

        public static void main(String[] args) {
//          int []a={1,5,3,7,11,8,-8,-26,4,20,50,1,0,1,1,5,555555};
//           int []a={5,5};
//            int[] a =new int[1000000];
//            Random rand=new Random();
//            for (int i = 0; i <a.length ; i++) {
//                a[i]=rand.nextInt(1000);
//            }
            int []a=new int[]{7,8,9,4,0,4,6,8,10};
            for (int y:a) {
                System.out.print(y+"\t");
            }
            System.out.println();
            long startDate=System.nanoTime();

            Sorting.medSort(a);

            long endDate=System.nanoTime();

            for (int y:a) {
                System.out.print(y+"\t");

            }
            System.out.println();
            System.out.println("the time is : "+(endDate-startDate)+"ns");
        }


    }