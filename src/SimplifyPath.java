import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Desc here
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
        if (path == null) {
            return path;
        }

        String[] paths = path.split("/");
        if (paths.length == 1) {
            return "/" + paths[0];
        }

        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new LinkedList<>();
        int count = paths.length;
        for (int i = 0; i < count; i++) {
            if (paths[i] == null || paths[i].length() <= 0) {
                continue;
            }

            if (paths[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (paths[i].equals(".")) {
                // do nothing
            } else {
                stack.push(paths[i]);
            }
        }

        while (!stack.isEmpty()) {
            sb.append("/").append(stack.pollLast());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }


    public static void main(String[] args) {
        String path = "/home/.././fsa/adb/./cde";
        System.out.println("Result is " + simplifyPath(path));
    }
}
