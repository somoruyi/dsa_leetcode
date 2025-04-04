package patterns.prefixSum;

import java.util.HashMap;
import java.util.Map;


public class SubArraySumEqualsK {


    /**
     * 560. Subarray Sum Equals K
     */
    public static int subarraySum(int[] nums, int k) {
        int count = 0; // Total subarrays with sum == k
        int prefixSum = 0; // Cumulative sum
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize with 0 sum to handle subarrays starting from index 0

        for (int num : nums) {
            prefixSum += num; // Update prefix sum
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k); // Add the count of subarrays that sum to k
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1); // Update map with current patterns.prefixSum
        }

        return count;
    }

    public static void subArraySumEqualsK(){

    }

}
