class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c != '#')
                st1.push(c);
            else{
                if(!st1.isEmpty())
                    st1.pop();
            }
        }
        
        for(char c : t.toCharArray()){
            if(c != '#')
                st2.push(c);
            else{
                if(!st2.isEmpty())
                    st2.pop();
            }
        }
        
        while(!st1.isEmpty()){
            char c = st1.pop();
            sb1.append(c);
        }
        
        while(!st2.isEmpty()){
            char c = st2.pop();
            sb2.append(c);
        }
        
        if(sb1.toString().equals(sb2.toString()))
            return true;
        return false;
    }
}