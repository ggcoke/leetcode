/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class PopulatingNextRightPointersInEachNodeII {
    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode nextLevelFirst = null;
        TreeLinkNode nextLevelPrev = null;
        TreeLinkNode current = root;

        while (current != null) {
            while (current != null) {
                if (current.left != null) {
                    if (nextLevelPrev == null) {
                        nextLevelFirst = current.left;
                    } else {
                        nextLevelPrev.next = current.left;
                    }

                    nextLevelPrev = current.left;
                }

                if (current.right != null) {
                    if (nextLevelPrev == null) {
                        nextLevelFirst = current.right;
                    } else {
                        nextLevelPrev.next = current.right;
                    }

                    nextLevelPrev = current.right;
                }

                current = current.next;
            }

            current = nextLevelFirst;
            nextLevelFirst = null;
            nextLevelPrev = null;
        }
    }
}
