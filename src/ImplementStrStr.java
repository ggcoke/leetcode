/**
 * https://leetcode.com/problems/implement-strstr/
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;

        final int hLength = haystack.length();
        final int nLength = needle.length();

        int[] next = getNext(needle);

        int i = 0, j = 0;
        while (i < hLength && j < nLength) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == nLength) {
            return i - j;
        }

        return -1;
    }

    public static int[] getNext(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        final int length = str.length();
        int[] result = new int[length];
        result[0] = -1;
        int k = -1;
        int i = 0;

        while (i < length - 1) {
            if (k == -1 || str.charAt(i) == str.charAt(k)) {
                i++;
                k++;
                if (str.charAt(i) != str.charAt(k)) {
                    result[i] = k;
                } else {
                    result[i] = result[k];
                }
            } else {
                k = result[k];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String test = "DABCDABDE";
        int[] next = getNext(test);
        if (next != null) {
            for (int i = 0; i < next.length; i++) {
                System.out.println("Next " + i + " is " + next[i]);
            }
        }
    }
}
