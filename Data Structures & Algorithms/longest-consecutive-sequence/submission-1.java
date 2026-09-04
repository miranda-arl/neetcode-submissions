class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> s = 
            Arrays.stream(nums).boxed()
            .collect(Collectors.toCollection(HashSet::new));
        
        System.out.println("s="+s); 

        HashSet<Integer> starts = new HashSet<>();
        for (int n : nums) {
            if (!s.contains(n-1)) {
                starts.add(n);
            }
        }

        int maxAmount = 0;
        List<Integer> startList = new ArrayList<>(starts);
        System.out.println("startList="+startList); 
        for (int start: startList) {
            int amount = 1;
            int val = start+1;
            while (s.contains(val)) {
                amount++;
                val++; 
            }
            if (amount > maxAmount) maxAmount = amount;
        }
        return maxAmount; 
    }
}
