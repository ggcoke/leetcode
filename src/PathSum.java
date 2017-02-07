/**
 * Desc here
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, sum, 0);
    }

    public boolean hasPathSum(TreeNode node, int sum, int current) {
        if (node == null) {
            return sum == current;
        }

        int newTotal = current + node.val;

        if (node.left == null && node.right == null) {
            return sum == newTotal;
        }

        if (node.left != null && hasPathSum(node.left, sum, newTotal)) {
            return true;
        }

        if (node.right != null && hasPathSum(node.right, sum, newTotal)) {
            return true;
        }

        return false;
    }
}
