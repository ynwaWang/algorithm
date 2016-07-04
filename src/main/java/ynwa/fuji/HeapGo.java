package ynwa.fuji;

import static ynwa.fuji.util.Utils.*;

/**
 * Created by ynwa on 16/7/1.
 */
@Deprecated
public class HeapGo {
    public static void maxHeapify(int[] a, int root) {
        int left = left(root);
        int right = right(root);
        int top = root;


        if (left < a.length && a[left] > a[root]) {
            top = left;
        }

        if (right < a.length && a[right] > a[top]) {
            top = right;
        }

        if (top != root) {
            int tmp = a[root];
            a[root] = a[top];
            a[top] = tmp;

            maxHeapify(a, top);
        }

    }

    public static int left(int root) {
        return (root << 1) + 1;
    }

    public static int right(int root) {
        return (root << 1) + 2;
    }

    public static int parent(int leaf) {
        return (leaf - 1) >> 1;
    }


    /**
     * 以下是优先队列的api
     *
     * @param a
     * @return
     */
    public int peek(int[] a) {
        return a[0];
    }


    /**
     * 优先队列取最大值,依据是二叉堆的首个元素就是最大值
     * 将数组最后一个赋值给首元素,再做一次堆排序
     *
     * @param a
     * @return
     */
    public int poll(int[] a) {
        int max = a[0];
        int length = a.length;

        a[1] = a[length - 1];
        a[length - 1] = a[length - 2];
        maxHeapify(a, 0);
        return max;
    }

    /**
     * 增加堆中的i元素的优先级到key
     * 递归向上交换
     *
     * @param a
     * @param i   目标元素下标
     * @param key 优先级
     */
    public void incrPriority(int[] a, int i, int key) {
        a[i] = key;
        int j;
        while ((j = parent(i)) > 0 && a[i] > a[j]) {
            exchange(a, i, j);
            i = j;
        }
    }

    /**
     * 其实就是在尾部增加一个元素,并增加其优先级
     * 这样就能复用{@link #incrPriority(int[], int, int)}
     *
     * @param a
     * @param key
     */
    public void insert(int[] a, int key) {
        int[] A = new int[a.length + 1];
        System.arraycopy(a, 0, A, 0, a.length);
        a = A;
        incrPriority(a, a.length - 1, key);
    }

    private static int[] sort = new int[]{1,0,10,20,3,5,6,4,9,8,12,17,34,11};
    public static void main(String[] args) {
//        int[] a = {1, 2};
//        exchange(a, 0, 1);
//        System.err.println(a);
        for (int i = sort.length; i >= 0; i--) {
            maxHeapify(sort,i);
        }
        System.err.println(sort);
    }
}
