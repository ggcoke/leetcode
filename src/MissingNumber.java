/**
 * https://leetcode.com/problems/missing-number/
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int sum = 0;
        int product = 0;
        final int length = nums.length;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            product *= nums[i];
        }

        final int total = length * (length + 1) / 2;
        if (product != 0) {
            return 0;
        }

        return (total - sum);
    }
}
