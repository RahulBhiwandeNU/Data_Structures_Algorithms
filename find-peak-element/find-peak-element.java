class Solution {
    public int findPeakElement(int[] nums) {
        
        if(nums.length == 1)
            return 0;
        
        int[] aux = new int[nums.length+2];
        aux[0] = Integer.MIN_VALUE;
        aux[aux.length-1] = Integer.MIN_VALUE;
        
        for(int j = 1,i = 0 ; j < aux.length-1 && i < nums.length ; j++,i++)
            aux[j] = nums[i];
        
        for(int i = 1; i <= aux.length - 2; i++){
            if(aux[i] > aux[i-1] && aux[i] > aux[i+1])
                return i-1;
        }
        return 0;
    }   
}