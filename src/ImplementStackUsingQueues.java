import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class ImplementStackUsingQueues {
    private Queue<Integer> inQueue;
    private Queue<Integer> outQueue;

    /**
     * Initialize your data structure here.
     */
    public ImplementStackUsingQueues() {
        inQueue = new ArrayDeque<Integer>();
        outQueue = new ArrayDeque<Integer>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        inQueue.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int result = 0;
        while (inQueue.size() > 1) {
            outQueue.add(inQueue.poll());
        }

        if (inQueue.size() == 1) {
            result = inQueue.poll();
        }

        while (outQueue.size() != 0) {
            inQueue.add(outQueue.poll());
        }

        return result;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int result = pop();
        push(result);

        return result;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return inQueue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues obj = new ImplementStackUsingQueues();
        obj.push(2131);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
    }
}
