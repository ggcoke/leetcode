/**
 * Desc here
 *
 * @author Wang Huisong(wanghuisong@le.com)
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int length = nums.length;
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                nums[i] = nums[length - count - 1];
                nums[length - count - 1] = (val - 1);
                count++;
            }
        }

        return length - count;
    }
}
