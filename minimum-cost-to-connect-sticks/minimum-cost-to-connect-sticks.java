class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int n : sticks)
            pq.add(n);
        
        int min_cost = 0;
        
        while(pq.size() != 1){
            int a = pq.poll();
            int b = pq.poll();
            min_cost += (a+b);
            pq.add(a+b);
        }
        
        return min_cost;
    }
}