class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        if(intervals.length == 0)
            return true;
        
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        
        for(int i = 1 ; i < intervals.length ; i++){
            if(intervals[i][0] >= pq.peek()){
                pq.poll();
                pq.add(intervals[i][1]);
            }
            else{
                pq.add(intervals[i][1]);
            }
        }
        if(pq.size() == 1)
            return true;
        return false;
    }
}