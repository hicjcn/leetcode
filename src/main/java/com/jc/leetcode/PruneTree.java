package com.jc.leetcode;

import com.jc.leetcode.struct.TreeNode;

/**
 * 814. 二叉树剪枝
 *
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 *
 * 返回移除了所有不包含 1 的子树的原二叉树。
 *
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-pruning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenjian on 2019/10/8
 */
public class PruneTree {
    public static void main(String[] args) {
        /**
         *          1
         *      1       0
         *            1    0
         */
        PruneTree pruneTree = new PruneTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(0);
        root = pruneTree.pruneTree(root);
        System.out.println(1);
    }

    public TreeNode pruneTree(TreeNode root) {
        if (null == root){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (0 == root.val && null == root.left && null == root.right){
            return null;
        }
        return root;
    }
}
