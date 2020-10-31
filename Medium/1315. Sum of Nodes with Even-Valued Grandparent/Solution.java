/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        
        //  create parent node and point both leafs to root
        TreeNode parent = new TreeNode(-1);
        parent.right = root;
        parent.left = root;
        
        return helper(parent, root);
    }
    
    private int helper(TreeNode parent, TreeNode node) {
        if (node == null) return 0;
        
        int temp = 0;
        //  if grandparent value is even
        if (parent.val%2 == 0) {
            // add grandchildern values if not null
            temp = (node.right != null) ? node.right.val : 0;
            temp += (node.left != null) ? node.left.val : 0;
        }
        
        //  recursively call next generation
        return temp + helper(node, node.right) + helper(node, node.left);
    }
}