package sort;

/**
 * Desc here
 *
 * @author Wang Huisong(wanghuisong@le.com)
 */
public class InsertionSort <T extends Comparable> extends BaseSort<T> {
    @Override
    public void sort(T[] src) {
        if (src == null || src.length <= 0) {
            return;
        }

        for (int i = 1; i < src.length; i++) {
            for (int j = i - 1; j >= 0 && (src[j].compareTo(src[j + 1]) > 0); j--) {
                swap(src, j, j + 1);
            }
        }
    }
}
