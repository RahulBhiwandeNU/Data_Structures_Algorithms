class UF_WPCR {
    private int[] root;
    private int[] rank;
    private HashSet<Integer> set;
    
    public UF_WPCR(int size){
        root = new int[size+1];
        rank = new int[size+1];
        set = new HashSet<>();
        for(int i = 1 ; i <= size ; i++){
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
        for(int i = 1; i < root.length; i++) {
            int x = find(root[i]);
            set.add(x);
        }
        return set.size();
    }
    
    public boolean isConnected(int x , int y){
        return find(x) == find(y);
    }
}

class Solution {
    public int minimumCost(int N, int[][] connections) {
        UF_WPCR uf = new UF_WPCR(N);
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int cost = 0;
        for(int i = 0 ; i < connections.length ; ++i){
            if(uf.isConnected(connections[i][0],connections[i][1]))
                continue;
            uf.union(connections[i][0],connections[i][1]);
            cost += connections[i][2];
        }
        
        if(uf.connected() > 1)
            return -1;
        return cost;   
    }
}