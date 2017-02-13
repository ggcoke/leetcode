/**
 * https://leetcode.com/problems/single-number-ii
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class SingleNumberII {
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length < 0) {
            return -1;
        }

        int ones = 0, twos = 0, xthrees = 0;
        int n = nums.length;
        for(int i = 0; i < n; ++i) {
            System.out.println("------------------------------------------------------------");
            twos |= (ones & nums[i]);
            ones ^= nums[i];
            xthrees = ~(ones & twos);
            ones &= xthrees;
            twos &= xthrees;
        }

        return ones;
    }

    public static void main(String[] args) {
        int[] nums = {11, 11, 4, 11, 6, 6, 6};
        int result = SingleNumberII.singleNumber(nums);

        System.out.println("Result is " + result);
    }
}
