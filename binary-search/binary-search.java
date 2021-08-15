class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }
    
    public int binarySearch(int[] nums,int low,int high,int target){
        
        while(low <= high){
            int mid = low + (high-low) / 2;
            
            if(nums[mid] == target)
                return mid;
            
            if(nums[mid] < target)
                low = mid + 1;
            
            if(nums[mid] > target)
                high = mid - 1;
        
        }
        return -1;
    }
}