/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class PopulatingNextRightPointersInEachNode {
    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        root.next = null;
        if (root.left == null) {
            return;
        }

        TreeLinkNode current = root;
        TreeLinkNode first = null;

        while (current != null) {
            if (first == null) {
                first = current.left;
            }

            if (current.left != null) {
                current.left.next = current.right;
            } else {
                break;
            }

            if (current.next != null) {
                current.right.next = current.next.left;
                current = current.next;
            } else {
                current = first;
                first = null;
            }
        }
    }
}
