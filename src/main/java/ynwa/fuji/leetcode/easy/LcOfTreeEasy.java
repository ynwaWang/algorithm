package ynwa.fuji.leetcode.easy;

import java.util.*;

/**
 * Created by ynwa on 16/7/9.
 * https://leetcode.com/problems/binary-tree-paths/
 * https://leetcode.com/problems/same-tree/
 * TODO 刷树的easy题目
 */
public class LcOfTreeEasy {
    /**
     * binary-tree-paths
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }

    /**
     * same-tree
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        return (p.val==q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
