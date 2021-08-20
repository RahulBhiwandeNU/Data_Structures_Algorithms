class Solution {
    public boolean isAnagram(String s, String t) {
        int[] s_freq = new int[26];
        int[] t_freq = new int[26];
        
        if(s.length() != t.length())
            return false;
        
        for(char c : s.toCharArray()){
            s_freq[c - 'a']++;
        }
        
        for(char c : t.toCharArray()){
            t_freq[c - 'a']++;
        }
        
        for(int i = 0 ; i < s_freq.length ; i++){
            if(s_freq[i] != t_freq[i])
                return false;
        }
        return true;
    }
}