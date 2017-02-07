import java.util.ArrayList;
import java.util.List;

/**
 * Desc here
 *
 * @author Wang Huisong(wanghuisong@le.com)
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }

        return pathSum(root, sum, 0, null);
    }

    public List<List<Integer>> pathSum(TreeNode node, int sum, int current, List<Integer> parent) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (parent == null) {
            parent = new ArrayList<Integer>();
        }

        int newTotal = current + node.val;
        parent.add(node.val);

        System.out.println(parent);

        if (node.left == null && node.right == null) {
            if (sum == newTotal) {
                result.add(parent);
                return result;
            }
        }

        if (node.left != null) {
            List<Integer> leftParent = new ArrayList<Integer>();
            leftParent.addAll(parent);
            List<List<Integer>> leftResult = pathSum(node.left, sum, newTotal, leftParent);
            if (leftResult != null && leftResult.size() > 0) {
                result.addAll(leftResult);
            }
        }

        if (node.right != null) {
            List<Integer> rightParent = new ArrayList<Integer>();
            rightParent.addAll(parent);
            List<List<Integer>> rightResult = pathSum(node.right, sum, newTotal, rightParent);
            if (rightResult != null && rightResult.size() > 0) {
                result.addAll(rightResult);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PathSumII sum = new PathSumII();

        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(5);
        TreeNode left2 = new TreeNode(3);

        root.left = left1;
        root.right = right1;
        left1.left = left2;

        int total = 6;

        List<List<Integer>> result = sum.pathSum(root, total);

        System.out.println("Result is " + result);
    }
}
