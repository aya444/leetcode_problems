package hard.medianOfTwoSortedArrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {

    // To Concatenate the two given lists
    private int[] concatenate(int[] list1, int[] list2){
        return IntStream.concat(Arrays.stream(list1), Arrays.stream(list2)).toArray();
    }

    /*  merge sort = recursively divide array, then sort, then re-combine
        run-time complexity = O(n Log n)
        space complexity    = O(n)  */

    private void mergeSort(int[] array) {
        int lengthOfArray = array.length;

        // Base Case, return if array has 1 or fewer elements
        if (lengthOfArray <= 1) return;

        int mid = lengthOfArray / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[lengthOfArray - mid];

        // Copy elements into leftArray and rightArray
        int i = 0, j = 0;
        for (; i < lengthOfArray; i++) {
            if (i < mid) {
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }

        // Recursively sort both halves
        mergeSort(leftArray);
        mergeSort(rightArray);

        // Merge sorted halves back into original array
        merge(leftArray, rightArray, array);
    }

    private void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0, l = 0, r = 0; // indices for array, leftArray, and rightArray

        // Merge elements back into `array` in sorted order
        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }

        // Copy remaining elements from leftArray
        while (l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }

        // Copy remaining elements from rightArray
        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    // To Calculate the Median of the sorted array
    private double calculateMedian(int[] sortedArray){
        int midOfArray = sortedArray.length/2;
        if(sortedArray.length %2 == 0){
            return (sortedArray[midOfArray - 1] + sortedArray[midOfArray]) / 2.0;
        }else{
            return sortedArray[midOfArray];
        }
    }

    // Calling functions above to find the median
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] concatenatedList = concatenate(nums1, nums2);
        System.out.println("Concatenated List : ");
        for(int i = 0; i < concatenatedList.length; i++){
            System.out.print(concatenatedList[i]+ " ");
        }

        mergeSort(concatenatedList);
        System.out.println("\nSorted List : ");
        for(int i = 0; i < concatenatedList.length; i++){
            System.out.print(concatenatedList[i]+ " ");
        }

        return calculateMedian(concatenatedList);
    }
}
