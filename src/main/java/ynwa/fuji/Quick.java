package ynwa.fuji;

import static ynwa.fuji.util.Utils.*;

/**
 * Created by David Wang<wdw@winbaoxian.com> on 2016-07-04.
 */
public class Quick {

    private int[] arr;

    private void quick_sort_recursive(int start, int end) {
        if (start >= end)
            return;
        int left = partition(start, end);
        quick_sort_recursive(start, left - 1);
        quick_sort_recursive(left + 1, end);
    }

    private int randomizedPartition(int start,int end) {
        int i = (int) (Math.random() * (end - start)) + start;
        swap(arr,i,end);
        return partition(start,end);
    }

    private int partition(int start, int end) {
        int mid = arr[end];
        int left = start, right = end - 1;
        while (left < right) {
            while (arr[left] < mid && left < right)
                left++;
            while (arr[right] >= mid && left < right)
                right--;
            swap(arr, left, right);
        }
        if (arr[left] >= arr[end])
            swap(arr, left, end);
        else
            left++;
        return left;
    }

    public void sort(int[] arrin) {
        arr = arrin;
        quick_sort_recursive(0, arr.length - 1);
    }

    public static int[] randomArr() {
        int[] array = new int[7];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        return array;
    }

    public static void main(String[] args) {
//        System.err.println((int) (Math.random() * (10 - 5)) + 5);
        Quick quick = new Quick();
        do {
            int[] a = randomArr();
            a = new int[]{9,1,3,4,7,6,0};
            int[] b = new int[a.length];
            System.arraycopy(a,0,b,0,a.length);
            quick.sort(a);
            if(!isSort(a)) {
                show(a);
                show(b);
                break;
            }
        } while (1 == 1);
    }
}
