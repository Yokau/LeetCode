package LeetCode.TreeAndGraph;

import java.util.ArrayList;
import java.util.List;

public class LC589 {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root,res);
        return res;
    }
    public void preOrder(Node root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        for(Node child: root.children){
            preOrder(child,res);
        }
    }
}
