import java.util.Arrays;

/**
 * Desc here
 *
 * @author Wang Huisong(wanghuisong@le.com)
 */
public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        int result = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        print(g);
        print(s);

        final int gl = g.length;
        final int sl = s.length;
        for (int i = 0, j = 0; i < gl; i++) {
            while (j < sl && s[j] < g[i]) {
                j++;
            }

            if (j == sl) {
                break;
            }

            j++;
            result++;
        }

        return result;
    }

    private static void print(int[] s) {
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + ",");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] g = {1, 3, 2};
        int[] s = {3};
        System.out.println(findContentChildren(g, s));
    }
}
