import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-k-digits/
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        int remain = num.length() - k;
        char[] numArray = num.toCharArray(), res = new char[remain];
        int index = 0;
        for(int i = 0; i < numArray.length; i++) {
            while((numArray.length - i > remain - index) && (index > 0 && numArray[i] < res[index - 1])) {
                index--;
            }
            if(index < remain) {
                res[index++] = numArray[i];
            }
        }

        index = -1;
        while(++index < remain) {
            if(res[index] != '0') break;
        }
        String s = new String(res).substring(index);

        return s.length() == 0 ? "0" : s;
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        String ret = RemoveKDigits.removeKdigits(num, k);
        System.out.println(ret);
    }
}
