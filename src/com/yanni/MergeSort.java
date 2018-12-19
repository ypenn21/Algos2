package com.yanni;

/* Java program for Merge Sort */
class MergeSort
{
    // Merges two subarrays of arr[].
    // First subarray is arr[leftEnd..middle]
    // Second subarray is arr[middle+1..rightEnd]
    void merge(int arr[], int leftEnd, int middle, int rightEnd)
    {
        System.out.println("leftEnd : "+ leftEnd+" middle: "+middle+" rightEnd: "+rightEnd);
        // Find sizes of two subarrays to be merged
        int n1 = middle - leftEnd + 1;
        int n2 = rightEnd - middle;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[leftEnd + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[middle + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = leftEnd;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int leftEnd, int rightEnd)
    {
        if (leftEnd < rightEnd)
        {
            // Find the middle point
//            int middle = (leftEnd+rightEnd)/2;
            int middle = leftEnd + (rightEnd - leftEnd)/2;
 
            // Sort first and second halves
            sort(arr, leftEnd, middle);
//            if (leftEnd < middle)
                System.out.println("  leftEnd : "+ leftEnd+" middle: "+middle);
            sort(arr , middle+1, rightEnd);
//            if (middle+1 < rightEnd)
                System.out.println("  middle: "+middle+" rightEnd: "+rightEnd);
 
            // Merge the sorted halves
            merge2(arr, leftEnd, middle, rightEnd);
        }
    }
 
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // Driver method
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
 
        System.out.println("Given Array");
        printArray(arr);
 
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, 0, arr.length-1);
 
        System.out.println("\nSorted array");
        printArray(arr);
    }

    public void merge2(int arr[], int leftEnd, int middle, int rightEnd){

//        int left = middle - leftEnd+1;
//        int right = rightEnd - middle;
//
//        int [] arrayLeft = new int[left];
//        int [] arrayRight = new int[right];
//
//        for(int i =0; i<left;i++ ){
//            arrayLeft[i] = arr[leftEnd+i];
//        }
//
//        for(int j =0; j<right;j++ ){
//            arrayRight[j] = arr[rightEnd+j+1];
//        }

        int left = middle - leftEnd + 1;
        int right = rightEnd - middle;

        /* Create temp arrays */
        int arrayLeft[] = new int [left];
        int arrayRight[] = new int [right];

        /*Copy data to temp arrays*/
        for (int i=0; i<left; ++i)
            arrayLeft[i] = arr[leftEnd + i];
        for (int j=0; j<right; ++j)
            arrayRight[j] = arr[middle + 1+ j];

        int mergeInd = leftEnd;
        int counterLeft = 0;
        int counterRight = 0;

        while (counterLeft< left && counterRight < right){
            if(arr[counterLeft] < arrayRight[counterRight]) {
                arr[mergeInd] = arrayLeft[counterLeft];
                counterLeft++;
            } else {
                arr[mergeInd] = arrayRight[counterRight];
                counterRight++;
            }
            mergeInd++;
        }

        while (counterLeft<left) {
            arr[mergeInd] = arrayLeft[counterLeft];
            counterLeft++;
            mergeInd++;
        }

        while (counterRight<right) {
            arr[mergeInd] = arrayRight[counterRight];
            counterRight++;
            mergeInd++;
        }


    }
}