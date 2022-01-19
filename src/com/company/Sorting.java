package com.company;

public abstract class Sorting {

    // median sort
    public static void medSort(int[] a) {
        medSort(a,0, a.length-1);

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
        int a=low-1;
        for(int i=low;i<high;i++){
            if(arr[i]<pivot){
                a++;
                int temp = arr[a];
                arr[a] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[a+1];
        arr[a+1] = pivot;
        arr[high] = temp;
        return a+1;
    }
    public static void quickSort(int[] arr, int low, int high){
        if(low<high){
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

}
