import java.util.ArrayList;
import java.util.List;

/**
 * Desc here
 *
 * @author Wang Huisong(wanghuisong@le.com)
 */
public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return calSum(root, 0);
    }

    public int calSum(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        int currentSum = sum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return currentSum;
        }

        return calSum(node.left, currentSum) + calSum(node.right, currentSum);
    }
}
