package S0000_0099;


import entity.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class S0226_Invert_Tree {

    /**
     * 将root节点压到栈中，循环遍历整个栈，取出栈中的第一个元素，获取左、右叶子节点，将左变的叶子赋值给右边，右边的叶子赋值给左边以此做翻转，
     * 再将左、右叶子节点压入栈中，遍历所有叶子节点做反转。
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode head = root;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.right = left;
            node.left = right;
            if (node.left!=null){
                queue.push(node.left);
            }
            if (node.right!=null){
                queue.push(node.right);
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
