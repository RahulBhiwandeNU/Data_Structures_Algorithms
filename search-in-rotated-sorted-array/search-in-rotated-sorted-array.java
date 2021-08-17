class Solution {
    public int search(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++)
            map.put(nums[i],i);
        
        for(int n : nums){
            if(n == target)
                return map.get(n);
        }
        return -1;
    }
}