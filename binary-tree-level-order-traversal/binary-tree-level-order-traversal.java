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
    
    List<List<Integer>> levels = new ArrayList<>();
    
    public void bfs(TreeNode node, int level){
        if(level == levels.size())
            levels.add(new ArrayList<Integer>());
        levels.get(level).add(node.val);
        if(node.left != null)
            bfs(node.left,level+1);
        if(node.right != null)
            bfs(node.right,level+1);
    }
    
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return levels;
        bfs(root,0);
        return levels;
    }
}