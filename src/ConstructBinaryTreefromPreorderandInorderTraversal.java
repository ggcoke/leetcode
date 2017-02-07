import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Desc here
 *
 * @author Wang Huisong(wanghuisong@le.com)
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(map, preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

    }

    public static TreeNode buildTree(Map<Integer, Integer> map, int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        System.out.println("prestart = " + preStart + ", preend = " + preEnd + ", instart = " + inStart + ", inend is " + inEnd);
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int index = map.get(root.val);
//        int index = inStart;
//        while (index < inEnd && inorder[index] != root.val) {
//            index++;
//        }

        int leftLength = index - inStart;
        root.left = buildTree(map, preorder, inorder, preStart + 1, preStart + leftLength, inStart, index - 1);
        root.right = buildTree(map, preorder, inorder, preStart + leftLength + 1, preEnd, index + 1, inEnd);

        return root;
    }

    public static final void main(String[] args) {
        int[] preorder = {6, 10, 4, 3, 1, 0, 7, 12};
        int[] inorder = {4, 10, 3, 1, 6, 12, 7, 0};
        TreeNode root = buildTree(preorder, inorder);

        List<Integer> result = BinaryTreeInorderTraversal.inorderTraversalRecursive(root);

        if (result != null) {
            System.out.println(result);
        }
    }

}
