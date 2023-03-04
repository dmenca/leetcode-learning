package S0000_0099;
import entity.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root,检查它是否轴对称。
 */
public class S0101_IsSymmetric {
    /**
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null){
                continue;
            }
            if ((left!=null&&right==null)||
                    (left==null && right!=null)||
                    (left.val != right.val)){
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public boolean isSymmetric1(TreeNode root) {
        if(root==null) {
            return true;
        }
        //调用递归函数，比较左节点，右节点
        return dfs(root.left,root.right);
    }

    boolean dfs(TreeNode left, TreeNode right) {
        //递归的终止条件是两个节点都为空
        //或者两个节点中有一个为空
        //或者两个节点的值不相等
        if(left==null && right==null) {
            return true;
        }
        if(left==null || right==null) {
            return false;
        }
        if(left.val!=right.val) {
            return false;
        }
        //再递归的比较 左节点的左孩子 和 右节点的右孩子
        //以及比较  左节点的右孩子 和 右节点的左孩子
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode l1 = new TreeNode();
        l1.val = 2;
        l1.left = null;
        l1.right = new TreeNode(3);

        TreeNode r1 = new TreeNode();
        r1.val = 2;
        r1.left = null;
        r1.right = new TreeNode(3);
        root.left=l1;
        root.right=r1;
        System.out.println(isSymmetric(root));
    }
}
