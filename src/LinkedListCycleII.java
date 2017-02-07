/**
 * Desc here
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class LinkedListCycleII {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode oneStep = head;
        ListNode twoStep = head;

        while (twoStep != null) {
            if (twoStep.next == null || twoStep.next.next == null) {
                // there is no cycle
                return null;
            }

            oneStep = oneStep.next;
            twoStep = twoStep.next.next;

            if (oneStep == twoStep) {
                oneStep = head;
                while (oneStep != twoStep) {
                    oneStep = oneStep.next;
                    twoStep = twoStep.next;
                }

                return oneStep;
            }
        }

        return null;
    }
}