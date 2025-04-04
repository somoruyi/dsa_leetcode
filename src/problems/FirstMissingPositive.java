package problems;

/**
 * <h3>15. Hashing-Based Techniques</h3>
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(firstMissingPositive(new int[]{222222222}));
    }


    /**
     *  <h4>Leetccode 41. First Missing Positive</h4>
     *  <p>https://leetcode.com/problems/first-missing-positive/description/</p>
     *  <p>Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.</p>
     *
     * <p>You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.</p>
     */

    public static int firstMissingPositive(int[] nums) {
        int[] A = nums;
        int n = A.length;
        boolean[] seen = new boolean[n + 1]; // initialize boolean array

        for (int i = 0; i < n; i++) {
            if (A[i] > 0 && A[i] <= n) { // only mark values that are within [1, n]
                seen[A[i]] = true; // mark the value as seen
            }
        }

        for (int i = 1; i <= n; i++) { // find the first missing positive value
            if (!seen[i]) {
                return i;
            }
        }

        return n + 1; // if all positive values are seen, the answer is n+1
    }

    public static int firstMissingPositive2(int[] nums) {

        int len = nums.length;
        int size = len + 1;

        boolean[] arr = new boolean[size];
        int value = -1;

        for(int i=0; i<len; i++){
            value = nums[i];
            if(value > 0 && value < size){ // this is the important inro
                arr[value] = true;
            }
        }

        for(int i=1; i<size; i++){
            if(arr[i] == false){
                return i;
            }
        }
        return size;
    }
}
