class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0; 
        Map<Character, Integer> charsSeen = new HashMap<>();
        charsSeen.put(s.charAt(0), 0);

        int maxChars = 1; 
        int counter = 1; 
        int start = 0; 

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charsSeen.containsKey(c)) {
                charsSeen.put(c, i);
                counter++;
            } else if (charsSeen.get(c) < start) {
                charsSeen.replace(c, i);
                counter++;
            } else {
                start = charsSeen.get(c);
                charsSeen.replace(c, i);
                maxChars = Math.max(counter, maxChars);
                counter = i - start;
            }
        }
        return Math.max(counter, maxChars);
    }
}
