package LeetCode.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

/*22. Generate Parentheses
 * DFS
 * */
public class LC22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        StringBuilder str = new StringBuilder();
        dfs(n, n, str, res);
        return res;
    }

    public void dfs(int left, int right, StringBuilder str, List<String> res) {
        if (left <= 0 && right <= 0) {
            res.add(str.toString());
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            str.append('(');
            dfs(left - 1, right, str, res);
            str.deleteCharAt(str.length() - 1);
        }
        if (right > 0) {
            str.append(')');
            dfs(left, right - 1, str, res);
            str.deleteCharAt(str.length() - 1);
        }

    }
}
