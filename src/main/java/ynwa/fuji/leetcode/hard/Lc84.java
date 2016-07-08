package ynwa.fuji.leetcode.hard;

/**
 * Created by ynwa on 16/7/8.
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * TODO 基本思路:最大矩形最有可能出现在最大值？周边,即左边/右边/两边(和最大值是相连的,也就是取最长矩形,其最低*长度),这样就实现了子最优
 * TODO 或者用2分法，可能好一点
 */
public class Lc84 {
    public static void main(String[] args) {
//        int[] heights = {1,1};
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        int x = find(heights,0,heights.length-1);
        System.err.println(x);
    }

    public static int find(int[] heights,int lo,int hi) {
        if(lo >= hi) {
            return heights[lo];
        }
        int mid = (lo + hi) >> 1;
        int left = find(heights,lo,mid - 1);
        int right = find(heights,mid + 1,hi);
        int cross = findCross(heights,lo,mid,hi);
        return Math.max(cross,Math.max(left,right));
    }

    private static int findCross(int[] heights, int lo, int mid, int hi) {
        int count = 1;
        int min = heights[mid];
        int i = mid + 1,j = mid - 1;
        while (i <= hi) {
            if(heights[i] < min && min * count < heights[i] * (count + 1)) {
                count++;
                min = heights[i++];
            } else if(heights[i] >= min) {
                count++;i++;
            } else {
                break;
            }
        }
        while (j >= lo) {
            if(heights[j] < min && min * count < heights[j] * (count + 1)) {
                count++;
                min = heights[j--];
            } else if(heights[j] >= min) {
                count++;j--;
            } else {
                break;
            }
        }
        return min * count;
    }



    static class Rectangle {
        int count;
        int min;

        public Rectangle(int height) {
            count = 1;
            min = height;
        }

        public void add(int height) {
            if (height < min && min * count < height * (count + 1)) {
                min = height;
            } else if(height >= min) {
                count++;
            }
        }
    }

}
