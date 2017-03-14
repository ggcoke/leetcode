/**
 * https://leetcode.com/problems/number-of-segments-in-a-string/
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class NumberOfSegmentsInString {
    public static int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        boolean segment = false;
        final int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                if (segment) {
                    segment = false;
                    count++;
                }
            } else {
                if (!segment) {
                    segment = true;
                }
            }
        }

        if (segment) {
            count++;
        }

        return count;
    }
}
