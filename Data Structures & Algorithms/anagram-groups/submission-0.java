class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result; // = new ArrayList<>();
        Map<HashMap<Character, Integer>, List<String>> m = new HashMap<>();
        
        for (String s : strs) {
            HashMap<Character, Integer> sMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (sMap.containsKey(c)) {
                    sMap.replace(c, sMap.get(c)+1);
                } else {
                    sMap.put(c, 1);
                }
            }
            List<String> l;
            if (m.containsKey(sMap)) {
                l = m.get(sMap);
                l.add(s);
                m.replace(sMap, l);
            } else {
                l = new ArrayList();
                l.add(s);
                m.put(sMap, l);
            }
        }
        
        // System.out.println(m.values());
        result = new ArrayList(m.values());
        return result; 
    }
}
