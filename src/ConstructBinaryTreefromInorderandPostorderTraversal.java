import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Desc here
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(map, inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public static TreeNode buildTree(Map<Integer, Integer> map, int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int index = map.get(root.val);
        int leftLength = index - inStart;

        root.left = buildTree(map, inorder, postorder, inStart, index - 1, postStart, postStart + leftLength - 1);
        root.right = buildTree(map, inorder, postorder, index + 1, inEnd, postStart + leftLength, postEnd - 1);

        return root;
    }

    public static final void main(String[] args) {
        int[] inorder = {2,4,1,5,3};
        int[] postorder = {4,2,5,3,1};
        TreeNode root = buildTree(inorder, postorder);

        List<Integer> result = BinaryTreeInorderTraversal.inorderTraversalRecursive(root);

        if (result != null) {
            System.out.println(result);
        }
    }
}
