import java.util.ArrayList;
import java.util.List;

/**
 * Desc here
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class BinaryTreePaths {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }

        binaryTreePaths(root, "", result);
        return result;
    }

    public void binaryTreePaths(TreeNode node, String parent, List<String> result) {
        parent += String.valueOf(node.val);

        if (node.left == null && node.right == null) {
            result.add(parent);
            return;
        }

        if (node.left != null) {
            binaryTreePaths(node.left, (parent + "->"), result);
        }

        if (node.right != null) {
            binaryTreePaths(node.right, (parent + "->"), result);
        }
    }
}
