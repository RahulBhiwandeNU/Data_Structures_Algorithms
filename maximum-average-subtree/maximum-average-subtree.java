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
    public int helper(TreeNode root, double[] res) {
        if (root == null) return 0;
        int numLeftNodes = helper(root.left, res);
        int numRightNodes = helper(root.right, res);
        
        int leftVal = 0;
        int rightVal = 0;
        
        int rootVal = root.val;
        if (root.left != null) leftVal = root.left.val;
        if (root.right != null) rightVal = root.right.val;
        
        int totalSum = rootVal+leftVal+rightVal;
        double currAvg = (double)(totalSum) / (numLeftNodes + numRightNodes + 1);
        res[0] = Math.max(res[0], currAvg);
        
        root.val = totalSum;
        return numLeftNodes + numRightNodes + 1;
    }
    
    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) return 0D;
        double[] res = new double[1];
        helper(root, res);
        return res[0];
    }
}