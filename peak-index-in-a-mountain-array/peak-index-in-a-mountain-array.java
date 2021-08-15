class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        for(int i = 1 ; i <= arr.length - 1 ; i++){
            if(arr[i] < arr[i-1])
                return i-1;
        }
        return n;
    }
}