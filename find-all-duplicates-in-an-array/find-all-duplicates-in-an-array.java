class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            if(!map.containsKey(n))
                map.put(n,1);
            else
                map.put(n,map.get(n)+1);
        }
        Set<Integer> output = new HashSet<>();
        for(int n : nums){
            if(map.get(n) > 1)
                output.add(n);
        }
        List<Integer> res = new ArrayList<>();
        for(int o : output)
            res.add(o);
        return res;
    }
}