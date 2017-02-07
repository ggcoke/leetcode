import java.util.ArrayList;
import java.util.List;

/**
 * Desc here
 *
 * @author Wang Huisong(wanghuisong@le.com)
 */
public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                sb.append("Fizz");
            }

            if (i % 5 == 0) {
                sb.append("Buzz");
            }

            if (sb.length() == 0) {
                sb.append(String.valueOf(i));
            }

            result.add(sb.toString());
            sb.setLength(0);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(FizzBuzz.fizzBuzz(15));
    }
}
