package ynwa.fuji.leetcode.hard;

import java.util.Stack;

/**
 * Created by ynwa on 16/7/8.
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 基本思路:最大矩形最有可能出现在最大值？周边,即左边/右边/两边(和最大值是相连的,也就是取最长矩形,其最低*长度),这样就实现了子最优
 * 或者用2分法，可能好一点
 */
public class Lc84 {
    public static void main(String[] args) {
//        int[] heights = {1,1};
//        int[] heights = {0,1,0,2,1,0,3,1,2,1,2,1};
//        int[] heights = {12,11,10,9,8,7,6,5,4,3,2,1};
//        int[] heights = {1,3,2,1,2,1};
        int[] heights = {1,2,3,4,5,6,7,8,9};
        int x = largestRectangleArea(heights);
        System.err.println(x);
    }

    public static int largestRectangleArea(int[] height) {

        Stack<Integer> stack = new Stack<Integer>();
        int max_area = 0;

        for(int i=0; i<=height.length; ++i){
            int height_bound = (i == height.length) ? 0 : height[i];

            while(!stack.isEmpty()){
                int h = height[stack.peek()];

                // calculate the area for every ascending slope.
                if(h < height_bound){
                    break;
                }
                stack.pop();

                // at the end, the area with the height of the minimal element.
                int index_bound = stack.isEmpty() ? -1 : stack.peek();
                max_area = Math.max(max_area, h*((i-1)-index_bound));
            }

            stack.push(i);
        }

        return max_area;
    }

    /**
     * 在第二个测试案例失败了，看来这个算法无法满足这个需求了
     *
     * @deprecated use {@link #largestRectangleArea(int[])} instead.
     */
    @Deprecated
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
        System.err.println(lo + "-" +mid + "-" + hi);
        int count = 1;
        int min = heights[mid];
        int i = mid + 1,j = mid - 1,k = lo;
        while (i <= hi && j >= lo && k++ < hi) {
            if(j < 0 || (heights[i] > heights[j])) {
                if(add(heights,i,min,count)) {
                    min = Math.min(min,heights[i]);
                    count++;i++;
                }
            } else {
                if(add(heights,j,min,count)) {
                    min = Math.min(min,heights[j]);
                    count++;j--;
                }
            }
        }
        return min * count;
    }

    private static boolean add(int[] heights,int j,int min,int count) {
        return heights[j] >= min || (heights[j] <= min && min * count <= heights[j] * (count + 1));
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
