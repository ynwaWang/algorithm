package ynwa.fuji.util;

/**
 * Created by ynwa on 16/7/1.
 */
public class Utils {
    public static void exchange(int a[],int i,int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    public static void swap(int arr[],int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static boolean isSort(int a[]) {
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[i-1]) return false;
        return true;
    }

    public static void show(int a[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < a.length - 1; i++) {
            sb.append(a[i]).append(",");
        }
        sb.append(a[a.length - 1]);
        System.err.println(sb.toString());
    }
}
