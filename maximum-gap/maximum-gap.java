class Solution {
    public int maximumGap(int[] nums) {
        
        if(nums.length < 2)
            return 0;
        
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1 ; i <= nums.length - 1 ; i++){
            list.add(nums[i] - nums[i-1]);
        }
        
        return Collections.max(list);
    }
}