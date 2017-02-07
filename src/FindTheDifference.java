import java.util.Arrays;

/**
 * Desc here
 *
 * @author Wang Huisong(wanghuisong@le.com)
 */
public class FindTheDifference {
    public static char findTheDifference(String s, String t) {
        if (t == null || t.length() <= 0) return ' ';
        if (s == null) {
            return t.charAt(0);
        }

        char[] src = s.toCharArray();
        char[] dst = t.toCharArray();
        Arrays.sort(src);
        Arrays.sort(dst);

        for (int i = 0; i < src.length; i++) {
            if (src[i] != dst[i]) {
                return dst[i];
            }
        }

        return dst[dst.length - 1];
    }
}
