public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0 ; 
        int j = 0;
        int res = 0;
        int[] nums = new int[128];
        while(j < s.length()){
            char a = s.charAt(j);
            nums[a]++;
            while(nums[a] > 1){
                char b = s.charAt(i);
                nums[b]--;
                i++;
            }
            res = Math.max(res , j - i + 1);
            j++;
        }
        return res;
    }
}