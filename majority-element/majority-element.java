class Solution {
    public int majorityElement(int[] nums) {
        int l = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            if(!map.containsKey(n))
                map.put(n,1);
            else
                map.put(n,map.get(n)+1);
        }
        for(int n : nums){
            if(map.get(n) > l/2)
                return n;
        }
        return 0;
    }
}