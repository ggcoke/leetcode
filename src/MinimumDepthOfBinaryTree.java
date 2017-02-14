/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class MinimumDepthOfBinaryTree {
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = 0, right = 0;
        left = minDepth(root.left);
        right = minDepth(root.right);

        return (left == 0 || right == 0) ? (left + right + 1) : (Math.min(left, right) + 1);
    }
}
