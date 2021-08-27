class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        Map<Integer,int[]> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i],new int[]{1,i,i});
            else {
                int[] temp = map.get(nums[i]);
                temp[0] += 1;
                temp[2] = i;
                map.put(nums[i],temp);
            }
        }
        
        int degree = Integer.MIN_VALUE;
        int res = Integer.MAX_VALUE;
        for(int[] t : map.values()){
            if(t[0] > degree){
                degree = t[0];
                res = t[2] - t[1] + 1;
            }
            else if(t[0] == degree)
                res = Math.min(res,t[2]-t[1]+1);
        }
        return res;
    }
}