import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Desc here
 *
 * @author Wang Huisong(wanghuisong@le.com)
 */
public class LongestIncreasingSubsequence {
    /**
     * 5, 3, 4, 8, 6, 7
     *
     * @param input
     * @return
     */
    public static int lengthLongestIncreasingSubsequenceN2(List<Integer> input) {
        if (input == null || input.size() <= 0) {
            return 0;
        }

        int[] dp = new int[input.size()];
        int max = 1;
        for (int i = 0; i < input.size(); i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if ((input.get(j) <= input.get(i)) && ((dp[j] + 1) > dp[i])) {
                    dp[i] = dp[j] + 1;
                }
            }

            max = dp[i] > max ? dp[i] : max;
        }

        return max;
    }

    public static List<Integer> lengthLongestIncreasingSubsequenceNLogN(List<Integer> input) {
        if (input == null || input.size() <= 0) {
            return new ArrayList<Integer>();
        }

        Integer[] result = new Integer[input.size()];
        int length = 0;
        result[0] = input.get(0);

        for (int i = 1; i < input.size(); i++) {
            int num = input.get(i);
            if (i == 0 || result[length] < num) {
                length++;
                result[length] = num;
            } else {
                int pos = Arrays.binarySearch(result, 0, length, num);
                System.out.println(num + ":" + pos);
                if (pos < 0) {
                    result[-(pos + 1)] = num;
                }
            }
        }

        return Arrays.asList(result);
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<Integer>();
        // 2，1 ，5 ，3 ，6，4， 8 ，9， 7
        input.add(4);
        input.add(6);
        input.add(3);
        input.add(1);
        input.add(6);
        input.add(4);
        input.add(3);
        input.add(8);
        input.add(9);
        input.add(7);

        System.out.println("Result is " + lengthLongestIncreasingSubsequenceNLogN(input));
    }
}
