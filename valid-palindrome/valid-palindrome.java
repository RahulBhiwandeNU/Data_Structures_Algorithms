class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        
        for(char a : c){
            if(Character.isAlphabetic(a) || Character.isDigit(a))
                sb.append(Character.toLowerCase(a));
        }
        
        String res = sb.toString();
        
        if(res.length() == 1)
            return true;
        
        int i = 0;
        int j = res.length()-1;
        
        while(i < j){
            if(res.charAt(i) != res.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}