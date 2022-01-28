package LeetCode.TreeAndGraph;

public class LC111 {
    int minDep = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        min_recursive(root, 1);
        return minDep;
    }

    public void min_recursive(TreeNode root, int dep) {
        if (root.left == null && root.right == null) {
            minDep = Math.min(minDep, dep);
            return;
        }
        if (root.left != null)
            min_recursive(root.left, dep + 1);
        if (root.right != null)
            min_recursive(root.right, dep + 1);
    }
}
