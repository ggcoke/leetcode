import java.util.ArrayList;
import java.util.List;

/**
 * Desc here
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class BinaryTreeInorderTraversal {

    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        inorderTraversal(root, result);
        return result;
    }

    public static void inorderTraversal(TreeNode parent, List<Integer> result) {
        if (parent == null) {
            return;
        }

        if (parent.left == null && parent.right == null) {
            result.add(parent.val);
            return;
        }

        inorderTraversal(parent.left, result);
        result.add(parent.val);
        inorderTraversal(parent.right, result);
    }


    public static List<Integer> inorderTraversalIteratively(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        List<TreeNode> stack = new ArrayList<TreeNode>();
        TreeNode tmp = root;
        while (tmp != null || stack.size() > 0) {
            while (tmp != null) {
                stack.add(tmp);
                tmp = tmp.left;
            }

            if (stack.size() > 0) {
                TreeNode t = stack.remove(stack.size() - 1);
                result.add(t.val);
                tmp = t.right;
            }
        }

        return result;
    }
}
