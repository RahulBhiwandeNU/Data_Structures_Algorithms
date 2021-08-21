class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> m1 = new HashMap<>();
        Map<Integer,Integer> m2 = new HashMap<>();
        
        for(int n : nums1){
            if(!m1.containsKey(n))
                m1.put(n,0);
        }
        
        for(int n : nums2){
            if(!m2.containsKey(n))
                m2.put(n,0);
        }
        
        int flag = 0;
        List<Integer> res = new ArrayList<>();
        
        if(nums1.length > nums2.length)
            flag = 1;
        else
            flag = 2;
        
        if(flag == 1){
            for(int i = 0 ; i < nums1.length ; i++){
                if(m2.containsKey(nums1[i]) && m2.get(nums1[i]) == 0){
                    res.add(nums1[i]);
                    m2.put(nums1[i],1);
                }
            }
        }
        else {
            for(int i = 0 ; i < nums2.length ; i++){
                if(m1.containsKey(nums2[i]) && m1.get(nums2[i]) == 0){
                    res.add(nums2[i]);
                    m1.put(nums2[i],1);
                }
            }
        }
        
        int[] output = new int[res.size()];
        
        for(int i = 0 ; i < output.length ; i++){
            output[i] = res.get(i);
        }
        
        return output;
    }
}