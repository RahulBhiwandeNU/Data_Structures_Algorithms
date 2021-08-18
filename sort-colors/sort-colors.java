class Solution {
    public void sortColors(int[] nums) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        for(int n : nums)
            min_heap.add(n);
        
        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = min_heap.poll();
        }
    }
}