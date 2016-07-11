package ynwa.fuji.algs;

import static ynwa.fuji.util.Utils.exchange;

/**
 * Created by ynwa on 16/7/9.
 */
public class Huffman {

    public static void main(String[] args) {
        int[] data = {5,13,12,16,9,45};
        MinHeap minHeap = new MinHeap(data);
//        for (int i = 0; i < arr.length; i++) {
//            minHeap.add(arr[i]);
//        }

        System.err.println("1");
    }

    static class MinHeap {
        int[] data;

        public MinHeap(int[] data) {
            this.data = data;
            int startIndex = (data.length - 2) >> 1;
            //从尾端开始创建最大堆，每次都是正确的堆
            for (int i = startIndex; i >= 0; i--) {
                maxHeapify(i);
            }
        }

        public int poll() {
            int max = data[0];
            int length = data.length;

            data[0] = data[length - 1];
            data[length - 1] = data[length - 2];
            maxHeapify(0);
            return max;
        }

        void add(int key) {
            int i = data.length;
            data[data.length] = key;
            int j;
            while ((j = (i - 1) >> 1) > 0 && less(data[j],data[i])) {
                exchange(data, i, j);
                i = j;
            }
        }

        public void maxHeapify(int root) {
            int left = 2 * root + 1;
            int right  = 2 * root + 2;

            int largest = root;
            if(left < data.length && less(data[largest], data[left])) {
                largest = left;
            }
            if(right < data.length && less(data[largest], data[right])) {
                largest = right;
            }

            if (largest != root) {
                int temp = data[root];
                data[root] = data[largest];
                data[largest] = temp;
                maxHeapify(largest);
            }
        }

        private boolean less(int a,int b) {
            // 用于最大堆
//            return a < b;
            // 用于最小堆
            return a > b;
        }
    }
}
