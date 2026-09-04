class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> m = new HashMap<>(); 
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (m.containsKey(val)) {
                result[0] = m.get(val); 
                result[1] = i; 
                return result; 
            }
            int diff = target-val;
            m.put(diff, i);
        }
        return result; 
    }
}
