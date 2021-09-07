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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean even = true;
        
        while(!queue.isEmpty()){
            int level = queue.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for(int i = 0 ; i < level ; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
                
                if(even)
                    temp.add(curr.val);
                else
                    temp.addFirst(curr.val);
            }
            list.add(temp);
            even = !even;
        }
        
        return list;
    }
}