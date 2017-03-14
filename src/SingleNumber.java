/**
 * https://leetcode.com/problems/single-number/
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length < 0) {
            return -1;
        }

        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4, 5, 5, 4, 2};

        int result = SingleNumber.singleNumber(nums);
        System.out.println("Result is " + result);
    }
}
