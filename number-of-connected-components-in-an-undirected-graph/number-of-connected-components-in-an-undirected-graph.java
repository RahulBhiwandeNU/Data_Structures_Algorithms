class UF_WPCR {
    int[] root;
    int[] rank;
    Set<Integer> set;
    
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
    
    public int no_of_components(){
        for(int i = 0 ; i < root.length ; i++){
            int x = find(root[i]);
            set.add(x);
        }
        return set.size();
    }
}


class Solution {
    public int countComponents(int n, int[][] edges) {
        UF_WPCR uf = new UF_WPCR(n);
        
        for(int i = 0 ; i < edges.length ; i++){
            uf.union(edges[i][0],edges[i][1]);
        }
        
        return uf.no_of_components();
    }
}