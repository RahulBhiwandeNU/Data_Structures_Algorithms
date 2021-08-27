class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int n : nums){
            if(!map.containsKey(n))
                map.put(n,1);
            else
                map.put(n,map.get(n)+1);
        }
        
        int count = 0;        
        for(Map.Entry <Integer, Integer> entry: map.entrySet()){
            int x = entry.getKey();
            int val = entry.getValue();
            if(map.containsKey(x+k) && k > 0)
                count++;
            else if(k == 0 && val > 1){
                count++;
            }
        }
        
        return count;
    }
}