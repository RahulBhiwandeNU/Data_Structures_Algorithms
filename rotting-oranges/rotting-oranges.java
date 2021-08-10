class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j] == 2)
                    queue.add(new int[]{i,j,0});
            }
        }
        
        int level = 0;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            int currRow = curr[0];
            int currCol = curr[1];
            int currLevel = curr[2];
            
            if(currRow - 1 >= 0 && shouldVisit(grid,currRow - 1,currCol))
                queue.add(new int[]{currRow-1,currCol,currLevel+1});
            if(currCol - 1 >= 0 && shouldVisit(grid,currRow,currCol-1))
                queue.add(new int[]{currRow,currCol-1,currLevel+1});
            if(currCol + 1 < grid[0].length && shouldVisit(grid,currRow,currCol+1))
                queue.add(new int[]{currRow,currCol+1,currLevel+1});
            if(currRow + 1 < grid.length && shouldVisit(grid,currRow+1,currCol))
                queue.add(new int[]{currRow+1,currCol,currLevel+1});
            
            level = (level < currLevel) ? currLevel : level;
        }
        
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        
        return level;
        
    }
    
    public boolean shouldVisit(int[][] grid, int row, int col){
        if(grid[row][col] == 1){
            grid[row][col] = 2;
            return true;
        }
        return false;    
    }
}