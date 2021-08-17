class Solution {
    public int[] sortedSquares(int[] nums) {
        Arrays.sort(nums);
        int[] aux = new int[nums.length];
        
        for(int i = 0 ; i < aux.length ; i++){
            aux[i] = nums[i] * nums[i];
        }
        Arrays.sort(aux);
        return aux;
    }
}