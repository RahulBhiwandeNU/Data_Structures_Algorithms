class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Map<Integer,Integer> mapRow = new HashMap<>();
        Map<Integer,Integer> mapCol = new HashMap<>();
        
        for(int i = 0; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(matrix[i][j] == 0){
                    if(!mapRow.containsKey(i))
                        mapRow.put(i,1);
                    if(!mapCol.containsKey(j))
                        mapCol.put(j,1);
                }
            }
        }
        
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(mapRow.containsKey(i) || mapCol.containsKey(j))
                    matrix[i][j] = 0;
            }
        }
    }
}