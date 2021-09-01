class UF_WPCR {
    private int[] root;
    private int[] rank;
    private HashSet<Integer> set;
    
    public UF_WPCR(int size){
        root = new int[size];
        rank = new int[size];
        set = new HashSet<>();
        for(int i = 0 ; i < size ; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x){
        if(x == root[x])
            return x;
        return root[x] = find(root[x]);
    }
    
    public void union(int x , int y){
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY])
                root[rootY] = rootX;
            else if(rank[rootX] < rank[rootY])
                root[rootX] = rootY;
            else {
                root[rootX] = rootY;
                rank[rootY] += 1;
            }
        }
    }
    
    public int connected(){
        for(int i = 0; i < root.length; i++) {
            int x = find(root[i]);
            set.add(x);
        }
        return set.size();
    }
}

class Solution {
   
    public int findCircleNum(int[][] isConnected) {
        UF_WPCR s = new UF_WPCR(isConnected.length);  
        Set<Integer> set = new HashSet<>();
            
        int row = isConnected.length;
        int col = isConnected[0].length;
        
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(isConnected[i][j] == 1)
                    s.union(i,j);
            }
        }
        return s.connected();
    }
}