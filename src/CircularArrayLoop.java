/**
 * Desc here
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class CircularArrayLoop {
    public static boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        final int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                continue;
            }

            int slow = i;
            int fast = getNextIndex(nums, slow);

            while (nums[slow] * nums[fast] > 0 && nums[fast] * nums[getNextIndex(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow == getNextIndex(nums, slow)) {
                        break;
                    }

                    return true;
                }

                slow = getNextIndex(nums, slow);
                fast = getNextIndex(nums, getNextIndex(nums, fast));
            }

            slow = i;
            int value = nums[i];
            while (value * nums[slow] > 0) {
                int next = getNextIndex(nums, slow);
                nums[next] = 0;
                slow = next;
            }
        }

        return false;
    }

    private static int getNextIndex(int[] nums, int i) {
        int length = nums.length;
        return (i + nums[i] >= 0) ? (i + nums[i]) % length : (i + nums[i]) % length + length;
    }

    public static void main(String[] args) {
        int[] nums = {2, -1, 1, 2, 2};

        System.out.println(CircularArrayLoop.circularArrayLoop(nums));
    }
}
