package ynwa.fuji;

/**
 * Created by ynwa on 16/7/1.
 */
public class Utils {
    public static void exchange(int a[],int i,int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }
}
