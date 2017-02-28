/**
 * https://leetcode.com/problems/first-missing-positive/
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 1;
        }

        print(nums);

        final int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] <= length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
                System.out.print("Current index is " + i + ": ");
                print(nums);
            }
        }

        print(nums);

        int result = 1;

        for (result = 1; result <= length; result++) {
            if (nums[result - 1] != result) {
                break;
            }
        }

        return result;
    }

    private static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
        System.out.println();
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int result = firstMissingPositive(nums);
        System.out.println("Result is " + result);
    }
}
