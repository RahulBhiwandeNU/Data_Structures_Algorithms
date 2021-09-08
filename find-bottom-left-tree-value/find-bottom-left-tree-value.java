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
    List<List<Integer>> res = new ArrayList<>();
    
    public void bfs(TreeNode node, int level){
        if(level == res.size())
            res.add(new ArrayList<Integer>());
        res.get(level).add(node.val);
        if(node.left != null)
            bfs(node.left,level+1);
        if(node.right != null)
            bfs(node.right,level+1);
    }
    
    
    public int findBottomLeftValue(TreeNode root) {
        if(root == null)
            return 0;
        bfs(root,0);
        return res.get(res.size()-1).get(0);
    }
}