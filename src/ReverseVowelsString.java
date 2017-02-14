import java.util.HashSet;

/**
 * Desc here
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class ReverseVowelsString {

    public static String reverseVowels(String s) {
        int[] pos = new int[s.length()];
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isVowelChar(s.charAt(i))) {
                pos[cnt] = i;
                cnt++;
            }
        }

        char[] ans = s.toCharArray();
        for (int i = 0; i < cnt; i++) {
            ans[pos[i]] = s.charAt(pos[cnt - i - 1]);
        }
        return String.valueOf(ans);
    }

    public static boolean isVowelChar(final char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        String s = "ad";
        String result = reverseVowels(s);
        System.out.println("Result is " + result);
    }
}
