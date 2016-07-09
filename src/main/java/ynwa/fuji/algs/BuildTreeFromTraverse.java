package ynwa.fuji.algs;

import ynwa.fuji.model.TreeNode;

/**
 * Created by ynwa on 16/7/9.
 * {@linkplain TreeTraverse 树的遍历} <p>
 * 根据前序/后序+中序重新建立树的结构<p>
 * 百度中的轨迹图很能说明树遍历的逻辑: /source/TreeTraverse.jpg
 */
public class BuildTreeFromTraverse {
    public static void main(String[] args) {
        int[] pre = {10, 6, 4, 8, 14, 12, 16};
        int[] in = {4, 6, 8, 10, 12, 14, 16};
        int[] post = {4, 8, 6, 12, 16, 14, 10};
        BuildTreeFromTraverse order = new BuildTreeFromTraverse();
//        TreeNode root = order.buildPre_In(pre, 0, pre.length - 1, in, 0, in.length - 1);
        TreeNode root = order.buildPost_In(post, 0, post.length - 1, in, 0, in.length - 1);
        System.err.println(root);
    }

    public TreeNode buildPre_In(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }


        int k = getRoot(pre, in, preStart);
        TreeNode node = new TreeNode(in[k]);

        int leftLength = k - inStart;
        node.left = buildPre_In(pre, preStart + 1, preStart + leftLength, in, inStart, k - 1);
        node.right = buildPre_In(pre, preStart + leftLength + 1, preEnd, in, k + 1, inEnd);
        return node;
    }

    public TreeNode buildPost_In(int[] post, int postStart, int postEnd, int[] in, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }


        int k = getRoot(post, in, postEnd);
        TreeNode node = new TreeNode(in[k]);

        int leftLength = k - inStart;
        node.left = buildPost_In(post, postStart, postStart + leftLength - 1, in, inStart, k - 1);
        node.right = buildPost_In(post, postStart + leftLength, postEnd - 1, in, k + 1, inEnd);
        return node;
    }


    public int getRoot(int[] source, int[] targetIn, int index) {
        int val = source[index];
        int i;
        for (i = 0; i < targetIn.length; i++) {
            if (targetIn[i] == val) {
                return i;
            }
        }
        return i;
    }
}
