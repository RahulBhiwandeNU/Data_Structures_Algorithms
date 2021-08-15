class Solution {
    public int findMin(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int n : nums)
            pq.add(n);
        
        return pq.peek();
    }
}