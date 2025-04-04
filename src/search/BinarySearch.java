package search;

import java.util.Arrays;

/**
 * Leetcode Problems
 *
 */
public class BinarySearch {

    public static void main(String[] args) {
        // System.out.println(binarySearch(new int[]{1,2,3,4}, 4)); // 3
        // System.out.println(binarySearch(new int[]{-1,0,3,5,9,12}, 9)); // 4
//        binarySearchUsingArrays(new int[]{-1,0,3,5,9,12}, 3); // 2
        binarySearchUsingArrays(new int[]{-6,-1,3,5,9,12}, 7); // -1
    }

/**
 * 704. Binary Search
 * <p>You must write an algorithm with O(log n) runtime complexity.</p>
 * <p>https://leetcode.com/problems/binary-search/description/</p>
 */
    public static int binarySearch(int[] nums, int target){
        System.out.println("-- binarySearch(int[] nums, int target) --");
        // [-2,1,3,4,5] target = 4
        // if
        int index = -1;

        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            // int mid = 0 + ( 5 - 0 )  / 2 = 2
            // int mid = 1 + ( 5 - 1 )  / 2 = 3
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left++;
            }else{
                right--;
            }
        }

        return index;

    }

    // sort cuts
    public static void binarySearchUsingArrays(int[] nums, int target){
        System.out.println("-- binarySearchUsingArrays(int[] nums, int target) --");
        if(Arrays.binarySearch(nums, target) < 0){
            System.out.println(-1); // there is no index less than 0
        }
        System.out.println(Arrays.binarySearch(nums, target));
    }


}