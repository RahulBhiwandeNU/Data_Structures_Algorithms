class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            if(!map.containsKey(n))
                map.put(n,1);
            else
                map.put(n,map.get(n) + 1);
        }
        for(int a : nums){
            if(map.get(a) > 1)
                return true;
        }
        return false;
    }
}