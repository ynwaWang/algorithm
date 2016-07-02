package ynwa.fuji;


import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ynwa.fuji.Utils.*;
/**
 * Created by ynwa on 16/7/1.
 */
public class Insertion {
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(a[j] > a[j+1]) {
                    exchange(a,j,j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5,2,4,6,1,3};
        sort(a);
        System.err.println("1");
    }
}
