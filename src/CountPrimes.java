import java.util.HashMap;
import java.util.Map;

/**
 * Desc here
 *
 * @author Wang Huisong(wanghuisong@le.com)
 */
public class CountPrimes {
    public int countPrimes(int n) {
        Map<Integer, Boolean> result = new HashMap<Integer, Boolean>();
        for (int i = 2; i < n; i++) {
            result.put(i, true);
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!result.get(i)) continue;
            for (int j = i * i; j < n; j += i) {
                result.put(j, false);
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (result.get(i)) {
                System.out.println(i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes count = new CountPrimes();
        int n = 90;
        System.out.println("Count is " + count.countPrimes(n));
    }
}
