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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Stack<Pair<TreeNode,Integer>> stack = new Stack<>();
        if(root == null)
            return false;
        
        stack.push(new Pair(root,targetSum - root.val));
        int sum;
        while(!stack.isEmpty()){
            Pair<TreeNode,Integer> curr = stack.pop();
            root = curr.getKey();
            sum = curr.getValue();
            
            if(root.left == null && root.right == null && sum == 0){
                return true;
            }
            
            if(root.left != null)
                stack.push(new Pair(root.left,sum - root.left.val));
            
            if(root.right != null)
                stack.push(new Pair(root.right,sum - root.right.val));
        }
        return false;
    }
}