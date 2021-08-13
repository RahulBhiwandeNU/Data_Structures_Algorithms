class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i],0);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 1 ; i <= nums.length ; i++){
            if(!map.containsKey(i))
                res.add(i);
        }
        return res;
    }
}