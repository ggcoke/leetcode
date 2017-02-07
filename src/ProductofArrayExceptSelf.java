/**
 * Desc here
 *
 * @author Wang Huisong(wanghuisong@le.com)
 */
public class ProductofArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        final int length = nums.length;

        int[] result = new int[length];
        int[] tmp = new int[length];

        // nums: [4,  3,  2,  1,  2]
        // tmp:  [4,  12, 24, 24, 48]
        // out:  [12, 16, 24, 48, 24]
        for (int i = 0; i < length; i++) {
            tmp[i] = (i == 0) ? nums[i] : nums[i] * tmp[i - 1];
        }

        int right = nums[length - 1];
        result[length - 1] = tmp[length - 2];
        for (int i = length - 2; i >= 0; i--) {
            right *= nums[i];
            result[i] = tmp[i - 1] * right;
        }

        return result;
    }
}
