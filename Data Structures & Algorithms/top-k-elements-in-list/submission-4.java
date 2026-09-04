class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> m = new HashMap<>(); // val, counter
        for (int n : nums) {
            if (m.containsKey(n)) {
                m.replace(n, m.get(n)+1); 
            } else {
                m.put(n, 1);
            }
        }   

        Map<Integer, Integer> sortedByValuesMap = m.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue, 
            (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        int i = 0;
        int offset = m.size()-k; 
        int counter = 0; 
        for (Map.Entry<Integer, Integer> e : sortedByValuesMap.entrySet()) {
            if (counter < offset) {
                counter++; 
            } else {
                result[i] = e.getKey();
                i++; 
            }
        }
        return result; 
    }
}
