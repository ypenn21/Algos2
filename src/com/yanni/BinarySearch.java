package com.yanni;

// Java implementation of recursive Binary Search
class BinarySearch
{
    // Returns index of x if it is present in arr[l..
    // r], else return -1
    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r>=l)
        {
//            int mid = l + (r - l)/2;
            int mid = (l+r)/2;
 
            // If the element is present at the 
            // middle itself
            if (arr[mid] == x)
               return mid;
 
            // If element is smaller than mid, then 
            // it can only be present in left subarray
            if (arr[mid] > x)
               return binarySearch(arr, l, mid-1, x);
 
            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid+1, r, x);
        }
 
        // We reach here when element is not present
        //  in array
        return -1;
    }

    static void insertionSort(int arr[]) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int prev = i-1;
            while(prev >=0 && prev < arr.length && arr[prev] > key ){
                arr[prev+1] =arr[prev];

                prev--;
            }
            prev++;
            arr[prev] = key;
        }
    }

    // Driver method to test above
    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int arr[] = {2,3,4, 20,10,40};
        int n = arr.length;
        int x = 0;
        insertionSort2(arr);
        int arr2[] = {40, 4,1,5,8,40};
        insertionSort(arr2);
        int result = ob.binarySearch(arr,0,n-1,x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + 
                                                 result);
    }

    static void insertionSort2(int arr[]) {

        for (int i = 1; i < arr.length; i++) {
            int previous = i-1;
            int current = arr[i];
            int currentInd = i;
            while(current<arr[previous] ){
                arr[currentInd]=arr[previous];
                currentInd--;
                previous--;
            }
            previous++;
            arr[previous] = current;
        }
    }
}