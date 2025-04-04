package sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        bubbleSortUsingArrays(new int[]{-1,0,3,50,9,-3});
    }
    public static void bubbleSortUsingArrays(int[] nums){
        System.out.println("-- bubbleSortUsingArrays(int[] nums) --");
        Arrays.sort(nums); // mutabale so will chnagee the nums array value
        System.out.println(Arrays.toString(nums));
    }
}


