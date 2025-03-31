package inDegreeOutDegree;

import java.util.List;

/**
 * <h2>Graphs</h2>
 * Pattern / Strategy / Technique
 * <h3>in-degree and out-degree</h3>
 * In graph theory to describe the number of edges connected to a node (vertex) in a directed
 * <code>
 *     <pre>

 *     {@code In-Degree}   : The number of edges directed toward a node.
 *                  Essentially, it counts how many other nodes point to this node
 *     {@code Out-Degree}  : The number of edges directed away from a node.
 *                  It counts how many other nodes this node points to.
 *     </pre>
 * </code>
 */
public class InDegreeOutDegree {

    public static void main(String[] args) {
        int[][] arr = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        int[][] arr1 = new int[][]{
                {1,2},
                {2,4}
        };
        System.out.println(findJudge(4, arr));
        System.out.println(findJudge(4, arr1));
    }
    /**
     *  <h3>997. Find the Town Judge </h3>
     *  https://leetcode.com/problems/find-the-town-judge/description/
     *  <h4>Videos</h4>
     *  <p>
     *      The technique used in this implementation is  {@code count-based analysis} for solving graph problems.
     *  </p>
     *  <p>
     *      Specifically, this algorithm leverages the concept of {@code in-degree and out-degree} to identify a
     *      "judge" in a directed graph, where the relationships (trust) represent edges.
     *  </p>
     *  <p></p>
     *  <code>
     *      <pre>
     *          1. In a town, there are {@code n} people labeled from {@code 1} to {@code n}.
     *          2. There is a rumor that {@code 1} is secretly the town judge.
     *
     *          3. If the town judge exists, then:
     *              a. The town judge trusts nobody.
     *              b. Everybody (except for the town judge) trusts the town judge.
     *              c. There is exactly one person that satisfies {@code 1} and {@code 2}.
     *
     *          4. You are given an array trust where representing:
     *               {@code int[][] trust[i] = [ai, bi]}
     *
     *          5. The person labeled  {@code [ai]} trusts the person labeled  {@code [bi]}.
     *          6. If a trust relationship does not exist in trust array,
     *             then such a trust relationship does not exist.
     *
     *          7. Return :
     *              1. Label {@code [bi]} of the town judge if the town judge exists & can
     *                 be identified
     *              2. Or return {@code -1} otherwise.
     *      </pre>
     *  </code>
     *  <code>
     *      <pre>
     *          Example 1:
     *              Input: n = 2, trust = [[1,2]]
     *              Output: 2
     *
     *          Example 2:
     *              Input: n = 3, trust = [[1,3],[2,3]]
     *              Output: 3
     *
     *          Example 3:
     *              Input: n = 3, trust = [[1,3],[2,3],[3,1]]
     *              Output: -1
     *      </pre>
     *  </code>
     */
    public static int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1; // Edge case: If there's only one person, they are the judge.

        int[] trustScores = new int[n + 1]; // To track in-degree and out-degree.

        // Step 1: Process the trust relationships
        for (int[] relation : trust) {
            trustScores[relation[0]]--; // This person trusts someone (out-degree).
            trustScores[relation[1]]++; // This person is trusted (in-degree).
        }

        // Step 2: Find the judge
        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }

        return -1; // No judge found
    }
    public static int findJudgeMySolution(int n, int[][] trust) {

        if(trust.length < 1 && n < 2){
            return n;
        }

        int[] arr = new int[n+1];

        for(int[] row : trust){
            // [1,3]
            arr[row[0]]--; // [0,-1,-1,0]
            arr[row[1]]++; // [0,0,0,2]
        }

        //System.out.println("arr: " + Arrays.toString(arr));

        // n-1 = 2
        // -1
        int i = 0;
        for(int value : arr){
            // [0,-1,-1,2]
            if(value == n-1){
                // System.out.println("arr[i] = value");
                // System.out.println("arr[i] : " + arr[i]);
                // System.out.println("value  : " + value);
                // System.out.println("i: " + i);
                return i;
            }
            i++;
        }
        return -1;

    }

}
