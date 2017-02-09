import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class ImplementQueueUsingStacks {
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (inStack.size() != 0) {
            outStack.add(inStack.pop());
        }

        int result = outStack.pop();

        while (outStack.size() != 0) {
            inStack.add(outStack.pop());
        }

        return result;
    }

    /** Get the front element. */
    public int peek() {
        int result = 0;

        while (inStack.size() != 0) {
            outStack.add(inStack.pop());
        }

        result = outStack.peek();

        while (outStack.size() != 0) {
            inStack.add(outStack.pop());
        }

        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty();
    }
}
