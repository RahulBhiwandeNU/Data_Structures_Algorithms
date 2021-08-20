class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty()) return 0;
        final int N = s.length();
        if (k >= N) return N;
        int[] count = new int[26];
        int res = 0;
        int left = 0, right = 0;
        int maxCount = 0; // the max count in the sliding window
        while (right < N) {
            int ch = s.charAt(right) - 'A';
            count[ch]++;
            maxCount = Math.max(maxCount, count[ch]);
            if (right - left + 1 > maxCount + k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}