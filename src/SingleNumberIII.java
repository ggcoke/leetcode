import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/single-number-iii
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class SingleNumberIII {
    public static int[] singleNumber(int[] nums) {
        int ret = 0;

        // a ^ b ^ a = b;
        // XOR all numbers to get the result of XOR between the two numbers we need to find.
        for (int num : nums) {
            ret ^= num;
        }

        // These two number are different, so that at least one bit is set.
        int index = 1;
        while ((ret & index) == 0) {
            index <<= 1;
        }
        ret &= index;

        int[] result = {0, 0};
        for (int num : nums) {
            if ((num & ret) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }


        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};

        int[] ret = SingleNumberIII.singleNumber(nums);

        for (int i = 0; i < ret.length; i++) {
            System.out.println("ret[" + i + "] = " + ret[i]);
        }
    }
}
