import java.util.ArrayList;
import java.util.List;

/**
 * Desc here
 *
 * @author Wang Huisong(wanghuisong@le.com)
 */
public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combine(n, k, 1, null, result);
        return result;
    }

    public static void combine(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current == null) {
            current = new ArrayList<Integer>();
        }

        if (k == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            combine(n, k - 1, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
