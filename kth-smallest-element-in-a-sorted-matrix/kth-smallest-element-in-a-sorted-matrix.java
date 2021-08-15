class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                pq.add(matrix[i][j]);
            }
        }
        
        while(k != 1){
            pq.poll();
            k--;
        }
        
        return pq.peek();
    }
}