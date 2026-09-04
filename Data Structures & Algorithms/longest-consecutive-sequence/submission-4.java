class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> s = new HashSet<>();

        for (int n : nums) {
            s.add(n);
        }

        int maxAmount = 0;
        for (int n : nums) {
            if (!s.contains(n-1)) {
                int amount = 1;
                int val = n+1;
                while (s.contains(val)) {
                    amount++;
                    val++; 
                }
                maxAmount = Math.max(amount, maxAmount);
            }
        }
        return maxAmount; 
    }
}
