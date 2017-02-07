package sort;

/**
 * Desc here
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public abstract class BaseSort<T extends Comparable> {
    public abstract void sort(T[] src);

    public void swap(T[] src, int from, int to) {
        assert (src != null && from >=0 && from < src.length && to >= 0 && to < src.length);

        T tmp = src[from];
        src[from] = src[to];
        src[to] = tmp;
    }
}
