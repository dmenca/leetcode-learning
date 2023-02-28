package S0000_0099;

import entity.TreeNode;

import java.util.LinkedList;

/**
 * 合并二叉树
 *
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树
 */
public class S0617_Merge_Trees {
    /**
     * 广度优先遍历
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            node1.val = node1.val + node2.val;
            if (node1.left!=null && node2.left!=null){
                queue.add(node1.left);
                queue.add(node2.left);
            }
            if (node1.left == null && node2.left!=null){
                node1.left = node2.left;
            }

            if (node1.right!=null && node2.right!=null){
                queue.add(node1.right);
                queue.add(node2.right);
            }
            if (node1.right == null && node2.right!=null){
                node1.right = node2.right;
            }
        }
        return root1;
    }

    /**
     * DFS深度优先遍历合并两颗二叉树
     *
     * 如果两个二叉树的对应节点都为空，则合并后的二叉树对应节点也为空。
     * 如果两个二叉树的对应节点只有一个为空，则合并后的二叉树对应的节点的为其中的非空节点。
     * 如果两个二叉树的对应节点都不为空，则合并后的二叉树对应的节点为两个二叉树的对应节点的值的和，需要合并两个节点。
     * 对一个节点合并之后，还要对节点的左右子树分别进行合并，这是一个递归过程。
     */
    public TreeNode mergeTreesDFS(TreeNode root1, TreeNode root2) {
        if (root1 == null){
            return root2;
        }
        if ( root2 == null){
            return root1;
        }
        TreeNode t1 = new TreeNode(root1.val+root2.val);
        t1.left = mergeTreesDFS(root1.left,root2.left);
        t1.right = mergeTreesDFS(root1.right,root2.right);
        return t1;
    }

}
