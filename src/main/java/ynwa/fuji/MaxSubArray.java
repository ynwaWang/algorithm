package ynwa.fuji;

/**
 * 分治算法 求解 最大子数组
 *
 * Created by David Wang<wdw@winbaoxian.com> on 2016-07-02.
 */
public class MaxSubArray {

    public static int[] find(int[] a,int lo,int hi) {
        if (lo == hi) return new int[]{lo,hi,sum(a,lo,hi)};
        int mid = (hi - lo) >> 1 + lo;
        int[] left = find(a,lo,mid);
        int[] right = find(a,mid + 1,hi);
        int[] cross = findCross(a,lo,mid,hi);
        if(cross[2] >= left[2] && cross[2] >= right[2]) {
            return cross;
        } else if(cross[2] < left[2] && cross[2] >= right[2]) {
            return left;
        } else {
            return right;
        }
    }

    private static int[] findCross(int[] a, int lo, int mid, int hi) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = mid;
        for (int i = mid; i > lo; i--) {
            sum += a[i];
            if (leftSum < sum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        int maxRight = mid + 1;
        for (int i = mid + 1; i < hi; i++) {
            sum += a[i];
            if (rightSum < sum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        return new int[]{maxLeft,maxRight,leftSum + rightSum};
    }

    public static int sum(int[] a,int lo,int hi) {
        int sum = 0;
        for (int i = lo; i < hi; i++) {
            sum += a[i];
        }
        return sum;
    }
}
