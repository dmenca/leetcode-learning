package S0000_0099;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S0094_InorderTraversal {

    /**
     * 递归实现中序遍历
     * 访问左子树->根节点->右子树的方式遍历这棵树，而在访问左子树或者右子树的时候我们按照同样的方式遍历，
     * 直到遍历完整棵树。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> allInts = new ArrayList<>();
        allInts.addAll(inorderTraversal(root.left));
        int val = root.val;
        allInts.add(val);
        allInts.addAll(inorderTraversal(root.right));
        return allInts;
    }

    /**
     * 迭代的方式来实现
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode>stack = new Stack<>();
        while (root!=null&&!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            results.add(root.val);
            root = root.right;
        }
        return results; 
    }
}
