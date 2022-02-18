package com.company;

import java.util.ArrayList;

public abstract class Sorting {

    // median sort
    public static void medSort(int[] a) {
        medSort(a,0, a.length-1);

    }
    public static void parallelMedSort(int[] a) {
        try {
            parallelMedSort(a,0, a.length-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static  void medSort(int []a, int start, int end){

        //length of the array portion
        int length=((end-start)+1);

        // the first termination condition
        if(length<=2){
        if(length==2&&a[start]>a[end])
               swap(start,end,a);
           return;
        }

        // finding min and max in one loop
        ArrayDesc arrayDesc=minMax(a,start,end);

        // termination condition to avoid the infinite loop when all elements are identical
        if (arrayDesc.minEqualsMax())return;

        // actual medSort
        int addLast=end;
        int i = start;
        while (i < addLast+1){
            if (a[i] > arrayDesc.getMedian())
                swap(i,addLast--,a);
            else i++;
        }

        // left
        medSort(a,start,addLast);
        // right
        medSort(a,addLast+1,end);



    }
    public static void parallelMedSort(int []a, int start, int end) throws InterruptedException {

        //length of the array portion
        int length=((end-start)+1);

        // the first termination condition
        if(length<=2){
            if(length==2&&a[start]>a[end])
                swap(start,end,a);
            return;
        }

        // finding min and max in one loop
        ArrayDesc arrayDesc=minMax(a,start,end);

        // termination condition to avoid the infinite loop when all elements are identical
        if (arrayDesc.minEqualsMax())return;

        // actual medSort
        int addLast=end;
        int i = start;
        while (i < addLast+1){
            if (a[i] > arrayDesc.getMedian())
                swap(i,addLast--,a);
            else i++;
        }

        // left
        int finalAddLast = addLast;
        Runnable runnable=()->{
        medSort(a,start, finalAddLast);
        };
        Thread thread=new Thread(runnable);
        thread.join();

        // right
        int finalAddLast1 = addLast;
        Runnable runnable1=()-> {
            medSort(a, finalAddLast1 + 1, end);
        };
        Thread thread1=new Thread(runnable1);
         thread1.join();

    }
    // average sort
    public static void avgSort(int[] a) {
        avgSort(a,0, a.length-1);

    }
    public static  void avgSort(int []a, int start, int end){

        //length of the array portion
        int length=((end-start)+1);

        // the first termination condition
        if(length<=2){
            if(length==2&&a[start]>a[end])
                swap(start,end,a);
            return;
        }

        // finding min and max in one loop
        int avg=avg(a,start,end);

        // actual medSort
        int addLast=end;
        int i = start;
        while (i < addLast+1){
            if (a[i] >avg)
                swap(i,addLast--,a);
            else i++;
        }

        // left
        medSort(a,start,addLast);
        // right
        medSort(a,addLast+1,end);



    }
    private static int avg(int[] a, int start, int end) {
        int sum=0;
        int length=((end-start)+1);
        for (int s:a) {
            sum+=s;
        }
        return sum/length;
    }

    // stuff
    public static void swap(int index, int index2, int[] a) {
        int t=a[index2];
        a[index2]=a[index];
        a[index]=t;

    }
    private static void copyArrays(int[] a, int start, int end, int[] temp) {
        for (int i = start; i <= end; i++) {
            temp[i- start]= a[i];
        }
    }
    public static ArrayDesc minMax(int[] a, int start, int end) {
        int min=a[start];
        int max =a[start];
        for (int i = start; i <= end; i++) {
            if(a[i]>max)max=a[i];
            if(a[i]<min)min=a[i];
        }

        return new ArrayDesc(min,max);
    }

    // quick sort
    public static void quickSort(int[] arr){
        quickSort(arr, 0,arr.length-1);
    }
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int addFirst=low;

        for(int i=low;i<high;i++){
            if(arr[i]<pivot){
                swap(addFirst++,i,arr);
            }
        }
        swap(addFirst,high,arr);
        return addFirst;

    }
    public static void quickSort(int[] arr, int low, int high){

        if(low<high){     //checks if the array is more than one item
            int p = partition(arr,low,high);
            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }

    }

    // insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;

            /* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

    // selection sort
    public static void selectionSort(int[] arr) {
        int small;
        for (int i = 0; i <arr.length - 1; i++)
        {
            small = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                //if current position is less than previous smallest
                if (arr[j] < arr[small])
                {
                    small = j;

                    //swap values
                    int temp = arr[i];
                    arr[i] = arr[small];
                    arr[small] = temp;
                }
            }
        }
    }

    //merge sort
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
    public static void mergeSort(int[] a) {
        mergeSort(a,a.length);
    }

    // binary search
    public static int binarySearch(int []a,int k){
        return binarySearch(a,k,0,a.length-1);
    }
    public static int binarySearch(int []a,int k,int start,int end){
        int mid=(start+end)/2;
        if(a[mid]==k) return mid;
        return a[mid]>k ? binarySearch(a,k,start,mid-1):binarySearch(a,k,mid+1,end);
    }

    //selection problem
    public static int selectionProblem(int []a,int k){
        int c=0;
        for (int item:a) {
            if(item<k)
                c++;
        }
        return c;
    }

    // euclid greatest common divisor, decrease by variable
    public static  int gcd(int a,int b){

        return b==0 ? a : gcd(b,a%b);

    }

    // fibonacci series
    public static int fibBruteForce(int x){
        return x==0||x==1?x:fibBruteForce(x-1)+fibBruteForce(x-2);
    }
    public static int fibDynamicProgramming(int x){
        ArrayList<Integer> fib=new ArrayList<>();
        fib.add(0);
        fib.add(1);
        for (int i = 2; i <= x; i++) {
              fib.add(i,fib.get(i-1)+fib.get(i-2));
        }
    return fib.get(x);
    }



}
