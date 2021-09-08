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
    List<Integer> right = new ArrayList<>();
    
    public void traverse(TreeNode node, int level){
        if(level == right.size())
            right.add(node.val);
        
        if(node.right != null)
            traverse(node.right,level+1);
        if(node.left != null)
            traverse(node.left,level+1);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return right;
        traverse(root,0);
        return right;
    }
}