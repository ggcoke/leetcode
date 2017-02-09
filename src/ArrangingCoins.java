/**
 * Desc here
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class ArrangingCoins {
    public static int arrangeCoins(int n) {
        return (int) (Math.sqrt(2 * n + 0.25) - 0.5);
    }
}
