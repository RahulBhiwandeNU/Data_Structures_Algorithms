class Solution {
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int n : nums){
            if(n % 2 == 0)
                res.add(n);
        }
        for(int n : nums){
            if(n % 2 != 0)
                res.add(n);
        }
        
        for(int i = 0 ; i < nums.length ; i++)
            nums[i] = res.get(i);
        
        return nums;
    }
}