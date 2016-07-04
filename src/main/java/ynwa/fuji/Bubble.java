package ynwa.fuji;

import static ynwa.fuji.util.Utils.*;
/**
 * Created by David Wang<wdw@winbaoxian.com> on 2016-07-02.
 */
public class Bubble {
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] > a[j]) exchange(a,i,j);
            }
        }
    }

    public static void sort1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[j] < a[j-1]) exchange(a,j,j-1);
            }
        }
    }

    public static void sort2(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) exchange(a,j,j-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,4,7,1,3,6};
        sort1(arr);

        System.err.println("1");
    }
}
