package ynwa.fuji.leetcode.easy;

import ynwa.fuji.model.TreeNode;

import java.util.*;

/**
 * Created by ynwa on 16/7/9.
 *
 * TODO 刷树的easy题目
 */
public class LcOfTreeEasy {
    /**
     * https://leetcode.com/problems/binary-tree-paths/
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }

    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }

    /**
     * https://leetcode.com/problems/same-tree/
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int level = 1;
        levelOrderInput(level, root, result);
        List<List<Integer>> reverseRst = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            reverseRst.add(result.get(i));
        }
        return reverseRst;
    }

    private void levelOrderInput(int level, TreeNode root, List<List<Integer>> result) {
        if (root == null) return;
        if (result.size() < level) {
            result.add(level - 1, new LinkedList<Integer>());
        }
        result.get(level - 1).add(root.val);
        levelOrderInput(level++, root.left, result);
        levelOrderInput(level++, root.right, result);
    }

    /**
     * https://leetcode.com/problems/symmetric-tree/
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null || (root.left == null && root.right == null) ||
                (root.left != null && root.right != null && isSymmetric(root.left, root.right));
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return (p.val == q.val) && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }

    /**
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/ <p>
     * BST的特性就是有序，left < parent < right <p>
     * {@linkplain ynwa.fuji.leetcode.medium.Lc236 最近公共父节点进阶版 }
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((p.val - root.val) * (q.val - root.val) > 0) {
            root = p.val > root.val ? root.right : root.left;
        }
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
