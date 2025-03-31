package examples.leetcode;

public class Recursion {

    public static void main(String[] args) {
        // 1. Recursive Staircase Problem
        System.out.println(numways3(5, new int[]{1,3,5})); // 5
    }

    public static int numways(int N, int[] steps) {

        if (N == 0) {
            return 1;
        }

        int[] arr = new int[N + 1];
        arr[0] = 1; // why are we setting this to 1

        for (int i = 1; i < arr.length; i++) {
            for (int step : steps) {
                arr[i] += arr[i - step];
            }

        }

        return arr[N];
    }

    /**
     * <pre>
     * steps     paths
     * -----     -----
     * N = 9     arr[9] = 55
     * N = 8     arr[8] = 34
     * N = 7     arr[7] = 21
     * N = 6     arr[6] = 13
     * N = 5     arr[5] = 8
     * N = 4     arr[4] = 5
     * N = 3     arr[3] = 3
     * N = 2     arr[2] = 2
     * N = 1     arr[1] = 1
     * N = 0     arr[0] = 1
     * </pre>
     * <h3>4 steps</h3>
     * <pre>
     * [0,1,2,3,4]   1 path
     * [0,1,2,4]     2 paths
     * [0,1,3,4]     3 paths
     * [0,1,4]       4 paths
     * [0,4]         5 paths
     * </pre>
     */
    public static int numways2(int N) { // 4


        int len = N + 1;
        int[] arr = new int[len]; // N=4 is will have 5 spaces in the array
        // [0, 0, 0, 0, 0]
        // [0,1,2,3,4] 1 path  [NEEDS 5 SPACES]
        // [0,1,2,4] 2 paths
        // [0,1,3,4] 3 paths
        // [0,1,4] 4 paths
        // [0,4] 5 paths

        if (N == 0 || N == 1) {
            System.out.println("N = " + N + "\tarr[" + N + "] = " + 1);
            System.out.println("N = " + --N + "\tarr[" + N + "] = " + 1);
        } else {
            /*[ N  PATHS
            0    0  = 1
            1    1  = 1
            2    2  = 2
            3    3  = 3
            4    5  = 5 ]*/
            arr[0] = 1;
            arr[1] = 1;
            for (int i = 2; i < len; i++) {
                arr[i] = arr[i - 2] + arr[i - 1];
                // arr[2] = arr[2-2] + arr[2-1];
                // arr[3] = arr[3-2] + arr[3-1];
                // arr[4] = arr[4-2] + arr[4-1];

                // arr[2] = arr[0] + arr[1];
                // arr[3] = arr[1] + arr[2];
                // arr[4] = arr[2] + arr[3];

                // 2 = 1 + 1
                // 3 = 1 + 2;
                // 5 = 2 + 3
            }

            // want to test N =  4, 3, 2, 1

            if (N > -1) {
                System.out.println("N = " + N + "\tarr[" + N + "] = " + arr[N]);
                N--;
                return numways2(N); // recursion
            }

        }

        return 1;

    }

    public static int numways3(int N, int[] steps) {

        int len = N + 1;
        int[] arr = new int[len];
        arr[0] = 1;

        for (int i = 1; i < len; i++) {
            for (int step : steps) {
                if (i - step >= 0) {
                    arr[i] += arr[i - step];
                }
            }
        }

        return -1;
    }

}
