package examples.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoDimensionalArrays {
    public static void main(String[] args) {

        mergeArrays();
        practiceMaps();

    }

    /**
     * <h3>Recursive Staircase Problem</h3>
     * <p>There's a staircase with {@code N} steps, and you can climb 1 or 2 steps at a time. Given {@code N},
     * write a function that returns the number of unique ways you can climb the staircase.
     * The order of the steps matters.</p>
     *
     * <p>For example, if {@code N = 4}, there are 5 unique ways:</p>
     * <ol>
     *   <li>{@code 1, 1, 1, 1}</li>
     *   <li>{@code 1, 1, 2}</li>
     *   <li>{@code 1, 2, 1}</li>
     *   <li>{@code 2, 1, 1}</li>
     *   <li>{@code 2, 2}</li>
     * </ol>
     *
     * <p>What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set
     * of positive integers {@code X}? For example, if {@code X = {1, 3, 5}}, you could climb 1, 3, or 5 steps at a time.</p>
     *
     * <p><strong>Task:</strong> Generalize your function to take in {@code X}.</p>
     *
     * <pre>
     * {@code int numways(int N);}
     * </pre>
     * @param N is the number of steps
     * @return The number of paths
     */
    public static int numways(int N){

        // how many of these combinations will equal 4?
        // 1. check if any of the values in the array is greater than N
        // 2. Sort the steps
        // dynamic programming bottom up approach

        if(N == 0 || N == 1) {
            return 1;
        }

        int[] arr = new int[N+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2; i<arr.length; i++){
            // 2 = 2-1 + 2-2 = 1+0 // if 0 set to 1
            // 3 = 3-1 + 3-2 = 2+1
            // 4 = 4-1 + 4-2 = 3+2
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[N];

    }

    /**
     * Invariances
     * <pre>
     *  1. Cant take more than 2 steps
     *  2. You can only use the two paths above it
     *  3. numways(n) = num_ways(n-1) + num_ways(n-2)
     *     numways(3) = num_ways(2) + num_ways(1)
     *
     *  4. numways(n) = num_ways(n-1) + num_ways(n-2)
     *     numways(4) = num_ways(4-1) + num_ways(4-2)
     *     numways(4) = num_ways(3) + num_ways(2)
     * </pre>
     * */
    public static int numwaysBestSolution(int N, int[] steps){
        if(N < 0 || N == 0){
            return 1;
        }

        int[] arr = new int[N+1];
        arr[0] = 1;

        for(int i=1 ; i <= N; i++){
            for(int step : steps){
                if(i - step >= 0){ // 3 >= 3, 5>= 3, 3>=4, 5>=4
                    // i = 3, step = 3
                    // i = 3, step = 5
                    //arr[3] = arr[3-3]
                    //arr[3] = arr[5-3]
                    arr[i] += arr[i - step];
                }
            }


        }

        return arr[N];
    }

    /**
     * @link misc.leetcode : https://leetcode.com/problems/first-unique-character-in-a-string/
     * @link video : https://www.youtube.com/watch?v=0ougDTvVOFI
     * @param str
     * @return int
     */
    public static int firstUniqChar(String str) {
            /* *
             * possible fixes
             * char[] chars = s.toCharArray();
             *
             */
            int SIZE = str.length();
            int[] arr = new int[26];

            for(int i=0; i < str.length(); i++){
                arr[str.charAt(i) - 'a']++;

            }


            for (int i = 0; i < str.length(); i++) {
                if (arr[str.charAt(i) - 'a'] == 1) {
                    return i;
                }
            }

            return -1;
        }

    public static void sortString(){
        String str = "lebron";
    }

    /**
     * <h3>2570. Merge Two 2D Arrays by Summing Values</h3>
     * {@code https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/ }
     */
    public static void mergeArrays() {
        // [1] create 2d array
        int[][] nums1 = {
                {1,11},
                {2,22},
                {3,33},
        };
        int[][] nums2 = {
                {4,44},
                {5,55},
                {6,66},
        };
        int[][] nums3 = {
                {1,11},
                {2,11},
                {3,11},
                {4,11},
        };

        // [2] Iterate over a 2D array.
        System.out.println("rows");
        System.out.println("----");
        for(int[] row: nums1){
            // {1,11} #1 iteration
            // {2,22} #2 iteration
            // {3,22} #2 iteration

            // This is an array so, it will print out gibberish we have to convert it to a string
            // System.out.println(row[0] + " " + row[1]); //  # #
            System.out.println(Arrays.toString(row)); // [#, #]
        }
        for(int[] row: nums2){
            System.out.println(Arrays.toString(row)); // [#, #]
        }

        // [3] place 2d array in a map
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int[] rows : nums1){
            // rows[0], rows[1]
            // int[] rows  is the same as int[] arr = {8,88}; # 1st iteration
            // int[] rows  is the same as int[] arr = {9,99}; # 1st iteration
            // rows[0], rows[1] this is how to access each value
            mp.put(rows[0], rows[1]);
        }

        // [4] print mp entry

        System.out.println("\n\n\n\n");

        System.out.println("arr 1: " + Arrays.deepToString(nums1));
        System.out.println("arr 2: " + Arrays.deepToString(nums2));

        // [5] place 2d array in a map using mp.getOrDefault(searchByIndex and return value, return this value if index not found) method
        HashMap<Integer, Integer> mp2 = new HashMap<>();

        for(int[] rows : nums1){
            mp2.put(rows[0], rows[1]);
        }
        System.out.println("\narr1 combined with arr2");
        for(int[] rows : nums3){
            int num = mp.getOrDefault(rows[0], 0); // returning 0
            mp2.put(rows[0], rows[1] += num);
        }
        for(Map.Entry<Integer, Integer> entry : mp2.entrySet()){
            System.out.println(entry);
        }

        // convert map into array
        int size = mp2.entrySet().size();
        int[] arr = new int[size];
        int i = 0;
        System.out.println("\nsize: " + size);
        for(int value : mp2.values()){
            arr[i] = value;
            i++;
        }
        System.out.println("arr: " + Arrays.toString(arr));

        // print out a int[][]
        return;
    }

    public static void practiceMaps(){
        // 1. hashMap - create a hasmap object called mp
        // ex 1
        HashMap<Integer, Integer> mp = new HashMap<>(
                Map.of(8,88)
        );
        // ex 2
        Map<Integer, Integer> mp2 = Map.of(7,77);

        // 2. fill it will data
        mp.put(9,99);

        // 3. Transverse through this map
        // a. get key (integer)
        System.out.println("key");
        System.out.println("---");
        for(Integer key : mp.keySet()){
            System.out.println(key);
        }

        // b. get value (integer)
        System.out.println("value");
        System.out.println("---");
        for(Integer value: mp.values()){
            System.out.println(value);
        }

        // c. get set (ketSet)
        System.out.println("entry");
        System.out.println("---");
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            System.out.println(entry);
        }

        // 4. using the map.getOrDefault(entry[0], 0): method
        int num = mp.getOrDefault(8,0);
        num += 2;
        System.out.println("num: " + num);



        return;
    }


}