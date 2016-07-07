package ynwa.fuji.leetcode.easy;

/**
 * Created by ynwa on 16/7/7.
 * https://leetcode.com/problems/sum-of-two-integers/
 * 位运算实现+和-
 * boring
 */
public class Lc371 {
    int add(int a, int b) {
        int carry, add;
        do {
            add = a ^ b;
            carry = (a & b) >> 1;
            a = add;
            b = carry;
        } while(carry != 0);
        return add;
    }

    int subtract(int a, int b) {
        return add(a, add(~b, 1));
    }
}
