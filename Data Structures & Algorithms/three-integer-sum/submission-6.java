class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (target == sum) {
                    if (i != j && i != k) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        if (!result.contains(l)) {
                            result.add(l); 
                        }
                    }
                    j++;
                    k--;
                } else if (target > sum) {
                    j++;
                } else if (target < sum) {
                    k--;
                }
            }
        }
        return result;
    }
}
