class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() <= k) return s.length(); 

        if (k == 0) {
            int count = 1; 
            int maxCount = 1; 
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i-1) == s.charAt(i)) count++;
                else {
                    maxCount = Math.max(maxCount, count);
                    count = 1; 
                }
            }
            return Math.max(maxCount, count);
        }
        int maxFreq = 1; 
        int l = 0; 
        int r = 0; 
        HashMap<Character, Integer> m = new HashMap<>();
        while (r < s.length()) {
            // System.out.println("r b4="+r);
            char c = s.charAt(r);
            int freq = m.getOrDefault(c, 0);
            m.put(c, freq+1);

            maxFreq = Math.max(maxFreq, freq+1);

            while ((r-l+1)-maxFreq > k) {
            System.out.println("(r-l+1)-maxFreq="+((r-l+1)-maxFreq));
                System.out.println("r="+r+" l="+l);
                //l++;
                char lChar = s.charAt(l);
                m.replace(lChar, m.get(lChar)-1); 
                l++;
            } // valid window
            r++;
            // System.out.println("r after="+r);
        }
        return r-l;
    }
}
