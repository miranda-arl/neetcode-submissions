class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> m = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (m.containsKey(c)) {
                m.replace(c, m.get(c)+1);
            } else {
                m.put(c, 1);
            }
        }

        for (char tC: t.toCharArray()) {
            if (m.containsKey(tC)) {
                int val = m.get(tC);
                if (val == 0) return false;
                m.replace(tC, m.get(tC)-1);
            } else {
                return false;
            }
        }

        for (Map.Entry<Character, Integer> mEntry : m.entrySet()) {
            if (mEntry.getValue() != 0) return false;
        }
        return true; 
    }
}
