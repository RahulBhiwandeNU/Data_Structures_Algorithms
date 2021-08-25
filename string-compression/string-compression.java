class Solution {
    public int compress(char[] chars) {
        int i=0;
        int j=0;
        StringBuilder sb = new StringBuilder();
        
        while(j < chars.length){
            sb.append(chars[i]);
            while(j < chars.length && chars[j]==chars[i]){
                j++;
            }
            if((j-i) > 1){
                sb.append(j-i);
            }
            i=j;
        }
        
        String res = String.valueOf(sb);
        for(i=0; i<res.length(); i++)
            chars[i] = res.charAt(i);
        return res.length();
    }
}