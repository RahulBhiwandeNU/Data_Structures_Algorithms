class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        
        int x = 0 ; 
        int y = 0 ;
        
        int facing = 0;
        int n = directions.length;
        
        for(char c : instructions.toCharArray()){
            if(c == 'L')
                facing = (facing + 3) % n;
            else if(c == 'R')
                facing = (facing + 1) % n;
            else{
                x = x + directions[facing][0];
                y = y + directions[facing][1]; 
            }
        }
        
        if(x == 0 && y == 0 || facing != 0)
            return true;
        return false;
    }
}