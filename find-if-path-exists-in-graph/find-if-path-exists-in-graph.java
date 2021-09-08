class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        LinkedList<Integer> adj[] = new LinkedList[n];
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        
        if(edges.length == 0)
            return true;
        
        for(int i = 0 ; i < n ; i++)
            adj[i] = new LinkedList();
        
        for(int i = 0 ; i < edges.length ; i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        
        st.push(start);
        while(!st.isEmpty()){
            int curr = st.pop();
            for(int neighbor : adj[curr]){
                if(!visited[neighbor]){
                    st.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        
        if(visited[end] == false)
            return false;
        return true;
    }
}