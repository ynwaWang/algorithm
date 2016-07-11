package ynwa.fuji.leetcode.medium;

import ynwa.fuji.model.TreeNode;

/**
 * Created by David Wang<wdw@winbaoxian.com> on 2016-07-09.
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * TODO 求解最近公共父节点
 */
public class Lc236 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    public static void main(String[] args) {
        TreeNode[] arr = new TreeNode[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = new TreeNode(i);
        }
        TreeNode root = arr[3];
        root.left =             arr[5];
        root.left.left =        arr[6];
        root.left.right =       arr[2];
        root.left.right.left =  arr[7];
        root.left.right.right = arr[4];
        root.right =            arr[1];
        root.right.left =       arr[0];
        root.right.right =      arr[8];

        TreeNode p = arr[6], q = arr[8];
        TreeNode x = lowestCommonAncestor(root,p,q);
        System.err.println(x);
    }
}
