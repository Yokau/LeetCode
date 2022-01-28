package LeetCode.DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode point = queue.poll();
                level.add(point.val);
                if(point.left != null){
                    queue.offer(point.left);
                }
                if(point.right != null){
                    queue.offer(point.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
