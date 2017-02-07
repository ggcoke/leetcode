package sort;

/**
 * Desc here
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class SelectionSort<T extends Comparable> extends BaseSort<T> {
    @Override
    public void sort(T[] src) {
        if (src == null || src.length <= 0) {
            return;
        }

        int min = 0;
        for (int i = 0; i < src.length; i++) {
            min = i;
            for (int j = i + 1; j < src.length; j++) {
                if (src[min].compareTo(src[j]) > 0) {
                    min = j;
                }
            }

            if (min != i) {
                swap(src, i, min);
            }
        }
    }
}
