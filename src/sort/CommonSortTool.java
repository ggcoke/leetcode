package sort;

/**
 * Desc here
 *
 * @author Wang Huisong(wanghuisong@le.com)
 */
public class CommonSortTool<T extends Comparable> {
    private static Integer[] src = {10, 5, 9, 7, 1, 8, 2, 15, 3};

    private void run(BaseSort<T> func, T[] src) {
        T[] copy = src.clone();
        long before = System.currentTimeMillis();
        func.sort(copy);
        long after = System.currentTimeMillis();
        System.out.print("Time: " + (after - before) + " Result: ");
        print(copy);
    }

    private void print(T[] src) {
        if (src == null || src.length == 0) {
            System.out.println("Src is empty");
            return;
        }

        for (int i = 0; i < src.length; i++) {
            System.out.print(src[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CommonSortTool<Integer> tool = new CommonSortTool<Integer>();

        BaseSort<Integer> selection = new SelectionSort<Integer>();
        BaseSort<Integer> insertion = new InsertionSort<Integer>();
        BaseSort<Integer> shell = new ShellSort<Integer>();

        tool.run(selection, src);
        tool.run(insertion, src);
        tool.run(shell, src);
    }
}
