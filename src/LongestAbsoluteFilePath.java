import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Desc here
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class LongestAbsoluteFilePath {

    /**
     * dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext
     *
     *
     * @param input
     * @return
     */
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0 || !input.contains(".")) {
            return 0;
        }

//        Map<Integer/* level */, Integer/* length */> stack = new HashMap<Integer, Integer>();
        int[] stack = new int[input.length() + 1];
        String[] content = input.split("\n");
        int max = 0;
        for (String s : content) {
            int level = s.lastIndexOf("\t") + 1;
//            int parentLength = stack.containsKey(level) ? stack.get(level) : 0;
//            int currentLength = parentLength + s.replaceAll("\t", "").length() + 1;
//            stack.put(Integer.valueOf(level + 1), Integer.valueOf(currentLength));

            int parentLength = stack[level];
            int currentLength = parentLength + s.length() - level + 1;
            stack[level + 1] = currentLength;

            if (s.contains(".")) {
                max = Math.max(max, currentLength - 1);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestAbsoluteFilePath longest = new LongestAbsoluteFilePath();
        String path = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\ts ubsubdir2\n\t\t\t   file2.ext";
        System.out.println("Result is " + longest.lengthLongestPath(path));
    }
}
