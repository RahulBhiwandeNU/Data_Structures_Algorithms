class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b) -> b[1] - a[1]);
        int max_units = 0;
        for(int i = 0 ; i < boxTypes.length ; i++){
            int min = Math.min(truckSize,boxTypes[i][0]);
            max_units += min * boxTypes[i][1];
            truckSize -= min;
            if(truckSize == 0)
                break;
        }
        return max_units;
    }
}