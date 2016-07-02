package ynwa.fuji;

/**
 * Created by David Wang<wdw@winbaoxian.com> on 2016-07-02.
 */
public class Merge {

    public static void mergeSort(int[] arr, int[] reg, int lo, int hi) {
        if (lo >= hi)
            return;
        int len = hi - lo, mid = (len >> 1) + lo;
        int start1 = lo, end1 = mid;
        int start2 = mid + 1;
        mergeSort(arr, reg, start1, end1);
        mergeSort(arr, reg, start2, hi);
        int k = lo;
        while (start1 <= end1 && start2 <= hi)
            reg[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            reg[k++] = arr[start1++];
        while (start2 <= hi)
            reg[k++] = arr[start2++];
        for (k = lo; k <= hi; k++)
            arr[k] = reg[k];
    }

    public static void mergeSort1(int[] a,int lo,int hi) {
        if (lo >= hi)
            return;
        int mid = lo + (hi - lo) >> 1;
        mergeSort1(a,lo,mid);
        mergeSort1(a,mid+1,hi);
        merge1(a,lo,mid,hi);
    }

    /**
     * 1 只用1个大的集合的copy作为tmp，将合并后的集合存到tmp然后再copy回源集合
     * 2 用left+right的2个小集合，将这2个合并到源集合
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge1(int[] a, int lo,int mid,  int hi) {
        int[] tmp = new int[hi-lo];


    }

    public static void merge2(int[] a,int lo,int mid,int hi) {
        int[] left = new int[mid - lo];
        int[] right = new int[hi - mid];


    }

    public static void main(String[] args) {
        int[] arr = {5,2,4,7,1,3,6};
        int[] reg = new int[arr.length];
        mergeSort(arr, reg, 0, arr.length - 1);

        System.err.println("1");
    }
}
