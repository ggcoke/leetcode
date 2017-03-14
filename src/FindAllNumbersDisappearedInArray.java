import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class FindAllNumbersDisappearedInArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length <= 0) {
            return result;
        }

        final int length = nums.length;

        for (int i = 0; i < length; i ++) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] != (i + 1)) {
                result.add(i + 1);
            }
        }

        return result;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
