package LeetCode.DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC51_2 {
    public static void main(String[] args) {
        LC51_2 a = new LC51_2();
        System.out.println(a.solveNQueens(4).toString());
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) return res;

        int[] colOfQueen = new int[n];

        List<StringBuffer> curPos = new ArrayList<>();
        StringBuffer fill = new StringBuffer();
        for (int i = 0; i < n; i++) {
            fill.append('.');
        }
        for (int i = 0; i < n; i++) {
            curPos.add(fill);
        }
        // Make a copy of the checkerboard, Simulate the process of calculate
        dfs(res, n, 0, colOfQueen, curPos);
        return res;
    }

    public void dfs(List<List<String>> res, int n, int index, int[] colOfQueen, List<StringBuffer> curPos) {
        if (index == n) {
            List<String> strs = new ArrayList<>();
            for (StringBuffer str : curPos) {
                strs.add(str.toString());
            }
            res.add(strs);
        }
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < index; j++) {
                //Judge whether the place other had occupied
                if (colOfQueen[j] == i || Math.abs(j - index) == Math.abs(i - colOfQueen[j]))
                    break;
            }
            if (j == index) {
                colOfQueen[index] = i;
                StringBuffer a = new StringBuffer(curPos.get(index));
                a.setCharAt(i, 'Q');
                curPos.set(index, a);
                dfs(res, n, index + 1, colOfQueen, curPos);
                a.setCharAt(i, '.');
                curPos.set(index, a);
            }
        }
    }
}
