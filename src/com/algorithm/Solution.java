package com.algorithm;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;

// We basically implement MergeSort and
//  1) Add "swaps" counter and 1 line of code to count swaps when merging
//  2) Use "long" instead of "int" to avoid integer overflow

//  Time Complexity: O(n log n)
// Space Complexity: O(n)
public class Solution {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\sunil.gc\\IdeaProjects\\AlgorithmCoding\\src\\com\\algorithm\\IntegerArray.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        LinkedList<Integer> l =new LinkedList<Integer>();
        while ((st = br.readLine()) != null) {
            l.add(Integer.parseInt(st));
        }
        Object [] objectArray = l.toArray();

        Integer[] arr = new Integer[objectArray.length];

        // copy elements from object array to integer array
        for (int i = 0; i < objectArray.length; i++)
            arr[i] = (Integer)objectArray[i];

        MergeSort ms = new MergeSort();
        System.out.println(ms.mergeSort(arr));

    }

    private static class MergeSort {
        /* Our array has up to n = 100,000 elements. That means there may be O(n^2) swaps.
           n^2 is 10,000,000,000. A Java int has max value 2,147,483,647 so we use a long
           to avoid integer overflow */
        private long swaps = 0;

        public long mergeSort(Integer [] array) {
            Integer [] helper = new Integer[array.length];
            mergeSort(array, helper, 0, array.length - 1);
            return swaps;
        }

        private void mergeSort(Integer [] array, Integer [] helper, int start, int end) {
            if (start < end) {
                int mid = (start + end) / 2;
                mergeSort(array, helper, start, mid);
                mergeSort(array, helper, mid + 1, end);
                merge(array, helper, start, mid, end);
            }
        }

        private void merge(Integer [] array, Integer [] helper, int start, int mid, int end) {
            /* Fill helper array with same elements as original array */
            for (int i = start; i <= end; i++) { // notice "i" goes from "start" to "end", not "0" to "array.length"
                helper[i] = array[i];
            }

            int curr  = start;
            int left  = start;
            int right = mid + 1;

            /* Loop through helper[] left and right halves and continuously copy smaller element to array[] */
            while (left <= mid && right <= end) {
                if (helper[left] <= helper[right]) {
                    array[curr++] = helper[left++];
                } else {
                    /* Each time we choose element from right side, we count up how many elements
                       it is less than from left side. This is equivalent to counting swaps. */
                    swaps += mid + 1 - left;
                    array[curr++] = helper[right++];
                }
            }

            /* Copy remaining elements of left half. Right half elements are already in proper place */
            while (left <= mid) {
                array[curr++] = helper[left++];
            }
        }
    }
}