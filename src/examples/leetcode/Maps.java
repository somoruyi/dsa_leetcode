package examples.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Maps {
    public static void main(String[] args) {
        System.out.println("-- maps --");
        // hashMap();
        mergeArrayIntoHashMap();
    }

    /**
     * Be able to know what this child class does via memory
     * <pre>
     *     1. hashMap is immmutable
     * </pre>
     */
    public static void hashMap(){
        // default data
        Map<Integer, String> mp = new HashMap<>(
                Map.of(1, "lebron")
        );
        mp.put(2,"kyrie");

        for(Map.Entry<Integer, String> m : mp.entrySet()){
            System.out.println(m);
        }
        mp.put(1,"durant");
        for(Map.Entry<Integer, String> m : mp.entrySet()){
            System.out.println(m);
        }
    }
    public static void mergeArrayIntoHashMap(){
        // default data
        int[][] arr1 = new int[][]{
                {1, 11},
                {2, 11},
                {3, 11},
                {7, 2}
        };
        int[][] arr2 = new int[][]{
                {1, 0},
                {2, 11},
                {3, 22},
                {4, 44}
        };

        Map<Integer, Integer> mp = new HashMap<>();
        for(int[] arr : arr1){
            mp.put(arr[0], arr[1]);
        }
        for(int[] arr : arr2){
            int value = mp.getOrDefault(arr[0], 0);
            mp.put(arr[0], arr[1]+value);
        }
        int[] newArray = new int[mp.size()];
        int i = 0;
        for(Map.Entry<Integer, Integer> m : mp.entrySet()){
            newArray[i] = m.getValue();
            i++;
        }
        Arrays.sort(newArray);
        for(int arr : newArray){
            System.out.print(arr + " ");
        }
    }
}
