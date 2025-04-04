package patterns.inDegreeOutDegree;

import static patterns.inDegreeOutDegree.FindJudge.*;

/**
 * <h2>Graphs</h2>
 * Pattern / Strategy / Technique
 * <h3>in-degree and out-degree</h3>
 * In graph theory to describe the number of edges connected to a misc.node (vertex) in a directed
 * <code>
 *     <pre>

 *     {@code In-Degree}   : The number of edges directed toward a misc.node.
 *                  Essentially, it counts how many other nodes point to this
 *                  misc.node
 *     {@code Out-Degree}  : The number of edges directed away from a misc.node.
 *                  It counts how many other nodes this misc.node points to.
 *     </pre>
 * </code>
 */

public class Driver {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        int[][] arr1 = new int[][]{
                {1,2},
                {2,4}
        };
        System.out.println(findJudge(4, arr));
        System.out.println(findJudge(4, arr1));
    }
}
