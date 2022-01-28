package LeetCode.DFS_BFS;

import java.util.*;

/*329. Longest Increasing Path in a Matrix
 * DFS
 * */

public class LC329 {

    public static void main(String[] args) {
//        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
//        int[][] matrix = {{1, 2}};
        int[][] matrix = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        System.out.println(longestIncreasingPath(matrix));
    }

    static int m, n;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //上，下，左，右

    public static int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        if (m == 0) return 0;
        n = matrix[0].length;
        int[][] memo = new int[m][n];
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, memo, i, j));
            }
        }
        return maxLen;
    }

    public static int dfs(int[][] matrix, int[][] memo, int x, int y) {
        if (memo[x][y] != 0) {
            return memo[x][y];
        }
        ++memo[x][y];
        for (int[] dir : dirs) {
            int a = x + dir[0], b = y + dir[1];
            if (a >= 0 && a < m && b >= 0 && b < n && matrix[x][y] < matrix[a][b]) {
                memo[x][y] = Math.max(memo[x][y], dfs(matrix, memo, a, b) + 1);
            }
        }
        return memo[x][y];
    }
}
