package LeetCode.TreeAndGraph;

public class LC104 {
    public int maxDepth(TreeNode root) {
        return max(root, 0, 0);
    }
    public int max(TreeNode root, int depth, int max) {
        if (root == null) {
            return depth;
        }
        max = Math.max(max(root.left, depth + 1, max), max);
        max = Math.max(max(root.right, depth + 1, max), max);
        return max;
    }
}
