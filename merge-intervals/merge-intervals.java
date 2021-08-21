class Solution {
    public int[][] merge(int[][] intervals) {
        
        // make heap that sorts by the start of intervals
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        List<int[]> ints = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            pQ.offer(intervals[i]);
        }
        int[] currentInterval = pQ.poll();
        
        while (!pQ.isEmpty()) {
            int[] nextInterval = pQ.poll();
            if (nextInterval[0] > currentInterval[1]) {
                // no overlap: add current interval to list and continue to next interval
                ints.add(currentInterval);
                currentInterval = nextInterval;
            } else {
                // overlap: make current interval end at the max of the new and current interval
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            }
        }

        ints.add(currentInterval);
        return ints.toArray(new int[ints.size()][]);
        
    }
}