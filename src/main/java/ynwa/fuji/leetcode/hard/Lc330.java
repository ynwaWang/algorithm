package ynwa.fuji.leetcode.hard;

/**
 * Created by ynwa on 16/7/7.
 * https://leetcode.com/problems/patching-array/
 * <p>
 * 题意在于cover和minimum patches <p>
 * 1. 补丁次数最少就需要打上最大的补丁,补丁太大就会导致无法覆盖前面的漏洞 <p>
 * 2. 不断的patch 1，势必能做到覆盖，但是无法满足最少<p>
 * 3. added 那段的含义就是有漏洞就填上
 */
public class Lc330 {

    static int minPatches(int[] nums, int n) {
        int miss = 1, added = 0, i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                added++;
            }
        }
        return added;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 5, 10};
        int[] nums = {1, 1, 1,5};
        System.err.println(minPatches(nums,9));
    }
}
