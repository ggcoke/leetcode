import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return 1 - n in lexicographical order.
 *
 * <br>For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 *
 * <br>Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 * @author Wang Huisong(wanghuisong@le.com)
 */
public class LexicographicalNumbers {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<Integer>();
        int current = 1;
        for (int i = 0; i < n; i++) {
            result.add(current);
            if (current * 10 <= n) {
                current *= 10;
            } else {
                if (current >= n) {
                    current /= 10;
                }

                current += 1;

                while (current % 10 == 0) {
                    current /= 10;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 130;
        List<Integer> result = LexicographicalNumbers.lexicalOrder(n);
        System.out.println(result);
    }
}
