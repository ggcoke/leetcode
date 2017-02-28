/**
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class ConvertNumberToHexadecimal {
    public static String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            return "0";
        }

        while (num != 0) {
            int current = num & 0xf;
            if (current >= 10) {
                sb.insert(0, (char) ('a' + (current - 10)));
            } else {
                sb.insert(0, (char) ('0' + current));
            }
            num >>>= 4;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Result is " + toHex(Integer.MIN_VALUE));
    }
}
