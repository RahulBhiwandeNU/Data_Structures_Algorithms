class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        Arrays.sort(nums);
        int curr_max = 1;
        int max_so_far = 1;
        
        for(int i = 1 ; i < nums.length; i++){
            
            if(nums[i] != nums[i-1]){
                if(nums[i] == nums[i-1]+1)
                    curr_max++;
                else {
                    max_so_far = Math.max(max_so_far,curr_max);
                    curr_max = 1;
                }
            }
        }
        return Math.max(max_so_far,curr_max);
    }
}