class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //Sorting by Start time
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        
        //Storing elements in minHeap according to end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);
        
        for(int i = 1 ; i < intervals.length ; i++){
            if(intervals[i][0] >= minHeap.peek()){
                minHeap.poll();
                minHeap.add(intervals[i][1]);
            }
            else {
                minHeap.add(intervals[i][1]);
            }
            
        }
        return minHeap.size();
    }
}