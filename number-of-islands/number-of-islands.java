class Solution {
    
    public void dfs(char[][] grid , int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;
        
        if(r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0')
            return;
        
        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
        
    }
    
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int islands = 0;
        
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j] == '1'){
                    islands++;
                    dfs(grid,i,j);
                }
            }
        }
        return islands;
    }
}