class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>(); // val, counter
        for (int n : nums) {
            m.put(n, m.getOrDefault(n, 0)+1); 
        }   

        List<Integer>[] buckets = new List[nums.length+1];
        for (int num : m.keySet()) {
            int frequency = m.get(num);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList(); 
            }
            buckets[frequency].add(num); 
        }

        int[] result = new int[k];
        int index = 0; 
        for (int i = buckets.length-1; i >= 0 && index < k; i--) {
            List<Integer> b = buckets[i];
            if (b != null) {
                for (int num : b) {
                  result[index] = num;  
                  index++; 
                }
            }
        }
        return result; 
    }
}
