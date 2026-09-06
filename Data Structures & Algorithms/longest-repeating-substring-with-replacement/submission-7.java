class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() <= k) return s.length(); 

        int maxFreq = 1; 
        int l = 0; 
        int r = 0; 
        HashMap<Character, Integer> m = new HashMap<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            int freq = m.getOrDefault(c, 0);
            m.put(c, freq+1);

            maxFreq = Math.max(maxFreq, freq+1);

            while ((r-l+1)-maxFreq > k) {
                char lChar = s.charAt(l);
                m.replace(lChar, m.get(lChar)-1); 
                l++;
            } // valid window
            r++;
        }
        return r-l;
    }
}
