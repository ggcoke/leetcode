package sort;

/**
 * Desc here
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class ShellSort<T extends Comparable> extends BaseSort<T> {
    @Override
    public void sort(T[] src) {
        if (src == null || src.length == 0) {
            return;
        }

        int len = src.length;
        for (int step = len / 2; step > 0; step /= 2) {
            for (int i = step; i < len; i++) {
                for (int j = i - step; j >= 0 && (src[j].compareTo(src[j + step]) > 0); j -= step) {
                    swap(src, j, j+ step);
                }
            }
        }
    }
}
