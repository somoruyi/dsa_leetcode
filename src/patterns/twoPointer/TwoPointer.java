package patterns.twoPointer;

import java.util.Arrays;

/**
 * <h3>Two Pointer Technique</h3>
 * Referencing two indexes at a time and iterating
 * <h4>A. Two Common Patterns</h4>
 * <pre>
 *     1. Two pointers that start at the beginning and end
 *        - ( ex. {@code i = 0, j = arr.length-1} )
 *     2. One pointer moving slower then the other at 2x the speed
 * </pre>
 * <h4>B. Rules</h4>
 * <pre>
 *     1. Assume arr[] is sorted
 * </pre>
 * <h4>C. Problem Types</h4>
 * <pre>
 *     1. Sum of Two Values in an Array
 *     2. 997. Squares of a sorted array.
 * </pre>
 *

 * <h3>Two Pointer</h3>
 * <pre>
 * Concept: Uses two pointers that traverse a data structure (like an array) from
 * different directions or positions to find a solution efficiently.
 *
 * Common Problems:
 * - Finding a pair with a given sum (`Two Sum` in sorted arrays)
 * - Merging two sorted arrays (`Merge Sort`)
 * - Removing duplicates in a sorted array
 * - Finding subarrays that meet a condition (`Sliding Window` variation)
 *
 * Example :
 * - Find two numbers in a sorted array that sum to a target.
 * </pre>
 */
public class TwoPointer {

    public static void main(String[] args) {
        System.out.println("-- Two Pointer --");

        // 1. Sum of Two Integers
        int[] arr = {1, 2, 5, 6};
        int target = 3;

        // int[] result = sumOfTwoIntegers(target, arr);
        // System.out.println("Target: " + target);
        // System.out.println("Index: " + Arrays.toString(result));

        // 2. Merge Two arrs
        int[] arr1 = {1, 3, 5, 7, 19};
        int[] arr2 = {2, 4, 6, 21};
        System.out.println("\nMerged Array: " + Arrays.toString(mergeTwoArrays(arr1, arr2)));

        // 3. Eliminate Duplicates in Array
        int[] arr3 = new int[]{ 2, 7, 4, 4, 6, 7, 7};
        System.out.println("\n" +
                "Original Array: " + Arrays.toString(arr3) + "\n" +
                "Removed Indexes: " + Arrays.toString(removeDuplicatesFromArray(arr3))
        );


    }
    public static int[] sumOfTwoIntegers(int target, int[] arr) {

        int left = 0;
        int right = arr.length-1;

        while(left < right){

            int sum = arr[left] + arr[right];
            if(sum == target){
                return new int[]{left, right};
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
            System.out.println("\nsum: " + sum);
        }

        return new int[]{};
    }

    public static int[] mergeTwoArrays(int[] arr1, int[] arr2) {

        // { 1, 3, 5 };
        // { 2, 4, 6, 7 };

        int[] arr = new int[arr1.length + arr2.length];
        int n = arr.length;
        int left = 0;
        int right = 0;
        int i=0;
        while(right < arr2.length && left < arr1.length){

            if(arr1[left] < arr2[right]){
                System.out.print(arr1[left]+ " ");

                arr[i] = arr1[left];
                left++;

            }else {
                System.out.print(arr2[right]+ " ");

                arr[i] = arr2[right];
                right++;

            }
            i++;
        }
        // left++
        // right++
        // i++
        while(left < arr1.length){
            arr[i] = arr1[left];
            i++;
            left++;
        }
        while(right < arr2.length){
            arr[i] = arr2[right];
            i++;
            right++;
        }

        return arr;
    }


    public static int[] removeDuplicatesFromArray(int[] arr) {

        // { 2, 7, 4, 6, 7 };
        Arrays.sort(arr);
        int i = 0;
        for(int j=1; j<arr.length; j++){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }

        }
        int[] result = new int[i+1];

        for(int k = 0; k < result.length; k++){
            result[k] = arr[k];
        }

        return result;
    }
}
