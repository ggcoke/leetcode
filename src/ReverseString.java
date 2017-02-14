/**
 * Desc here
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class ReverseString {
    public static String reverseString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int length = s.length();
        String left = reverseString(s.substring(0, length / 2));
        String right = reverseString(s.substring(length / 2, length));

        return right + left;
    }

    public static void main(String[] args) {
        String s = "this is test";
        String result = reverseString(s);
        System.out.println("Result is " + result);
    }
}
