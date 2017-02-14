import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<TreeNode>();

        queue.push(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int parentCount = queue.size();

            for (int i = 0; i < parentCount; i++) {
                TreeNode node = queue.pollLast();
                level.add(node.val);

                if (node.left != null) {
                    queue.push(node.left);
                }

                if (node.right != null) {
                    queue.push(node.right);
                }
            }

            result.add(level);
        }

        return result;
    }
}
